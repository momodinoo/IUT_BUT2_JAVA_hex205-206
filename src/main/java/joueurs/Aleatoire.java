package main.java.joueurs;

import java.util.Random;

import main.java.hex.IJoueur;
import main.java.hex.Plateau;

public class Aleatoire implements IJoueur{
	private String nom;
	
	public Aleatoire(String n) {
		nom=n;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String choisirCoup(Plateau p) {
		StringBuilder sb = new StringBuilder();
		String coord;
		Random r = new Random();
		char col = (char)(r.nextInt(p.taille())+'A'); // tire une lettre (colonne au hasard)
		int lig = r.nextInt(p.taille())+1; // tire un chiffre (une ligne) au hasard)
		
		sb.append(col);
		sb.append(lig);
		coord=sb.toString();
		
		// Verifie que la case tiree est jouable, sinon retire
		while(!p.estJouable(coord))
			coord=choisirCoup(p);
		
		return coord;
	}
}