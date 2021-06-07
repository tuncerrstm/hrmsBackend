package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobFindingService;
import kodlamaio.hrms.core.utilities.abstracts.EmailCheckService;
import kodlamaio.hrms.core.utilities.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.abstracts.IdentityCheckService;
import kodlamaio.hrms.core.utilities.abstracts.MernisVerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobFindingDao;
import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.JobFinding;
import kodlamaio.hrms.entities.concretes.MernisVerification;

@Service
public class JobFindingManager implements JobFindingService {

	private JobFindingDao jobFindingDao;
	private EmailCheckService emailCheckService;
	private IdentityCheckService identityCheckService;
	private EmailVerificationService emailVerificationService;
	private MernisVerificationService mernisVerificationService;


	@Autowired
	public JobFindingManager(JobFindingDao jobFindingDao, EmailCheckService emailCheckService,
			IdentityCheckService identityCheckService, EmailVerificationService emailVerificationService,
			MernisVerificationService mernisVerificationService
			) {
		super();
		this.jobFindingDao = jobFindingDao;
		this.emailCheckService = emailCheckService;
		this.identityCheckService = identityCheckService;
		this.emailVerificationService = emailVerificationService;
		this.mernisVerificationService = mernisVerificationService;
	}

	@Override
	public Result register(JobFinding jobFinding, EmailVerification emailVerification, MernisVerification mernisVerification) {

		Result result = new SuccessResult("Kayit basarili.");

		if (emailCheckService.emailIsItUsed(jobFinding.getEmail())) {
			result = new ErrorResult("Email sisteme kayitli.");
			return result;
		}if (identityCheckService.identityIsItUsed(jobFinding.getIdentityNumber())) {
			result = new ErrorResult("Kimlik numarasi sisteme kayitli.");
			return result;
		}if(emailVerification.isEmailBool() == false) {
			result = new ErrorResult("Email onayi gerekiyor.");
			return result;
		}if(mernisVerification.isMernisBool() == false){
			result = new ErrorResult("Mernis onayi gerekiyor.");
			
		}else {
			this.mernisVerificationService.mernisVerification();
			this.emailVerificationService.sendMailJobFinding(jobFinding);
			this.jobFindingDao.save(jobFinding);
			
		}
		return result;

	}

	@Override
	public DataResult<List<JobFinding>> getAll() {

		return new SuccessDataResult<List<JobFinding>>(this.jobFindingDao.findAll(), "Data getirildi.");
	}
	
}
