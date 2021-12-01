package com.tn.esprit.gestionstock.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idClient;
    String nom;
    String prenom;

    @Temporal(TemporalType.DATE)
//    @Temporal(TemporalType.TIMESTAMP)
    Date dateNaissance;
    String email;
    String password;
    @Enumerated(EnumType.STRING)
    CategorieClient categorieClient;
    @Enumerated(EnumType.STRING)
    Profession proffesion;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"client"})
    List<Facture> factures;

    public Client() {
        factures = new ArrayList<>();
    }

    public Client(String nom, String prenom, Date dateNaissance, String email, String password, CategorieClient categorieClient, Profession proffesion) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.password = password;
        this.categorieClient = categorieClient;
        this.proffesion = proffesion;
        factures = new ArrayList<>();
    }

    public Client(String nom, String prenom, String email, String password, CategorieClient categorieClient) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.categorieClient = categorieClient;
        factures = new ArrayList<>();
    }
    

    public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CategorieClient getCategorieClient() {
		return categorieClient;
	}

	public void setCategorieClient(CategorieClient categorieClient) {
		this.categorieClient = categorieClient;
	}

	public Profession getProffesion() {
		return proffesion;
	}

	public void setProffesion(Profession proffesion) {
		this.proffesion = proffesion;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	@Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", categorieClient=" + categorieClient +
                ", proffesion=" + proffesion +
//                ", factures=" + factures +
                '}';
    }
    
}
