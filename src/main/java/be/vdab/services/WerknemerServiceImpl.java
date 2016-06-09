package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;

import be.vdab.entities.Werknemer;
import be.vdab.repositories.WerknemerRepository;

@ReadOnlyTransactionalService
public class WerknemerServiceImpl implements WerknemerService {
	
	private WerknemerRepository werknemerRepository;
	
	@Autowired
	public WerknemerServiceImpl(WerknemerRepository werknemerRepository) {
		this.werknemerRepository = werknemerRepository;
	}

	@Override
	public Werknemer read(long id) {
		return werknemerRepository.findOne(id);
	}

	@Override
	public Werknemer readHighestInHierarchy() {
		return werknemerRepository.findByChefIsNull();
	}
	

}
