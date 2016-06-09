package be.vdab.services;

import be.vdab.entities.Werknemer;

public interface WerknemerService {
	
	Werknemer read(long id);
	Werknemer readHighestInHierarchy();

}
