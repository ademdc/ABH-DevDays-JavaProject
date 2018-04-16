package services;

import org.hibernate.Session;
import org.hibernate.jpa.HibernateEntityManager;
import play.db.jpa.JPA;

import java.util.Base64;

import java.sql.Timestamp;
import play.Logger;
import models.tables.Log;

/**
 * The type Base service.
 */
public abstract class BaseService {

	/**
	 * Gets session.
	 *
	 * @return the session
	 */
	public Session getSession() {
		return ((HibernateEntityManager) JPA.em()).getSession();
	}

	/**
	 * Base 64 encode string.
	 *
	 * @param bytes the bytes
	 * @return the string
	 */
	String base64Encode(final byte[] bytes) {
		return Base64.getEncoder().encodeToString(bytes);
	}

	/**
	 * Base 64 decode byte [ ].
	 *
	 * @param string the string
	 * @return the byte [ ]
	 */
	byte[] base64Decode(final String string) {
		return Base64.getDecoder().decode(string);
	}

	public void log(String message) {
		Log log = new Log();
		log.setLogging_time(System.currentTimeMillis());
		log.setDescription(message);
		String s = String.valueOf(log.getLogging_time());
		this.getSession().save(log);
	}

}