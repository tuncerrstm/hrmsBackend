package kodlamaio.hrms.business.concretes.resumeCv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.resumeCv.SchoolCvService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.resumeCv.SchoolCvDao;
import kodlamaio.hrms.entities.concretes.resumeCv.SchoolCv;

@Service
public class SchoolCvManager implements SchoolCvService{

	private SchoolCvDao schoolCvDao;

	@Autowired
	public SchoolCvManager(SchoolCvDao schoolCvDao) {
		super();
		this.schoolCvDao = schoolCvDao;
	}

	@Override
	public Result add(SchoolCv schoolCv) {
		this.schoolCvDao.save(schoolCv);
		return new SuccessResult("Data getirildi.");
	}
}
