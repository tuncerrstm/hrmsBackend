package kodlamaio.hrms.dataAccess.abstracts.resumeCv;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.resumeCv.SchoolCv;

public interface SchoolCvDao extends JpaRepository<SchoolCv, Integer> {

}
