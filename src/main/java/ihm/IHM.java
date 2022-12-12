package main.java.ihm;

import java.util.Scanner;

import main.java.hex.Plateau;
import main.java.joueurs.Aleatoire;
import main.java.joueurs.Humain;

public class IHM {
	public static void main(String args[]) {
	    // Cr�ation du plateau de jeu
		
		Scanner sc = new Scanner(System.in);
	    int taille;
	    Plateau p;
	    while(true) {
	    	System.out.print("Entrez la taille du plateau (entre 0 et 9) : ");
	    	String input = sc.next();
	    	try {
	    		taille = Integer.parseInt(input);
	    		if(taille>0 && taille<=Plateau.getTailleMax()) {
	    			break;
	    		}
	    	}
	    	catch (NumberFormatException ne) {
	    		System.out.println("Mauvais format, entrez un nombre entier.");
	    	}
	    }
	  
	    p=new Plateau(taille);
	    System.out.println("Votre plateau de taille " + taille + "x" + taille + " a bien �t� cr�� :\n" + p);
	    
	    // Choix du mode de jeu et lancement de la partie
	    
	    System.out.println("Quel mode de jeu voulez-vous choisir ?\n- Joueur VS Joueur (1)\n- Joueur VS IA (2)\n- IA VS IA (3)\n");
	    
	    Integer mode_jeu = sc.nextInt();
	    
	    switch(mode_jeu){
	       case 1: 
	           System.out.println("Lancement de la partie Joueur VS Joueur...\n");
	           partie2Humains(p);
	           break;
	   
	       case 2:
	           System.out.println("Lancement de la partie Joueur VS IA...\n");
	           partie1Humain1IA(p);
	           break;
	   
	       case 3:
	           System.out.println("Lancement de la partie IA VS IA...\n");
	           partie2IAs(p);
	           break;
	           
	       default:
	           System.out.println("Choix incorrect");
	   }
	    sc.close();
	}

	private static void partie2Humains(Plateau p) {
		// Enregistrement des joueurs
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel est le nom du premier joueur ?");
	    String nom_J1=sc.next();
	    System.out.println("Quel est le nom du deuxi�me joueur ?");
	    String nom_J2=sc.next();
	    Humain J1 = new Humain(nom_J1);
	    Humain J2 = new Humain(nom_J2);
		
	    // D�but de la partie
		while(!p.estGagne()) {
			// Coup du Joueur 1
			System.out.println(J1.getNom() + ", rentrez un coup : ");
	    	String coup_J1=sc.next();
			
	    	while(!(p.estJouable(coup_J1))) {
                System.out.println("Format de case invalide ou case pleine.");
                coup_J1=sc.next();
            }
	    	p.jouer(coup_J1);
	    	System.out.println(p);
	    	
	    	// Coup du Joueur 2
	    	System.out.println(J2.getNom() + ", rentrez un coup : ");
	    	String coup_J2=sc.next();
			
	    	while(!(p.estJouable(coup_J2))) {
                System.out.println("Format de case invalide ou case pleine.");
                coup_J2=sc.next();
            }
	    	p.jouer(coup_J2);
	    	System.out.println(p);
		}
		sc.close();
		
		// Affichage des gagnants
		// � faire
		
		System.out.println("Merci d'avoir jou� � Hex !");
	}

	private static void partie1Humain1IA(Plateau p) {
		// Enregistrement des joueurs
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel est le nom du joueur ?");
	    String nom_J=sc.next();
	    System.out.println("Quel est le nom de l'IA ?");
	    String nom_IA=sc.next();
	    Humain J = new Humain(nom_J);
	    Aleatoire IA = new Aleatoire(nom_IA);
	    
		// D�but de la partie
		while(!p.estGagne()) {
			// Coup du Joueur
			System.out.println(J.getNom() + ", rentrez un coup : ");
	    	String coup_J=sc.next();
			
	    	while(!(p.estJouable(coup_J))) {
                System.out.println("Format de case invalide ou case pleine.");
                coup_J=sc.next();
            }
	    	p.jouer(coup_J);
	    	System.out.println(p);
			
			// Coup de l'IA
	    	System.out.println(IA.getNom() + " (IA) a jou�.\n");
			p.jouer(IA.choisirCoup(p));
			System.out.println(p);
		}
		sc.close();
		
		// Affichage des gagnants
		// � faire
		System.out.println("Merci d'avoir jou� � Hex !");
	}

	private static void partie2IAs(Plateau p) {
		Aleatoire IA1 = new Aleatoire("IA1");
		Aleatoire IA2 = new Aleatoire("IA2");
		
		while(!p.estGagne()) {
			System.out.println(IA1.getNom() + " a jou�.\n");
			p.jouer(IA1.choisirCoup(p));
			System.out.println(p);
			System.out.println(IA2.getNom() + " a jou�.\n");
			p.jouer(IA2.choisirCoup(p));
			System.out.println(p);
		}
		
		// Affichage des gagnants
		// � faire
		System.out.println("Merci d'avoir jou� � Hex !");
	}
}