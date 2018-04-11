package controllers;

import services.AdministratorService;
import play.mvc.Result;
import play.db.jpa.Transactional;

import javax.inject.Inject;
import play.mvc.Http;

/**
 * The type Administrator controller.
 */
public class AdministratorController extends BaseController {

	private AdministratorService service;

	/**
	 * Sets service.
	 *
	 * @param service the service
	 */
	@Inject
	public void setService(final AdministratorService service) {
		this.service = service;
	}

	@Transactional
	public Result getAdminStats() {
				return wrapForAdmin(() -> this.service.getAdminStats());
			}
}
