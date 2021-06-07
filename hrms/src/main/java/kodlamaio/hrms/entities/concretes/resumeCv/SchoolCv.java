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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "school_cv")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","Cv"})
public class SchoolCv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "school_cv_id")
	private int schoolCvId;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "starting_date")
	private String startingDate;
	
	@Column(name = "finishing_date")
	private String finishingDate;
	
	@Column(name = "department")
	private String department;
}
