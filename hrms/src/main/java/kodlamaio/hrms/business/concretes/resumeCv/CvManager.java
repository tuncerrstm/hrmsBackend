package kodlamaio.hrms.business.concretes.resumeCv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.resumeCv.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.resumeCv.CvDao;
import kodlamaio.hrms.entities.concretes.resumeCv.Cv;

@Service
public class CvManager implements CvService{
	
	private CvDao cvDao;

	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Cv eklendi.");
	}

	@Override
	public DataResult<List<Cv>> getAll() {

		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "Data getirildi.");
	}

	@Override
	public DataResult<List<Cv>> getAllSortedGradutionYear() {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "schoolCv.finishingDate");
		
		return new SuccessDataResult<List<Cv>>
		(this.cvDao.findAll(sort), "Data sıralandı.");
	}

	@Override
	public DataResult<List<Cv>> getAllSortedExperinceYear() {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "jobExp.finishingDate");
		return new SuccessDataResult<List<Cv>>
		(this.cvDao.findAll(sort), "Data sıralandı.");
	}

	@Override
	public DataResult<Cv> getByCvId(int userId) {
		return new SuccessDataResult<Cv>
		(this.cvDao.getByCvId(userId), "Data getirildi.");
		
	}
}
