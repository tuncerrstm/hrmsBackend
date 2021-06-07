package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobFindingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.JobFinding;
import kodlamaio.hrms.entities.concretes.MernisVerification;

@RestController
@RequestMapping("/hrms/jobFinding")
public class JobFindingControllers {

	private JobFindingService jobFindingService;
	
	@Autowired
	public JobFindingControllers(JobFindingService jobFindingService) {
		super();
		this.jobFindingService = jobFindingService;
	}
	
	@GetMapping("/GetAll")
	public DataResult<List<JobFinding>> jobFindinggetAll(){
		return this.jobFindingService.getAll();
	}
	
	@PostMapping("/Register")
	public Result add(@RequestBody JobFinding jobFinding, EmailVerification emailVerification, MernisVerification mernisVerification) {
		return this.jobFindingService.register(jobFinding , emailVerification, mernisVerification);
	}
}
