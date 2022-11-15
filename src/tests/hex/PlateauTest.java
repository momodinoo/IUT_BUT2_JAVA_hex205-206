package tests.hex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sources.hex.Plateau;

class PlateauTest {

	@Test
	void test() {
		final int taille = 4;
		Plateau p = new Plateau(taille);
		assertEquals(taille, p.taille());
		
		System.out.println(p);
		assertEquals(
				" A B C D\n" + 
				"1 . . . .\n" + 
				"2  . . . .\n" + 
				"3   . . . .\n" + 
				"4    . . . .\n", p.toString());

		//Jouer un coup en B2
		assertEquals('X', p.getCase("B2"));


		
	}

}


// dans src sources hex creer pion.java

// package sources.hex;

// public enum Pion {
// 	Croix('X'),Rond('O'),Vide('.');
// 	private char symbole;
// 	Pion (char symbole){
// 		this.symbole = symbole;
// 	}
	
// 	@Override
// 	public String toString() {
// 		return ""+symbole;
// 	}
// }
