package com.bill.repo;

import com.bill.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	List<Person> findByLastName(@Param("name") String name);
	List<Person> findByLeader_Id(@Param("id") long id);
	List<Person> findByGroupXXX_Id(@Param("id") long id);



}
