package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Werknemer;
import be.vdab.formbackingobjects.Opslag;
import be.vdab.services.WerknemerService;

@Controller
@RequestMapping("/werknemers")
public class WerknemerController {
	
	// VIEW PATHS
	private static final String WERKNEMER_VIEW = "werknemers/werknemer";
	private static final String OPSLAG_VIEW = "werknemers/opslag";
	
	private static final String REDIRECT_NA_OPSLAG = "redirect:/werknemers/werknemer/{%d}";
	
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
	
	@RequestMapping(method = RequestMethod.GET, path = "{werknemer}/opslag")
	ModelAndView opslagForm(@PathVariable Werknemer werknemer) {
		return new ModelAndView(OPSLAG_VIEW)
				.addObject("werknemer", werknemerService.read(werknemer.getId()))
				.addObject("opslag", new Opslag());
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "{werknemer}/opslag")
	ModelAndView opslag(@PathVariable Werknemer werknemer, Opslag opslag) {
		werknemerService.opslag(werknemer, opslag.getBedrag());
		return new ModelAndView(String.format(REDIRECT_NA_OPSLAG, werknemer.getId()));
	}

}
