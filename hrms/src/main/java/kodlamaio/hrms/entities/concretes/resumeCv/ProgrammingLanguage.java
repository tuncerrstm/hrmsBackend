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
@Table(name = "programming_language")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","Cv"})
public class ProgrammingLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "programming_language_id")
	private int programmingLanguageId;
	
	@Column(name = "language_name")
	private String languageName;
	
	@Column(name = "technology")
	private String technology;
	
	
}
