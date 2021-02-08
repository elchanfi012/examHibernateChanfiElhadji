package exam_hibernate_chanfi_elhadji.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "garage")
public class Garage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "nom", nullable = false, length = 255)
	@NotNull(message = "le nom ne doit pas être nul")
	@NotBlank(message = "le nom ne doit pas être vide")
	private String nom;
	
	@Column(name = "rue", nullable = false, length = 255)
	@NotNull(message = "la rue ne doit pas être nul")
	@NotBlank(message = "la rue ne doit pas être vide")
	private String rue;
	
	@Column(name = "code_postal", nullable = false, length = 255)
	@NotNull(message = "le code_postal ne doit pas être nul")
	@NotBlank(message = "le code_postal ne doit pas être vide")
	private String codePostal;
	
	@Column(name = "ville", nullable = false, length = 255)
	@NotNull(message = "la ville ne doit pas être nul")
	@NotBlank(message = "la ville ne doit pas être vide")
	private String ville;
	
	@Column(name = "num_telephone", nullable = false, unique = true, length = 180)
	@NotNull(message = "le numéro de téléphone ne doit pas être nul")
	@NotBlank(message = "le numéro de téléphone ne doit pas être vide")
	private String numTelephone;
	
	@Column(name = "num_siret", nullable = false, unique = true, length = 255)
	@NotNull(message = "le numéro siret ne doit pas être nul")
	@NotBlank(message = "le numéro siret ne doit pas être vide")
	private String numSiret;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	public Garage() {
	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}

	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
