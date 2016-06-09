package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Werknemer;
import be.vdab.services.WerknemerService;

@Controller
@RequestMapping("/werknemers")
public class WerknemerController {
	
	// VIEW PATHS
	private static final String WERKNEMER_VIEW = "werknemers/werknemer";
	
	// SERVICES
	private final WerknemerService werknemerService; 
	
	// CONSTRUCTOR
	@Autowired
	public WerknemerController(WerknemerService werknemerService) {
		this.werknemerService = werknemerService;
	}
	
	// REQUEST HANDLERS
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView findHighestInHierarchy() {
		return new ModelAndView(WERKNEMER_VIEW, "werknemer", werknemerService.readHighestInHierarchy());
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{werknemer}")
	ModelAndView findWerknemer(@PathVariable Werknemer werknemer) {
		return new ModelAndView(WERKNEMER_VIEW, "werknemer", werknemerService.read(werknemer.getId()));
	}

}
