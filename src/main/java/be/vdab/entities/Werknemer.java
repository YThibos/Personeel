package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import com.sun.istack.NotNull;

import be.vdab.constraints.EmailPattern;
import be.vdab.util.InputValidator;


/**
 * The persistent class for the werknemers database table.
 * 
 */
@Entity
@Table(name="werknemers")
public class Werknemer implements Serializable, Comparable<Werknemer> {

	private static final long serialVersionUID = 1L;
	
	
	// MEMBER VERIABLES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false, length=50)
	@NotBlank
	String familienaam;
	
	@Column(nullable=false, length=50)
	@NotBlank
	String voornaam;
	
	@Column(nullable=false, length=100)
	@NotNull
	@EmailPattern
	String email;

	@Column(nullable=false, precision=10, scale=2)
	@NotNull
	@Min(InputValidator.MINIMUM_SALARIS)
	@NumberFormat(pattern = "###.##0,00")
	BigDecimal salaris;

	//bi-directional many-to-one association to Jobtitel
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="jobtitelid", nullable=false)
	@Valid
	Jobtitel jobtitel;

	//bi-directional many-to-one association to Werknemer
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="chefid")
	private Werknemer chef;

	//bi-directional many-to-one association to Werknemer
	@OneToMany(mappedBy="chef")
	private Set<Werknemer> werknemers = new HashSet<>();

	
	// CONSTRUCTORS
	protected Werknemer() {}
	
	public Werknemer(String email, String familienaam, BigDecimal salaris, String voornaam, Jobtitel jobtitel) {
		this.email = email;
		this.familienaam = familienaam;
		this.salaris = salaris;
		this.voornaam = voornaam;
		this.jobtitel = jobtitel;
	}


	// GETTERS & SETTERS
	public long getId() {
		return this.id;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFamilienaam() {
		return this.familienaam;
	}

	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}

	public BigDecimal getSalaris() {
		return this.salaris;
	}

	public void setSalaris(BigDecimal salaris) {
		this.salaris = salaris;
	}

	public String getVoornaam() {
		return this.voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public Jobtitel getJobtitel() {
		return this.jobtitel;
	}

	public void setJobtitel(Jobtitel jobtitel) {
		this.jobtitel = jobtitel;
	}

	public Werknemer getChef() {
		return this.chef;
	}

	public void setChef(Werknemer werknemer) {
		this.chef = werknemer;
	}

	public Set<Werknemer> getWerknemers() {
		return this.werknemers;
	}

	public void setWerknemers(Set<Werknemer> werknemers) {
		this.werknemers = werknemers;
	}

	public Werknemer addWerknemer(Werknemer werknemer) {
		getWerknemers().add(werknemer);
		werknemer.setChef(this);

		return werknemer;
	}

	public Werknemer removeWerknemer(Werknemer werknemer) {
		getWerknemers().remove(werknemer);
		werknemer.setChef(null);

		return werknemer;
	}

	
	// OVERRIDDEN OBJECT METHODS
	@Override
	public int compareTo(Werknemer other) {
		if (this.familienaam == other.familienaam) {
			return this.voornaam.compareTo(other.voornaam);
		}
		return this.familienaam.compareTo(other.familienaam);
	}

	@Override
	public int hashCode() {
		return email.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Werknemer))
			return false;
		Werknemer other = (Werknemer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return voornaam + " " + familienaam;
	}

}