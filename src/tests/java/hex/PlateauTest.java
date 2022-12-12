package tests.java.hex;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import main.java.hex.Pion;
import main.java.hex.Plateau;
import main.java.joueurs.Aleatoire;

class PlateauTest {
	private String pos1 = ".X..XOXXOO.OX..."; 
	private String[] lignes1_rep = {
			".X..", 
			"XOXX",
			"OO.O",
			"X..."
	};
	private String display1_rep = 
			" A B C D\n" + 
			"1 . X . .\n" + 
			"2  X O X X\n" + 
			"3   O O . O\n" + 
			"4    X . . .\n";

	@Test
	void test() {
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
		assertEquals(Pion.Croix, p.getCase("B2"));
		System.out.println(p);
		
		p.jouer("C1");
		p.jouer("A3");
		p.jouer("B4");
		System.out.println(p);
		
		assertEquals(true,p.estVide("D2"));
		assertEquals(4,p.taille());
		
		Aleatoire a = new Aleatoire("couou");
		System.out.println(a.choisirCoup(p));
		
	}
	
	@Test
	public void testerPositions() {
		testerPosition(pos1, lignes1_rep, display1_rep);
	}
	
	@Test
	private void testerPosition(String pos, String[] lignes_rep, String display_rep) {
		// teste que pos correspond � lignes_rep correspond � display_rep
		String[] lignes;
		lignes  = Plateau.decouper(pos);
		int taille = Plateau.getTaille(pos);
		
		for (int i = 0; i< taille; ++i)
			assertEquals(lignes_rep[i], lignes[i]);
		
		Plateau p = new Plateau(taille, pos);
		assertEquals(display_rep, p.toString());
	}

}
