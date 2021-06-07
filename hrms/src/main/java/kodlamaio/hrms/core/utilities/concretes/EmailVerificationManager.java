package kodlamaio.hrms.core.utilities.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.abstracts.EmailVerificationService;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobFinding;

@Service
public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public void sendMailJobFinding(JobFinding jobFinding) {
		System.out.println("Onay maili yollandi : " + jobFinding.getEmail());
		
	}

	@Override
	public void sendMailEmployer(Employer employer) {

		System.out.println("Onay maili yollandi : " + employer.getEmail());
		
	}
}
