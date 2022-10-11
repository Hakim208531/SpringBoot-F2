package be.iesca.ebar;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import be.iesca.ebar.dao.CommandeDao;
import be.iesca.ebar.domaine.Biere;
import be.iesca.ebar.domaine.Commande;
import be.iesca.ebar.domaine.EtatCommande;
import be.iesca.ebar.domaine.User;



@SpringBootTest
class TestsCommandeDao {

	@Autowired
	CommandeDao commandeDao;

	@Autowired
	List<Commande> commandes;

	@Autowired
	List<Biere> bieres;

	@Test
	public void testTableCommandesContientLes3Commandes() {

		// Vérifiez que la table "commandes" contient les 3 commandes définies dans le fichier de configuration.

	}

	@Test
	@Transactional
	public void testCommandesAdmin() {

		// Chargez les commandes passées par l'utilisateur dont l'email est "admin1@gmail.com"
		// Vérifiez qu'il n'y en a qu'une et qu'elle est dans l'état "CREEE"

		// Vérifiez qu'il a commandé 10 "Chimay Rouge"

		// Vérifiez qu'il a commandé 15 "Floreffe Blonde"

	}

	@Test
	@Transactional
	public void testCommandesMembre() {

		// Chargez les commandes passées par l'utilisateur dont l'email est "membre1@gmail.com"
		// Vérifiez qu'il n'y en a que 2 et qu'elles sont dans l'état "CREEE"

		// Vérifiez que dans sa première commande il a commandé 20 "Blanche de Hoegaarden"

		// Vérifiez que dans sa 2ème commande il a commandé 25 "Chimay Bleue"
	}

}
