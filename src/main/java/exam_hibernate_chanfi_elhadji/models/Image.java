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
@Table(name = "image")
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "nom", nullable = false, length = 255)
	@NotNull(message = "le nom ne doit pas être nul")
	@NotBlank(message = "le nom ne doit pas être vide")
	private String nom;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "car_id", referencedColumnName = "id")
	private Car car;
}
