package kodlamaio.hrms.entities.concretes.resumeCv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_experience")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","Cv"})
public class JobExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_experience_id")
	private int jobExperienceId;
	
	@Column(name = "business_name")
	private String businessName;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "starting_date")
	private String startingDate;
	
	@Column(name = "finishing_date")
	private String finishingDate;
	
}
