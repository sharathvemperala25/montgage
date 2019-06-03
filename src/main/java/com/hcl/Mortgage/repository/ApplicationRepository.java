package com.hcl.Mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.Mortgage.entity.Applications;

public interface ApplicationRepository extends JpaRepository<Applications,Long>{

}
