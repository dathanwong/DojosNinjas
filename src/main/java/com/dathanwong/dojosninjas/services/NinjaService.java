package com.dathanwong.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dathanwong.dojosninjas.models.Ninja;
import com.dathanwong.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private final NinjaRepository repo;
	
	public NinjaService(NinjaRepository repo) {
		this.repo = repo;
	}
	
	public List<Ninja> findAll(){
		return repo.findAll();
	}
	
	public void create(Ninja ninja) {
		repo.save(ninja);
		return;
	}
}
