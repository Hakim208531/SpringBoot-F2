package be.iesca.ebar.domaine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    private String email;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String password;

    @Embedded
    private Adresse adresse;

    @OneToOne(cascade = CascadeType.ALL)
    private CarteCredit carteCredit;

    @OneToMany(mappedBy = "user")
    List<Commande> commandes;

    public List<Role> getRoles() {
        return roles;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @ManyToMany
    private List<Role> roles;

    public User(){}

    public User(String nom,String email, String password){
        this.email = email;
        this.nom = nom;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CarteCredit getCarteCredit() {
        return carteCredit;
    }

    public void setCarteCredit(CarteCredit carteCredit) {
        this.carteCredit = carteCredit;
    }
}
