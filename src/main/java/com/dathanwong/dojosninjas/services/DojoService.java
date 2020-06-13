package com.dathanwong.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dathanwong.dojosninjas.models.Dojo;
import com.dathanwong.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository repo;
	
	public DojoService(DojoRepository repo) {
		this.repo = repo;
	}
	
	public List<Dojo> findAll(){
		return repo.findAll();
	}
	
	public void create(Dojo dojo) {
		repo.save(dojo);
		return; 
	}
	
	public Dojo findById(Long id) {
		Optional<Dojo> dojo = repo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}else {
			return null;
		}
	}
}
