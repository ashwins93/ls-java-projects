package com.lambdaschool.javazoos.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.models.Telephone;
import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.models.ZooAnimal;
import com.lambdaschool.javazoos.repositories.ZooRepository;

@Service(value = "zooService")
@Transactional
public class ZooServiceImpl implements ZooService {
	@Autowired
	private ZooRepository zooRepo;

	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private UserAuditing userAuditing;

	@Override
	public List<Zoo> findAllZoos() {
		List<Zoo> zoos = new ArrayList<Zoo>();
		zooRepo.findAll().iterator().forEachRemaining(zoos::add);
		return zoos;
	}

	@Override
	public Zoo findZooById(long id) {
		Zoo zoo = zooRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Invalid zoo id " + id));
		return zoo;
	}

	@Override
	@Transactional
	public Zoo saveZoo(Zoo zoo) {
		Zoo newZoo = new Zoo();

		newZoo.setZooname(zoo.getZooname().get());

		for (Telephone t : zoo.getTelephones()) {
			Telephone newTele = new Telephone(t.getPhonenumber(), t.getPhonetype(), newZoo);
			newZoo.getTelephones().add(newTele);
		}

		for (ZooAnimal z : zoo.getAnimals()) {
			Animal animal = animalService.findAnimalById(z.getAnimal().getAnimalid());
			ZooAnimal newZooAnimal = new ZooAnimal(newZoo, animal, z.getIncomingzoo());
			newZoo.getAnimals().add(newZooAnimal);
		}

		return zooRepo.save(newZoo);
	}

	@Override
	@Transactional
	public void deleteZooById(long id) {
		findZooById(id);
		zooRepo.deleteById(id);
	}

	@Override
	@Transactional
	public Zoo updateZoo(Zoo zoo, long id) {
		Zoo updatedZoo = findZooById(id);

		zoo.getZooname().ifPresent(updatedZoo::setZooname);

		if (zoo.getTelephones().size() > 0) {
			updatedZoo.getTelephones().clear();
			for (Telephone t : zoo.getTelephones()) {
				Telephone newTele = new Telephone(t.getPhonenumber(), t.getPhonetype(), updatedZoo);
				updatedZoo.getTelephones().add(newTele);
			}
		}

		if (zoo.getAnimals().size() > 0) {
			for(ZooAnimal z: updatedZoo.getAnimals()) {
				zooRepo.deleteZooAnimal(updatedZoo.getZooid(), z.getAnimal().getAnimalid());
			}
			for (ZooAnimal z : zoo.getAnimals()) {
				Animal animal = animalService.findAnimalById(z.getAnimal().getAnimalid());
				zooRepo.addZooAnimal(
						updatedZoo.getZooid(),
						animal.getAnimalid(), 
						z.getIncomingzoo(),
						userAuditing.getCurrentAuditor().get());
				
			}
		}

		return zooRepo.save(updatedZoo);
	}

	@Override
	public List<Zoo> searchZooByName(String zooname) {
		List<Zoo> results = new ArrayList<>();
		zooRepo.findByZoonameContainingIgnoreCase(zooname)
			.iterator()
			.forEachRemaining(results::add);
		return results;
	}

	@Override
	public void deleteZooAnimalCombo(long zooid, long animalid) {
		findZooById(zooid);
		animalService.findAnimalById(animalid);
		
		zooRepo.deleteZooAnimal(zooid, animalid);
	}

	@Override
	public void addZooAnimalCombo(long zooid, long animalid, String incomingzoo) {
		findZooById(zooid);
		animalService.findAnimalById(animalid);
		String uname = userAuditing.getCurrentAuditor().get();
		
		zooRepo.addZooAnimal(zooid, animalid, incomingzoo, uname);
	}
}