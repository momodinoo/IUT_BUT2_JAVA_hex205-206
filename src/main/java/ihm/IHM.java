package main.java.ihm;

import java.util.Scanner;

import main.java.hex.Pion;
import main.java.hex.Plateau;
import main.java.joueurs.Humain;

public class IHM {
	public static void main(String args[]) {
	    Scanner sc = new Scanner(System.in);
	    int taille;
	    Plateau p;
	    while(true) {
	    	System.out.print("Entrez la taille du plateau : ");
	    	String input = sc.next();
	    	try {
	    		taille = Integer.parseInt(input);
	    		break;
	    	} catch (NumberFormatException ne) {
	    		System.out.println("Mauvais format, entrez un nombre entier.");
	    	}
	    }
	    System.out.println(taille);
	    p=new Plateau(taille);
	    System.out.println("Votre tableau de taille " + taille + "x" + taille + " a bien été créé : \n" + p);
	    
	    
	    System.out.println("Quel est le nom du premier joueur ?");
	    String nom_J1=sc.next().toLowerCase();
	    
	    System.out.println("Quel est le nom du deuxième joueur ?");
	    String nom_J2=sc.next().toLowerCase();
	    
	    Humain J1 = new Humain(nom_J1);
	    Humain J2 = new Humain(nom_J2);
	  
	    
	    while(!p.estGagne()) {
	    	try {
	    		System.out.println(J1.getNom() + ", rentrez un coup : ");
		    	String coup_J1=sc.next();
		    	if(!(p.getCase(coup_J1)==Pion.Vide)) {
		    		System.out.println("Case déjà prise, en choisir une autre");
		    		coup_J1=sc.next();
		    	}
		    	p.jouer(coup_J1);
		    	System.out.println(p);
	    	}
		    catch(RuntimeException e){
		    	System.out.println("Format invalide");
		    }
	    		
	    	try {
	    		System.out.println(J2.getNom() + ", rentrez un coup : ");
		    	String coup_J2=sc.next();
		    	if(!(p.getCase(coup_J2)==Pion.Vide)) {
		    		System.out.println("Case déjà prise, en choisir une autre");
		    		coup_J2=sc.next();
		    	}
		    	p.jouer(coup_J2);
		    	System.out.println(p);
	    	}
		    catch(RuntimeException e){
		    	System.out.println("Format invalide");
		    }
	    }
	    System.out.println("affichage gagnant");
	    
	    sc.close();
	}
}