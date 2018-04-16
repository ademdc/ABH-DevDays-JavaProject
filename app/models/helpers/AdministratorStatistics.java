package models.helpers;

/**
 * The type Administrator statistics.
 */
public class AdministratorStatistics {


	private Integer numberOfRestaurants;
	private Integer numberOfUsers;
	private Integer numberOfLocations;
	private Integer numberOfCuisines;

	private AdministratorStatistics() {}

	public static AdministratorStatistics createStats()  { return  new AdministratorStatistics(); }

	/**
	 *
	 * @return the number of restaurants
	 */
	public Integer getNumberOfRestaurants() {
		return numberOfRestaurants;
	}

	/**
	 *
	 * @param numberOfRestaurants the number of Restaurants
	 * @return The number of restaurants
	 */
	public AdministratorStatistics setRestaurants(Integer numberOfRestaurants) {
		this.numberOfRestaurants = numberOfRestaurants;
		return this;
	}

	/**
	 *
	 * @return the number of Users
	 */
	public Integer getNumberOfUsers() {
		return numberOfUsers;
	}

	/**
	 *
	 * @param numberOfUsers the number of Users
	 * @return the number of users
	 */
	public AdministratorStatistics setUsers(Integer numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
		return this;
	}

	/**
	 *
	 * @return the number of locations
	 */
	public Integer getNumberOfLocations() {
		return numberOfLocations;
	}

	/**
	 *
	 * @param numberOfLocations
	 * @return the number of locations
	 */
	public AdministratorStatistics setLocations(Integer numberOfLocations) {
		this.numberOfLocations = numberOfLocations;
		return this;
	}

	/**
	 *
	 * @return the number of Cuisines
	 */
	public Integer getNumberOfCuisines() {
		return numberOfCuisines;
	}

	/**
	 * @param numberOfCuisines
	 * @return the numberOfCuisines
	 */
	public AdministratorStatistics setCuisines(Integer numberOfCuisines) {
		this.numberOfCuisines = numberOfCuisines;
		return this;
	}
}