package com.dathanwong.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dathanwong.dojosninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>, PagingAndSortingRepository<Ninja, Long>{
	List<Ninja> findAll();
	
	@Query("SELECT n, d FROM Ninja n JOIN n.dojo d ORDER BY d.name ASC")
	Page<Object[]> joinNinjasAndDojos(PageRequest pageRequest);
}
