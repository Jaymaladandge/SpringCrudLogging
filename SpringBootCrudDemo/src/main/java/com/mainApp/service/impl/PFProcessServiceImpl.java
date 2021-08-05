package com.mainApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mainApp.repo.PFProcessRepository;
import com.mainApp.model.PFProcess;
import com.mainApp.service.PFProcessService;

@Service
@Transactional(propagation=Propagation.MANDATORY)
public class PFProcessServiceImpl implements PFProcessService {

	@Autowired
	PFProcessRepository processRepo;

	@Override
	public PFProcess startPFProcess(PFProcess process) {
		return processRepo.save(process);
	}

	@Override
	public ResponseEntity<PFProcess> stopPFProcess(long id) {
		PFProcess process = processRepo.getOne(id);
		processRepo.delete(process);
		return ResponseEntity.ok().build();
	}

	@Override
	public PFProcess getProcessById(long id) {
		return processRepo.getOne(id);
	}

}
