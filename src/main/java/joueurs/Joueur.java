package main.java.joueurs;

import main.java.hex.IJoueur;

public class Joueur implements IJoueur{
	private String nom;
	
	public Joueur(String n) {
		nom=n;
	}
	
	public String getNom() {
		return nom;
	}
}
