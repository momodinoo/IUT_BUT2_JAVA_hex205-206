package main.java.joueurs;

import main.java.hex.IJoueur;

public class Joueur implements IJoueur{
	private String nom;
	
	public Joueur(String n) {
		nom=n;
	}
	
	/*
	 * Getter du nom d'un Joueur
	 * @return un String, le nom du joueur
	 */
	public String getNom() {
		return nom;
	}
}
