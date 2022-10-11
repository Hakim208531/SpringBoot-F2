package be.iesca.ebar.domaine;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cartes_credit")
public class CarteCredit implements Serializable {

    @OneToOne(mappedBy = "carteCredit")
    private User user;

    @Id
    private String numero;

    @Column(nullable = false)
    private String banque;

    public CarteCredit(){}

    public CarteCredit(User user, String numero, String banque){
        this.user = user;
        this.numero = numero;
        this.banque = banque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarteCredit that = (CarteCredit) o;

        return Objects.equals(numero, that.numero);
    }

    @Override
    public int hashCode() {
        return numero != null ? numero.hashCode() : 0;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
