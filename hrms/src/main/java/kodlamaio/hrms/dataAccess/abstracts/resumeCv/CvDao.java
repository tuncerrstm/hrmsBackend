package kodlamaio.hrms.dataAccess.abstracts.resumeCv;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.resumeCv.Cv;

public interface CvDao extends JpaRepository<Cv, Integer>{
	
	Cv getByCvId(int cvId);
}
