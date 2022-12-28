package tests.java.hex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import main.java.hex.Plateau;

class CheminTest {

	@Test
	void testerCheminHB() {
		// GIVEN
		Plateau pla = new Plateau(4);
		
		// WHEN
		pla.jouer("B1");pla.jouer("B2");pla.jouer("C1");pla.jouer("A3");
		pla.jouer("B4");pla.jouer("B3");pla.jouer("C3");pla.jouer("D3");
		pla.jouer("D2");pla.jouer("C4");pla.jouer("A4");pla.jouer("A1");
		pla.jouer("D1");
		// Disposition du plateau
		//  A B C D
		// 1 O X X X
		// 2  . O . X
		// 3   O O X O
		// 4    X X O .
		
		// On regarde qu'il y a bien un chemin entre le haut et le bas du Plateau
		// (D1 -> D2 -> C3 -> B4)
		pla.updateChemin();
		
		// THEN
		assertEquals(pla.aCheminHB(),true);
	}
	
	@Test
	void testerCheminGD() {
		// GIVEN
		Plateau pla = new Plateau(4);
		
		// WHEN
		pla.jouer("B1");pla.jouer("D3");pla.jouer("C2");pla.jouer("A3");
		pla.jouer("A1");pla.jouer("B3");pla.jouer("C3");pla.jouer("A2");
		pla.jouer("D2");pla.jouer("C4");pla.jouer("A4");pla.jouer("B4");
		pla.jouer("D1");
		
		// Disposition du plateau
		// A B C D
		// 1 X X . X
		// 2  . O X X
		// 3   O O X O
		// 4    X O O .
		
		// On regarde qu'il y a bien un chemin entre la gauche et la droite du Plateau
		// (A3 -> B3 -> B4 -> C4 -> D3)
		pla.updateChemin();
		
		// THEN
		assertEquals(pla.aCheminGD(),true);
	}
}
