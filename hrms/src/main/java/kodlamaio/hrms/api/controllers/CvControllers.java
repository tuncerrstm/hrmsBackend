package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.resumeCv.CvService;
import kodlamaio.hrms.business.abstracts.resumeCv.ForeignLanguageService;
import kodlamaio.hrms.business.abstracts.resumeCv.JobExperienceService;
import kodlamaio.hrms.business.abstracts.resumeCv.ProgrammingLanguageService;
import kodlamaio.hrms.business.abstracts.resumeCv.SchoolCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.resumeCv.Cv;
import kodlamaio.hrms.entities.concretes.resumeCv.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.resumeCv.JobExperience;
import kodlamaio.hrms.entities.concretes.resumeCv.ProgrammingLanguage;
import kodlamaio.hrms.entities.concretes.resumeCv.SchoolCv;

@RestController
@RequestMapping("/hrms/cv")
public class CvControllers {

	private CvService cvService;
	private SchoolCvService schoolCvService;
	private JobExperienceService jobExperienceService;
	private ForeignLanguageService foreignLanguageSerivce;
	private ProgrammingLanguageService programmingLanguageService;


	@Autowired
	public CvControllers(CvService cvService, SchoolCvService schoolCvService, JobExperienceService jobExperienceService, ForeignLanguageService foreignLanguageSerivce,
			ProgrammingLanguageService programmingLanguageService) {
		super();
		this.cvService = cvService;
		this.schoolCvService = schoolCvService;
		this.jobExperienceService = jobExperienceService;
		this.foreignLanguageSerivce = foreignLanguageSerivce;
		this.programmingLanguageService = programmingLanguageService;
		
	}
	
	@PostMapping("/CvAdd")
	public Result add(@RequestBody Cv cv) {
		
		return this.cvService.add(cv);
		
	}
	
	@GetMapping("/CvGetAll")
	public DataResult<List<Cv>> getAll() {
		
		return this.cvService.getAll();
	}
	
	@PostMapping("/SchoolAdd")
	public Result add(@RequestBody SchoolCv cv) {
		
		return this.schoolCvService.add(cv);
		
	}
	
	@PostMapping("/JobExperienceAdd")
	public Result add(@RequestBody JobExperience jobExperience) {
		
		return this.jobExperienceService.add(jobExperience);
		
	}
	
	@PostMapping("/ForeignLanguageAdd")
	public Result add(@RequestBody ForeignLanguage foreignLanguage) {
		
		return this.foreignLanguageSerivce.add(foreignLanguage);
		
	}
	
	@PostMapping("/ProgrammingLanguageAdd")
	public Result add(@RequestBody ProgrammingLanguage programmingLanguage) {
		
		return this.programmingLanguageService.add(programmingLanguage);
		
	}
	
	
	@GetMapping("/getAllSortedGradutionYear")
	public DataResult<List<Cv>> getAllSortedGradutionYear() {
		
		return this.cvService.getAllSortedGradutionYear();
	}
	
	@GetMapping("/getAllSortedExperinceYear")
	public DataResult<List<Cv>> getAllSortedExperinceYear() {
		
		return this.cvService.getAllSortedExperinceYear();
	}
	
	@PostMapping("/getByCvId")
	public DataResult<Cv> getByCvId(int cvId) {
		
		return this.cvService.getByCvId(cvId);
		
	}
	
}
