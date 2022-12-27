package main.java.hex;

public class Plateau {
	private final static int TAILLE_MAX = 9;
	private final static int NB_JOUEURS = 2;
	private final static int PREMIERE_COLONNE = 'A';
	private final static int PREMIERE_LIGNE = '1';
	
	private Pion[][] t;
	private int joueur = 0; // prochain à jouer
	private Chemin chemin;
	
	public Plateau(int taille) {
		// init plateau vide
		assert taille > 0 && taille <= TAILLE_MAX;
		t = new Pion [taille][taille];
		
		for (int lig = 0; lig < taille(); ++lig)
			for (int col = 0; col < taille(); ++col)
				t[col][lig] = Pion.Vide;
		
		chemin = new Chemin(t);
	}

	public Chemin getChemin() {
		return chemin;
	}
	
	public void updateChemin() {
		chemin.setMatrice(t);
	}
	private void suivant() {
		joueur = (joueur +1) % NB_JOUEURS;
	}
	
	public void jouer(String coord){
		assert estJouable(coord);
		Pion pion = Pion.values()[joueur];
		int col = getColonne(coord);
		int lig = getLigne(coord);
		t[col][lig] = pion;
		suivant(); // prépare le coup pour le joueur suivant
	}
	
	public static int getTaille(String pos) {
		int taille = (int) Math.sqrt(pos.length());
		assert taille * taille == pos.length();
		return taille;
	}

	public boolean estJouable(String coord) {
		return estValide(coord) && estVide(coord);
	}
	
	public boolean estValide(String coord) {
		if (coord.length() !=2)
			return false;
		int col = getColonne(coord);
		int lig = getLigne(coord);
		if (col <0 || col >= taille())
			return false;
		if (lig <0 || lig >= taille())
			return false;
		return true;
	}
	
	public boolean estVide(String coord) {
		int col = getColonne(coord);
		int lig = getLigne(coord);
		if (t[col][lig]==Pion.Vide)
			return true;
		return false;
	}
	
	public Pion getCase(String coord) {
		// renvoie le contenu de la case / ex : "B2" -> contenu de la case [1][1]
		assert estValide(coord);
		int col = getColonne(coord);
		int lig = getLigne(coord);
		return t[col][lig];
	}

	public static int getTailleMax() {
		return TAILLE_MAX;
	}

	private int getColonne(String coord) {
		return coord.charAt(0) - PREMIERE_COLONNE; // ex 'B' -'A' == 1
	}
	
	private int getLigne(String coord) {
		return coord.charAt(1) - PREMIERE_LIGNE; // ex '2' - '0' == 2
	}

	public int taille() {
		// taille tableau (nb de lignes/colonnes)
		return t.length;
	}
	
	private String espaces(int n) {
		// renvoie un String de n espaces
		String s = "";
		for(int i = 0; i < n; ++i)
			s+= " ";
		return s;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < taille(); ++i)
			s+=" "+(char)( 'A' + i);
		s+='\n';
		for (int lig = 0; lig < taille(); ++lig) {
			s+= lig+1 + espaces (lig);
			for (int col = 0; col < taille(); ++col)
				s+= " "+ t[col][lig];
			s+='\n';
		}
		return s;
	}

	public boolean estGagne() {
		return (aCheminHB() /*|| aCheminGD()*/);
	}

	public boolean aCheminHB() {
		return chemin.aCheminHB();
	}
		
	public boolean aCheminGD() {
		return chemin.aCheminGD();
	}
}
