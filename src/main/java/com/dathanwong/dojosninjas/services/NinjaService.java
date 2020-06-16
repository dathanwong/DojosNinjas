package com.dathanwong.dojosninjas.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dathanwong.dojosninjas.models.Ninja;
import com.dathanwong.dojosninjas.repositories.NinjaRepository;

@Service
@Transactional
public class NinjaService {
	
	private final NinjaRepository repo;
	private static final int PAGE_SIZE = 5;
	
	public NinjaService(NinjaRepository repo) {
		this.repo = repo;
	}
	
	public Page<Ninja> ninjasPerPage(int pageNumber){
		PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE);
		Page<Ninja> ninjas = repo.findAll(pageRequest);
		return repo.findAll(pageRequest);
	}
	
	public List<Ninja> findAll(){
		return repo.findAll();
	}
	
	public void create(Ninja ninja) {
		repo.save(ninja);
		return;
	}
	
	public Page<Object[]> findNinjaDojos(int pageNumber){
		PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE);
		Page<Object[]> objects = repo.joinNinjasAndDojos(pageRequest);
		return objects;
	}
}
