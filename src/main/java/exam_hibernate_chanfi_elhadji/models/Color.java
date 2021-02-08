package exam_hibernate_chanfi_elhadji.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "color")
public class Color {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "libille", nullable = false, length = 255)
	@NotNull(message = "le libellé ne doit pas être nul")
	@NotBlank(message = "le libelé ne doit pas être vide")
	private String libelle;
	
	@ManyToMany(mappedBy = "colors")
    private List<Car> cars;

	public Color() {
	}

	public Integer getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public void initializeCarsList() {
		if(this.cars == null) {
			this.cars = new ArrayList<Car>();
		}
	}

	public List<Car> getCars() {
		this.initializeCarsList();
		return cars;
	}

	public void addCar(Car car) {
		this.initializeCarsList();
		this.cars.add(car);
	}
	
	public void removeCar(Car car) {
		this.initializeCarsList();
		this.cars.remove(car);
	}
	
	

}
