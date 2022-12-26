package tests.java.joueurs;

import org.junit.jupiter.api.Test;

import main.java.hex.Plateau;
import main.java.joueurs.Aleatoire;

class AleatoireTest {

	@Test
	void testChoisirCoup() {
		// teste le coup choisit aléatoirement pour une IA
		Plateau p = new Plateau(4);
		p.jouer("C1");
		p.jouer("A3");
		p.jouer("B4");
		System.out.println(p);
		
		Aleatoire a = new Aleatoire("IA");
		System.out.println(a.choisirCoup(p));
	}
}
