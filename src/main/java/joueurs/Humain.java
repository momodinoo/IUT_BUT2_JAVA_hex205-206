package main.java.joueurs;

import main.java.hex.IJoueur;

public class Humain implements IJoueur{
	private String nom;
	
	public Humain(String n) {
		nom=n;
	}

	public String getNom() {
		return nom;
	}

}
