package be.vdab.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import be.vdab.entities.Werknemer;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the jobtitels database table.
 * 
 */
@Entity
@Table(name="jobtitels")
@NamedQuery(name="Jobtitel.findAll", query="SELECT j FROM Jobtitel j")
public class Jobtitel implements Serializable, Comparable<Jobtitel> {
	
	private static final long serialVersionUID = 1L;

	
	// MEMBER VARIABLES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false, length=50)
	@NotBlank
	private String naam;

	//bi-directional many-to-one association to Werknemer
	@OneToMany(mappedBy="jobtitel")
	private Set<Werknemer> werknemers;

	
	// CONSTRUCTORS
	protected Jobtitel() {}
	
	public Jobtitel(String naam) {
		this.naam = naam;
		werknemers = new HashSet<>();
	}

	
	// GETTERS & SETTERS
	public long getId() {
		return this.id;
	}
	public String getNaam() {
		return this.naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public Set<Werknemer> getWerknemers() {
		return this.werknemers;
	}
	public void setWerknemers(Set<Werknemer> werknemers) {
		this.werknemers = werknemers;
	}

	public Werknemer addWerknemer(Werknemer werknemer) {
		getWerknemers().add(werknemer);
		werknemer.setJobtitel(this);

		return werknemer;
	}
	public Werknemer removeWerknemer(Werknemer werknemer) {
		getWerknemers().remove(werknemer);
		werknemer.setJobtitel(null);

		return werknemer;
	}
	
	
	// OVERRIDDEN OBJECT METHODS
	@Override
	public String toString() {
		return naam;
	}
	
	@Override
	public int hashCode() {
		return naam.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Jobtitel))
			return false;
		Jobtitel other = (Jobtitel) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Jobtitel other) {
		return this.naam.compareTo(other.naam);
	}

}