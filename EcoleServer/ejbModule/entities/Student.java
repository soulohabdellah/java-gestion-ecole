package entities;

import entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.lang.String;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
public class Student extends User implements Serializable {

	
	private String firstName;
	private String lastName;
	private String telephone;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Filiere filiere;
	public Student() {
		super();
	}   
    public Student(String email, String password, String firstName, String lastName, String telephone, Filiere filiere) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.filiere = filiere;
    }
	
	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
   
}