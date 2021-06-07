package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/hrms/jobAdvertisement")
public class JobAdvertisementControllers {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementControllers(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/GetAll")
	public DataResult<List<JobAdvertisement>> jobAdvertisementGetAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/GetAllActive")
	public DataResult<List<JobAdvertisement>> jobAdvertisementGetAllActive(){
		return this.jobAdvertisementService.getByIsActive();
	}
	
	@PostMapping("/Add")
	public Result jobAdvertisementAdd(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	
	@GetMapping("/GetAllSortedByDeadline")
	public DataResult<List<JobAdvertisement>> getAllSortedByDeadline(){
		return this.jobAdvertisementService.getAllSortedByDeadline();
	}
	
	@GetMapping("/getBycompanyNameAndIsActive")
	public DataResult<List<JobAdvertisement>> getBycompanyNameAndIsActive(@RequestParam("companyName") String companyName){
		return this.jobAdvertisementService.getByEmployer_CompanyNameAndIsActive(companyName);
	}
	
	@PostMapping("/IsActive")
	public Result update(int id , boolean isAvtice) {
		return this.jobAdvertisementService.update(id, isAvtice);
	}
	
}
