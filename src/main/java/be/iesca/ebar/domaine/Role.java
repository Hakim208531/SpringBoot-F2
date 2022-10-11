package be.iesca.ebar.domaine;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    private String nom;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    Role(){}

    public Role(String nom){
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return Objects.equals(nom, role.nom);
    }

    @Override
    public int hashCode() {
        return nom != null ? nom.hashCode() : 0;
    }

    public String getNom() {
        return nom;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
