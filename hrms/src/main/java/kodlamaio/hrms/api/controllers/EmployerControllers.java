package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.HrmsVerification;

@RestController
@RequestMapping("/hrms/employer")
public class EmployerControllers {
	
	private EmployerService employerService;
	
	@Autowired
	public EmployerControllers(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	
	@GetMapping("/GetAll")
	public DataResult<List<Employer>> employerGetAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/Register")
	public Result employerAdd(@RequestBody Employer employer, HrmsVerification hrmsVerification, EmailVerification emailVerification) {
		return this.employerService.register(employer,hrmsVerification, emailVerification);
	}
}
