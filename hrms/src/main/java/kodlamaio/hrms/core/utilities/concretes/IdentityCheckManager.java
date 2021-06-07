package kodlamaio.hrms.core.utilities.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.abstracts.IdentityCheckService;
import kodlamaio.hrms.dataAccess.abstracts.JobFindingDao;
import kodlamaio.hrms.entities.concretes.JobFinding;

@Service
public class IdentityCheckManager implements IdentityCheckService {

	private JobFindingDao jobFindingDao;
	private List<String> identities = new ArrayList<String>();

	@Autowired
	public IdentityCheckManager(JobFindingDao jobFindingDao) {
		super();
		this.jobFindingDao = jobFindingDao;
	}

	@Override
	public List<String> identityCheckDataBase() {

		List<JobFinding> jobFindingGetAll = this.jobFindingDao.findAll();
		int numberOfidentities = jobFindingGetAll.size();

		for (int i = 0; i < numberOfidentities; i++) {

			identities.add(jobFindingGetAll.get(i).getIdentityNumber());
		}
		return identities;

	}

	@Override
	public boolean identityIsItUsed(String identity) {

		boolean IsItUsed = false;

		if (this.identityCheckDataBase().contains(identity)) {
			IsItUsed = true;
		}
		return IsItUsed;
	}
	
}
