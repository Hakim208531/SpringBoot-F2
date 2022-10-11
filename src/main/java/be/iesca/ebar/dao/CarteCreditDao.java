package be.iesca.ebar.dao;

import be.iesca.ebar.domaine.CarteCredit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteCreditDao extends JpaRepository<CarteCredit,String> {
}
