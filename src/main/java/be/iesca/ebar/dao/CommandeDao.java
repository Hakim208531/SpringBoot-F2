package be.iesca.ebar.dao;

import be.iesca.ebar.domaine.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommandeDao extends JpaRepository<Commande,Integer> {
    @Query("select c from Commande c where c.user.email = :emailUser")
    List<Commande> findByEmailUser(String emailUser);
}
