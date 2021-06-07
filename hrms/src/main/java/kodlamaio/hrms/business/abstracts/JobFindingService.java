package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.JobFinding;
import kodlamaio.hrms.entities.concretes.MernisVerification;

public interface JobFindingService {

	public Result register(JobFinding jobFinding, EmailVerification emailVerification, MernisVerification mernisVerification);
	public DataResult<List<JobFinding>> getAll();
	
}
