package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		String date = LocalDate.now().toString();
		jobAdvertisement.setReleaseDate(date);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Data eklendi.");
		
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Data getirildi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActive(), "Aktif data getirildi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedByDeadline() {
		
		Sort sort = Sort.by(Sort.Direction.ASC,"applicationDeadline");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer_CompanyNameAndIsActive(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_CompanyNameAndIsActive(companyName), "Data getirildi." );
	}

	@Override
	public Result update(int id, boolean isAvtice) {

		JobAdvertisement jobAdvertisementUpdate = this.jobAdvertisementDao.findById(id).get();
		jobAdvertisementUpdate.setActive(isAvtice);
		this.jobAdvertisementDao.save(jobAdvertisementUpdate);
		return new SuccessResult("Aktiflik değiştirildi.");
	}
	
}
