package be.iesca.ebar.dao;

import be.iesca.ebar.domaine.Biere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BiereDao extends JpaRepository<Biere,Integer> {
    Optional<Biere> findByNom(String nom);
}
