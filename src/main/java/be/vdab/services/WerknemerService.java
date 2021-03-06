package be.vdab.services;

import java.math.BigDecimal;

import be.vdab.entities.Werknemer;

public interface WerknemerService {
	
	Werknemer read(long id);
	Werknemer readHighestInHierarchy();
	void opslag(Werknemer werknemer, BigDecimal bedrag);

}
