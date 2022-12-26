package tests.java.hex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.hex.Pion;
import main.java.hex.Plateau;

class PlateauTest {
	@Test
	void testPlateau() {
		final int taille = 4;
		Plateau p = new Plateau(taille);
		assertEquals(taille, p.taille()); // test de la taille
		assertEquals( // test du toString
				" A B C D\n" + 
				"1 . . . .\n" + 
				"2  . . . .\n" + 
				"3   . . . .\n" + 
				"4    . . . .\n", p.toString());
		
	
		// jouer un coup en B2
		p.jouer("B2");
		// regarde que le coup a bien �t� jou�
		assertEquals(Pion.Croix, p.getCase("B2"));
		
		// Teste la m�thode estVide
		assertEquals(true,p.estVide("D2"));
	}
}
