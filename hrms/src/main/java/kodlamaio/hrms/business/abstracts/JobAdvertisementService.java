package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	public Result add(JobAdvertisement jobAdvertisement);
	public DataResult<List<JobAdvertisement>> getAll();
	public DataResult<List<JobAdvertisement>> getByIsActive();
	public DataResult<List<JobAdvertisement>> getAllSortedByDeadline();
	
	public DataResult<List<JobAdvertisement>> getByEmployer_CompanyNameAndIsActive(String companyName);
	
	public Result update(int id , boolean isAvtice);
	
}
