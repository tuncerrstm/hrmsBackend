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
@Table(name = "foreign_language")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","Cv"})
public class ForeignLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "foreign_language_id")
	private int foreignLanguageId;
	
	@Column(name = "language_name")
	private String languageName;
	
	@Column(name = "language_level")
	private String languageLevel;
	
}
