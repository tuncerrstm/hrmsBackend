package kodlamaio.hrms.entities.concretes.resumeCv;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.JobFinding;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cv")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","Cv"})

public class Cv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id")
	private int cvId;
	
	@OneToOne
	@JoinColumn(name = "job_finding_id")
	private JobFinding jobFinding;
	
	
	@ManyToMany
	@JoinColumn(name = "school_id")
	private List<SchoolCv> schoolCv;
	
	@ManyToMany
	@JoinColumn(name = "job_experience_id")
	private List<JobExperience> jobExp;
	
	@ManyToMany
	@JoinColumn(name = "foreign_language_id")
	private List<ForeignLanguage> foreignLng;
	
	@ManyToMany
	@JoinColumn(name = "programming_language_id")
	private List<ProgrammingLanguage> programmingLng;
	
	
	@Column(name = "foreword")
	private String foreword;		
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
}
