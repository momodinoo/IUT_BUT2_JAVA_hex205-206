package main.java.hex;

public class Plateau {
	private final static int TAILLE_MAX = 9;
	private final static int NB_JOUEURS = 2;
	private final static int PREMIERE_COLONNE = 'A';
	private final static int PREMIERE_LIGNE = '1';
	
	private Pion[][] t;
	private int joueur = 0; // prochain � jouer
	
	public Plateau(int taille) {
		// init plateau vide
		assert taille > 0 && taille <= TAILLE_MAX;
		t = new Pion [taille][taille];
		
		for (int lig = 0; lig < taille(); ++lig)
			for (int col = 0; col < taille(); ++col)
				t[col][lig] = Pion.Vide;
	}
	
	public Plateau(int taille, String pos) {
		// init plateau gr�ce � pos
		assert taille > 0 && taille <= TAILLE_MAX;
		t = new Pion [taille][taille];
		
		String[] lignes = decouper(pos);
		
		for (int lig = 0; lig < taille(); ++lig)
			for (int col = 0; col < taille(); ++col)
				t[col][lig] = 
				  Pion.get(lignes[lig].charAt(col));
		
		// si la pos est pas entre 0 et 2, c'est invalide
		if (getNb(Pion.Croix) != getNb(Pion.Rond) &&
			getNb(Pion.Croix) != (getNb(Pion.Rond)+1) &&
					getNb(Pion.Croix) != (getNb(Pion.Rond)-1))
			throw new IllegalArgumentException(
					"position non valide");
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
		suivant(); // pr�pare le coup pour le joueur suivant
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

	public int getNb(Pion pion) {
		int nb = 0;
		for (Pion [] ligne : t)
			for (Pion p : ligne)
				if (p == pion)
					++nb;
		return nb;
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

	public static String[] decouper(String pos) {
		// d�coupe un string entier en string de string (pour init t)
		int taille = getTaille(pos);
		String[] lignes = new String[taille];
		for (int i = 0; i <taille; ++i)
			lignes[i] = pos.substring(i*taille,
					(i+1)*taille);
		return lignes;
		
	}

	public boolean estGagne() {
		// TODO Auto-generated method stub
		return false;
	}





}
