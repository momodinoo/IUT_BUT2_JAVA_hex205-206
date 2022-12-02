package main.java.joueurs;

import java.util.LinkedList;

import main.java.hex.Pion;

public class Humain implements IJoueur{
	private String nom;
	private LinkedList<Pion> chemin;
	
	public Humain(String n) {
		nom=n;
		chemin=new LinkedList<Pion>();
	}

	public String getNom() {
		return nom;
	}
	
	public void addChemin(Pion p) {
		chemin.add(p);
	}

	public LinkedList<Pion> getChemin() {
		return chemin;
	}
}
