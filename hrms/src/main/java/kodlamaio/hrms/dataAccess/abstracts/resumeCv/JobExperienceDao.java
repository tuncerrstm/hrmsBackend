package kodlamaio.hrms.dataAccess.abstracts.resumeCv;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.resumeCv.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

}
