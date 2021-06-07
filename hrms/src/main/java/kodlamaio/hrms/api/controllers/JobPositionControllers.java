package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/hrms/jobPosition")
public class JobPositionControllers {

	private JobPositionService JobPositionService;

	@Autowired
	public JobPositionControllers(JobPositionService JobPositionService) {
		super();
		this.JobPositionService = JobPositionService;

	}

	@GetMapping("/GetAll")
	public DataResult<List<JobPosition>> jobPositionGetAll() {
		return this.JobPositionService.getAll();
	}

	@PostMapping("/Add")
	public Result jobPositionAdd(@RequestBody JobPosition jobPosition) {
		return this.JobPositionService.add(jobPosition);
	}

	
}
