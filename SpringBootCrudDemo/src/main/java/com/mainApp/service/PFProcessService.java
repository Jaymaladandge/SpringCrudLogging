package com.mainApp.service;

import org.springframework.http.ResponseEntity;

import com.mainApp.model.PFProcess;

public interface PFProcessService {

	PFProcess startPFProcess(PFProcess process);
	ResponseEntity<PFProcess> stopPFProcess(long id);
	PFProcess getProcessById(long id);
}
