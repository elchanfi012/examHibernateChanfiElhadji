package exam_hibernate_chanfi_elhadji.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "car")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "marque", nullable = false, length = 255)
	@NotNull(message = "la marque ne doit pas être nul")
	@NotBlank(message = "la marque ne doit pas être vide")
	private String marque;
	
	@Column(name = "modele", nullable = false, length = 255)
	@NotNull(message = "le modèle ne doit pas être nul")
	@NotBlank(message = "le modèle ne doit pas être vide")
	private String modele;
	
	@Column(name = "carburant", nullable = false, length = 255)
	@NotNull(message = "le carburant ne doit pas être nul")
	@NotBlank(message = "le carburant ne doit pas être vide")
	private String carburant;
	
	@Column(name = "annee", nullable = false)
	@NotNull(message = "l'annee ne doit pas être nul")
	@NotBlank(message = "l'annee ne doit pas être vide")
	private Integer annee;
	
	@Column(name = "kilometrage", nullable = false)
	@NotNull(message = "le kilométrage ne doit pas être nul")
	@NotBlank(message = "le kilométrage ne doit pas être vide")
	private Integer kilometrage;
	
	@Column(name = "date_ajout", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message = "la date d'ajout ne doit pas être nulle")
	private Date dateAjout;
	
	@Column(name = "description", nullable = false)
	@Type(type = "text")
	@NotNull(message = "la description ne doit pas être nul")
	@NotBlank(message = "la description ne doit pas être vide")
	private String description;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "garage_id", referencedColumnName = "id")
	private Garage garage;
	
	@ManyToMany
	@JoinTable(
			name = "color_car",
			joinColumns = { @JoinColumn( name = "car_id", referencedColumnName = "id")},
			inverseJoinColumns = { @JoinColumn( name = "color_id", referencedColumnName = "id")}
			)
	private List<Color> colors;

	public Car() {
	}

	public Integer getId() {
		return id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCarburant() {
		return carburant;
	}

	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public Integer getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(Integer kilometrage) {
		this.kilometrage = kilometrage;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Garage getGarage() {
		return garage;
	}

	public void setGarage(Garage garage) {
		this.garage = garage;
	}
	
	public void initializeColorsList() {
		if(this.colors == null) {
			this.colors = new ArrayList<Color>();
		}
	}

	public List<Color> getColors() {
		this.initializeColorsList();
		return colors;
	}

	public void addColor(Color color) {
		this.initializeColorsList();
		this.colors.add(color);
	}
	
	public void removeColor(Color color) {
		this.initializeColorsList();
		this.colors.remove(color);
	}
}
