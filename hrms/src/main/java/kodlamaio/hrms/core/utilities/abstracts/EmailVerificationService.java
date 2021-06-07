package kodlamaio.hrms.core.utilities.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobFinding;

public interface EmailVerificationService {
	
	public void sendMailJobFinding(JobFinding jobFinding);
	public void sendMailEmployer(Employer employer);
	
}
