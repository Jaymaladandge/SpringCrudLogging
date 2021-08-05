package com.mainApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainApp.model.PFProcess;

@Repository
public interface PFProcessRepository extends JpaRepository<PFProcess, Long>{

}
