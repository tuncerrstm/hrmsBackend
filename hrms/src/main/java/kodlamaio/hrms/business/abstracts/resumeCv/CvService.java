package kodlamaio.hrms.business.abstracts.resumeCv;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.resumeCv.Cv;


public interface CvService {
	
	public Result add(Cv cv);
	public DataResult<List<Cv>> getAll();
	public DataResult<List<Cv>> getAllSortedGradutionYear();
	public DataResult<List<Cv>> getAllSortedExperinceYear();
	public DataResult<Cv> getByCvId(int userId);

}