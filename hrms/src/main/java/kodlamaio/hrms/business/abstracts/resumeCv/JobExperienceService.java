package kodlamaio.hrms.business.abstracts.resumeCv;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.resumeCv.JobExperience;

public interface JobExperienceService {
	
	public Result add(JobExperience jobExperience);

}