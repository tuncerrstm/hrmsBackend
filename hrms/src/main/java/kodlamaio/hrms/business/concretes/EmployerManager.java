package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.abstracts.EmailCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.HrmsVerification;


@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmailCheckService emailCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailCheckService emailCheckService) {
		super();
		this.employerDao = employerDao;
		this.emailCheckService = emailCheckService;
	}

	@Override
	public Result register(Employer employer, HrmsVerification hrmsVerification ,EmailVerification emailVerification) {

		Result result = new SuccessResult("Kayit basarili.");

		if (emailCheckService.emailIsItUsed(employer.getEmail())) {
			result = new ErrorResult("Email sisteme kayitli.");
			return result;
		}if(emailVerification.isEmailBool() == false){
			result = new ErrorResult("Email onayi gerekiyor.");
			return result;
			
		}if(hrmsVerification.isHrmsBool() == false){
			result = new ErrorResult("Hrms onayi gerekiyor.");
			return result;
		}else {
			this.employerDao.save(employer);
			
		}
		return result;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data getirildi.");
	}
}
