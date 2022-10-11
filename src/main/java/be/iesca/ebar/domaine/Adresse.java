package be.iesca.ebar.domaine;

import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Adresse implements Serializable {
    @Column(nullable = false)
    private String rueNumero;

    @Column(nullable = false)
    private String codePostal;

    @Column(nullable = false)
    private String commune;

    public Adresse(){}

    public Adresse(String rueNumero, String codePostal, String commune){
        this.rueNumero = rueNumero;
        this.codePostal = codePostal;
        this.commune = commune;
    }

    public String getRueNumero() {
        return rueNumero;
    }

    public void setRueNumero(String rueNumero) {
        this.rueNumero = rueNumero;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }
}
