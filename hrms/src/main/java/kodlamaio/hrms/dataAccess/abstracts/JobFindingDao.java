package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobFinding;

public interface JobFindingDao extends JpaRepository<JobFinding, Integer>{

	
}
