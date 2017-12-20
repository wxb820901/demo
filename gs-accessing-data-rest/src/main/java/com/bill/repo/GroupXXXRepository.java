package com.bill.repo;

import com.bill.entity.GroupXXX;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "group", path = "group")
public interface GroupXXXRepository extends PagingAndSortingRepository<GroupXXX, Long> {

	List<GroupXXX> findByGroupName(@Param("name") String name);

}
