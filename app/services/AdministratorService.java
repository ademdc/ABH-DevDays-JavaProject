package services;

import javax.inject.Inject;
import javax.inject.Singleton;
import org.hibernate.criterion.Restrictions;
import play.mvc.Result;

import models.helpers.AdministratorStatistics;
import models.tables.*;

import org.hibernate.criterion.Projections;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.UUID;
import play.Logger;
import java.util.HashMap;
import java.util.Map;
import models.tables.Log;
import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.*;
import models.tables.City;

import play.db.jpa.JPA;

/**
 * The type Administrator service.
 */
@Singleton
public class AdministratorService extends BaseService {
	private static final String ORDER_KEY = "logging_time";

	@Inject
	private AdministratorService() { }

	/**
	 +	 * Delete picture
	 +	 *
	 +	 * @param id the id
	 +	 *
	 +	 */
	public boolean deletePicture(final UUID id) throws Exception {
				RestaurantPhoto restaurantPhoto = (RestaurantPhoto) getSession().createCriteria(RestaurantPhoto.class)
								.add(Restrictions.eq("id", id))
								.uniqueResult();
				getSession().delete(restaurantPhoto);
				String path = restaurantPhoto.getPath().replace("http://localhost:9000","");
				path = new StringBuilder(path).insert(0,"public").toString();
				Files.delete(Paths.get(path));
				return true;
			}
	final Map<String, Long> restaurant = new HashMap<>();

	public Map<String, Long> getAdminStats(){
		      Long noOfRestaurants = Long.valueOf(getSession().createCriteria(Restaurant.class)
				                .setProjection(Projections.rowCount())
				                .uniqueResult().toString());
		      Long noOfLocations = Long.valueOf(getSession().createCriteria(City.class)
				                .setProjection(Projections.rowCount())
				                .uniqueResult().toString());
		      Long noOfUsers = Long.valueOf(getSession().createCriteria(User.class)
				                .setProjection(Projections.rowCount())
				                .uniqueResult().toString());
		      Long noOfCuisines = Long.valueOf(getSession().createCriteria(Cuisine.class)
				                .setProjection(Projections.rowCount())
				                .uniqueResult().toString());

				restaurant.put("noOfRestaurants", noOfRestaurants);
				restaurant.put("noOfLocations", noOfLocations);
				restaurant.put("noOfUsers", noOfUsers);
				restaurant.put("noOfCuisines", noOfCuisines);

		        return restaurant;
		  	}


	public List<Log> getLogs() {
		return (List<Log>) getSession().createCriteria(Log.class)
				.addOrder(Order.asc(ORDER_KEY))
				.list();

	}

}
