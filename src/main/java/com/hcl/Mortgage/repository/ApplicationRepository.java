package com.hcl.Mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hcl.Mortgage.entity.Applications;

@Repository
@RepositoryRestResource(collectionResourceRel = "mortgage", path = "mortgage")
public interface ApplicationRepository extends JpaRepository<Applications,Long>{

}
