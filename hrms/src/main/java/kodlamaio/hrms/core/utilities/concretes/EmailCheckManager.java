package kodlamaio.hrms.core.utilities.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.abstracts.EmailCheckService;
import kodlamaio.hrms.dataAccess.abstracts.JobFindingDao;
import kodlamaio.hrms.entities.concretes.JobFinding;

@Service
public class EmailCheckManager implements EmailCheckService{

	private JobFindingDao jobFindingDao;
	private List<String> emails = new ArrayList<String>();
	
	@Autowired
	public EmailCheckManager(JobFindingDao jobFindingDao) {
		super();
		this.jobFindingDao = jobFindingDao;
	}

	@Override
	public List<String> emailCheckDataBase() {
		
		
		List<JobFinding> jobFindingGetAll = this.jobFindingDao.findAll();
		int numberOfEmail = jobFindingGetAll.size();
		
		for(int i = 0 ; i < numberOfEmail ; i++) {
			
			emails.add(jobFindingGetAll.get(i).getEmail());
		}
		return emails;
		
		
	}

	@Override
	public boolean emailIsItUsed(String email) {
		boolean IsItUsed = false;
		
		if(this.emailCheckDataBase().contains(email)){
			IsItUsed = true;
		}
		return IsItUsed;
		
	}
}
