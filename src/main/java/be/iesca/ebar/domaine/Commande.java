package be.iesca.ebar.domaine;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "commandes")
public class Commande implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private Calendar dateCreation;
    @ElementCollection
    @CollectionTable(name = "lignes_commande")
    @Column(name = "quantite", nullable = false)
    private Map<Biere, Integer> bieresCommandees = new HashMap<>();

    @ManyToOne(optional = false)
    private User user = new User();

    public Commande(){}

    public Commande(User user){
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commande commande)) return false;
        return Objects.equals(dateCreation, commande.dateCreation) && Objects.equals(user, commande.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateCreation, user);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Calendar dateCreation) {
        this.dateCreation = dateCreation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Biere, Integer> getBieresCommandees() {
        return bieresCommandees;
    }

    public void setBieresCommandees(Map<Biere, Integer> bieresCommandees) {
        this.bieresCommandees = bieresCommandees;
    }
}
