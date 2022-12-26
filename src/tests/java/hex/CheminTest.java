package tests.java.hex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.hex.Plateau;

class CheminTest {

	@Test
	void testerChemin() {
		// On crée un plateau qu'on remplit de coups
		Plateau pla = new Plateau(4);
		pla.jouer("B1");pla.jouer("B2");pla.jouer("C1");pla.jouer("A3");
		pla.jouer("A2");pla.jouer("B3");pla.jouer("C3");pla.jouer("D3");
		pla.jouer("D2");pla.jouer("C4");pla.jouer("A4");pla.jouer("A1");
		pla.jouer("D4");
		System.out.println(pla);
		// Disposition du plateau
		//  A B C D
		// 1 O X X .
		// 2  X O . X
		// 3   O O X O
		// 4    X . O X
		
		// On regarde qu'il y a bien un chemin entre le haut et le bas du Plateau
		// (C1 -> D2 -> C3 -> D4)
		pla.updateChemin();
		assertEquals(pla.aCheminHB(),true);
	}
}
