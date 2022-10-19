package be.iesca.ebar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.iesca.ebar.domaine.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import be.iesca.ebar.dao.BiereDao;
import be.iesca.ebar.dao.CommandeDao;
import be.iesca.ebar.dao.RoleDao;
import be.iesca.ebar.dao.UserDao;

@Configuration
public class ConfigJpa3 {

	private User creerUserAvecMdpChiffre(String nom, String email, String password) {
		String mdpChiffre = passwordEncoder().encode(password);
		return new User(nom, email, mdpChiffre);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public List<Biere> initialiserLesBieres(BiereDao biereDao) {
		ArrayList<Biere> bieres = new ArrayList<Biere>(8);
		bieres.add(new Biere("Chimay Rouge", "Trappiste", "brune", "Abbaye de Scourmont", 1.65));
		bieres.add(new Biere("Floreffe Blonde", "Abbaye", "blonde", "Brasserie Lefèbvre", 1.56));
		bieres.add(new Biere("Blanche de Hoegaarden", "Blanche", "blanche", "Brasserie De Kluis", 1.65));
		bieres.add(new Biere("Chimay Bleue", "Trappiste", "brune", "Abbaye de Scourmont", 1.49));
		bieres.add(new Biere("Floreffe Triple", "Abbaye", "blonde", "Brasserie Lefèbvre", 1.65));
		bieres.add(new Biere("Blanche De Bruxelles", "Blanche", "blanche", "Brasserie Lefèbvre", 1.80));
		bieres.add(new Biere("Bush Blonde", "Spécialité", "blonde", "Brasserie Dubuisson", 1.9));
		bieres.add(new Biere("Bush", "Spécialité", "ambrée", "Brasserie Dubuisson", 1.74));

		bieres.forEach(b -> {
			b.setId(biereDao.save(b).getId());
		});
		return bieres;
	}

	@Bean
	List<Role> initialiserLesRoles(RoleDao roleDao) {
		List<Role> roles = new ArrayList<Role>(2);
		// role administrateur
		Role roleAdmin = new Role("administrateur");
		roles.add(roleAdmin);
		roleDao.save(roleAdmin);
		// role membre
		Role roleMembre = new Role("membre");
		roles.add(roleMembre);
		roleDao.save(roleMembre);
		return roles;
	}

	@Bean
	public List<User> initialiserLesUsers(UserDao userDao, List<Role> roles, RoleDao roleDao) {
		List<User> users = new ArrayList<User>(2);
		// admin1
		User admin = creerUserAvecMdpChiffre("admin1", "admin1@gmail.com", "1234");
		Adresse adresseAdmin = new Adresse("rue de l'admin", "1000", "Bruxelles");
		admin.setAdresse(adresseAdmin);
		users.add(admin);
		CarteCredit carteAdmin = new CarteCredit(admin, "123456789-99", "Fortis");
		admin.setCarteCredit(carteAdmin);
		carteAdmin.setUser(admin);
		admin.setRoles(roles);
		userDao.save(admin);
		Role roleAdministrateur = roles.get(0);
		List<User> users1 = new ArrayList<User>(1);
		users1.add(admin);
		roleAdministrateur.setUsers(users1);
		roleAdministrateur=roleDao.save(roleAdministrateur);
		// membre1
		User membre = creerUserAvecMdpChiffre("membre1", "membre1@gmail.com", "5678");
		Adresse adresseMembre = new Adresse("rue du membre", "5550", "Membre");
		membre.setAdresse(adresseMembre);
		users.add(membre);
		CarteCredit carteMembre = new CarteCredit(membre, "987654321-00", "BeoBank");
		membre.setCarteCredit(carteMembre);
		carteMembre.setUser(membre);
		List<Role> rolesMembre = new ArrayList<Role>(1);
		rolesMembre.add(roles.get(1));
		membre.setRoles(rolesMembre);
		userDao.save(membre);
		Role roleMembre = roles.get(1);
		users1.add(membre);
		roleMembre.setUsers(users1);
		roleDao.save(roleMembre);
		return users;
	}

	@Bean
	List<Commande> initialiserLesCommandes(CommandeDao commandeDao, List<User> users, List<Biere> bieres) {
		List<Commande> commandes = new ArrayList<Commande>();
		// admin
		Commande commande1Admin = new Commande(users.get(0));
		Map<Biere, LigneCommande> mapAdmin = new HashMap<Biere, LigneCommande>();
		mapAdmin.put(bieres.get(0), new LigneCommande(bieres.get(0), 10, 1.70));
		mapAdmin.put(bieres.get(1), new LigneCommande(bieres.get(1), 15, 1.80));
		commande1Admin.setEtat(EtatCommande.CREEE);
		commande1Admin.setBieresCommandees(mapAdmin);
		commande1Admin=commandeDao.save(commande1Admin);
		commandes.add(commande1Admin);
		// membre 1
		Commande commande1Membre = new Commande(users.get(1));
		Map<Biere, LigneCommande> mapMembre1 = new HashMap<Biere, LigneCommande>();
		mapMembre1.put(bieres.get(2), new LigneCommande(bieres.get(2), 20, 1.65));
		commande1Membre.setEtat(EtatCommande.CREEE);
		commande1Membre.setBieresCommandees(mapMembre1);
		commande1Membre=commandeDao.save(commande1Membre);
		commandes.add(commande1Membre);
		// membre 2
		Commande commande2Membre = new Commande(users.get(1));
		Map<Biere, LigneCommande> mapMembre2 = new HashMap<Biere, LigneCommande>();
		mapMembre2.put(bieres.get(3), new LigneCommande(bieres.get(3), 25, 1.35));
		commande2Membre.setEtat(EtatCommande.CREEE);
		commande2Membre.setBieresCommandees(mapMembre2);
		commandes.add(commande2Membre);
		commande2Membre=commandeDao.save(commande2Membre);
		return commandes;
	}
}
