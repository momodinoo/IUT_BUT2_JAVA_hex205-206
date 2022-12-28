package tests.java.joueurs;

import org.junit.jupiter.api.Test;

import main.java.hex.Plateau;
import main.java.joueurs.Aleatoire;

class AleatoireTest {

	@Test
	void testChoisirCoup() {
		// GIVEN
		Plateau p = new Plateau(4);
		p.jouer("C1");
		p.jouer("A3");
		p.jouer("B4");
		System.out.println(p);
		
		// WHEN
		Aleatoire a = new Aleatoire("IA");
		
		// THEN
		System.out.println(a.choisirCoup(p));
	}
}
