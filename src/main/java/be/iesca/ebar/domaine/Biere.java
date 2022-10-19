package be.iesca.ebar.domaine;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bieres")
public class Biere implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, unique = true)
    private String nom;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String couleur;
    @Column(nullable = false)
    private String brasserie;

    private double prix;

    public Biere(){}

    public Biere(String nom, String type, String couleur, String brasserie, double prix){
        this.nom = nom;
        this.type = type;
        this.couleur = couleur;
        this.brasserie = brasserie;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Biere{" +
                "prix=" + prix +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Biere biere)) return false;
        return Objects.equals(nom, biere.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getBrasserie() {
        return brasserie;
    }

    public void setBrasserie(String brasserie) {
        this.brasserie = brasserie;
    }
}
