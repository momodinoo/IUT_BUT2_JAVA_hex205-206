package tests.hex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hex.Plateau;

class PlateauTest {

	@Test
	void test() {
		final int largeur = 4;
		final int hauteur = 4;
		Plateau p = new Plateau(largeur,hauteur);
		
		assertEquals(
				" A B C D\n" + 
				"1 . . . .\n" + 
				"2  . . . .\n" + 
				"3   . . . .\n" + 
				"4    . . . .\n", p.toString());
	}

}
