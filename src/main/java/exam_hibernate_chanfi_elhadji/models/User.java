package exam_hibernate_chanfi_elhadji.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "username", nullable = false, unique = true, length = 255)
	@NotNull(message = "le nom d'utilisateur ne doit pas être nul")
	@NotBlank(message = "le nom d'utilisateur ne doit pas être vide")
	private String username;
	
	@Column(name = "roles", nullable = false)
	@Type(type = "text")
	@NotNull(message = "le rôle ne doit pas être nul")
	@NotBlank(message = "le rôle ne doit pas être vide")
	private String roles;
	
	@Column(name = "password", nullable = false, length = 255)
	@NotNull(message = "le mot de passe ne doit pas être nul")
	@NotBlank(message = "le mot de passe ne doit pas être vide")
	private String password;
	
	@Column(name = "email", nullable = false, unique = true, length = 255)
	@NotNull(message = "l'email ne doit pas être nul")
	@NotBlank(message = "l'email ne doit pas être vide")
	@Email(message = "l'email doit être au format example@example.com")
	private String email;
	
	@Column(name = "nom", nullable = false, length = 255)
	@NotNull(message = "le nom ne doit pas être nul")
	@NotBlank(message = "le nom ne doit pas être vide")
	private String nom;
	
	@Column(name = "prenom", nullable = false, length = 255)
	@NotNull(message = "le prénom ne doit pas être nul")
	@NotBlank(message = "le prénom ne doit pas être vide")
	private String prenom;
	
	@Column(name = "num_telephone", nullable = false, unique = true, length = 180)
	@NotNull(message = "le numéro de téléphone ne doit pas être nul")
	@NotBlank(message = "le numéro de téléphone ne doit pas être vide")
	private String numTelephone;

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}
	
	
}
