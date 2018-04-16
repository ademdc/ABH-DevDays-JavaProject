package controllers;

import services.AdministratorService;
import play.mvc.Result;
import play.db.jpa.Transactional;

import javax.inject.Inject;
import play.mvc.Http;
import play.Logger;

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

	@Transactional(readOnly=true)
	public Result getAdminStats() {
				return wrapForPublic(() -> this.service.getAdminStats());
			}
	@Transactional(readOnly=true)
	public Result getLogs() {
		return wrapForPublic(() -> this.service.getLogs());
	}
}
