package be.iesca.ebar.domaine;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lignes_commande")
public class LigneCommande {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(optional = false)
    private Biere biere = new Biere();
    @Column(nullable = false)
    private int quantite;
    @Column(nullable = false)
    private double prix;

    public LigneCommande(){}

    public LigneCommande(Biere biere, int quantite, double prix){
        this.biere = biere;
        this.quantite = quantite;
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LigneCommande that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Biere getBiere() {
        return biere;
    }

    public void setBiere(Biere biere) {
        this.biere = biere;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
