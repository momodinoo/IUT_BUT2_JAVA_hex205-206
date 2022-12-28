package main.java.hex;

public class Plateau {
	private final static int TAILLE_MAX = 9;
	private final static int NB_JOUEURS = 2;
	private final static int PREMIERE_COLONNE = 'A';
	private final static int PREMIERE_LIGNE = '1';
	
	private Pion[][] t;
	private int joueur = 0;
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
	
	private void suivant() {
		joueur = (joueur +1) % NB_JOUEURS;
	}
	
	/*
	 * Joue un coup dans une case 
	 * @param coord, les coordonnées de la casae dans laquelle il faut jouer
	 */
	public void jouer(String coord){
		assert estJouable(coord);
		Pion pion = Pion.values()[joueur];
		int col = getColonne(coord);
		int lig = getLigne(coord);
		t[col][lig] = pion;
		suivant(); // prépare le coup pour le joueur suivant
	}
	
	/*
	 * Regarde si une case est jouable (si elle est valide et vide)
	 * @param coord, les coordonnées de la case à vérifier
	 * @return true si la case est jouable, false sinon
	 */
	public boolean estJouable(String coord) {
		return estValide(coord) && estVide(coord);
	}
	
	/*
	 * Regarde si une case est valide (si elle est dans le plateau)
	 * @param coord, les coordonnées de la case à vérifier
	 * @return true si la case est dans le plateau, false sinon
	 */
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
	
	/*
	 * Regarde si une case est vide
	 * @param coord, les coordonnées de la case à vérifier
	 * @return true si la case est vide, false sinon
	 */
	public boolean estVide(String coord) {
		int col = getColonne(coord);
		int lig = getLigne(coord);
		if (t[col][lig]==Pion.Vide)
			return true;
		return false;
	}
	
	/*
	 * Renvoie le contenu d'une case
	 * @param coord, les coordonnées de la case dont le contenu est renvoyé
	 * @return une valeur Pion, le contenu de la case en "coord"
	 */
	public Pion getCase(String coord) {
		assert estValide(coord);
		int col = getColonne(coord);
		int lig = getLigne(coord);
		return t[col][lig];
	}
	
	/*
	 * Getter de la taille max possible pour un plateau
	 * @return taille max possible pour un plateau
	 */
	public static int getTailleMax() {
		return TAILLE_MAX;
	}
	
	/*
	 * Renvoie l'indice d'une colonne correspondant aux coordonnées d'une case
	 * @param coord, les coordonnées de la case
	 * @return un int (par ex : 'B' -'A' == 1)
	 */
	private int getColonne(String coord) {
		return coord.charAt(0) - PREMIERE_COLONNE;
	}
	
	/*
	 * Renvoie l'indice d'une ligne correspondant aux coordonnées d'une case
	 * @param coord, les coordonnées de la case
	 * @return un int (par ex : '2' - '0' == 2)
	 */
	private int getLigne(String coord) {
		return coord.charAt(1) - PREMIERE_LIGNE;
	}
	
	/*
	 * Renvoie la taille du plateau actuel
	 * @return un int, la taille
	 */
	public int taille() {
		return t.length;
	}
	
	/*
	 * Renvoie le chemin associé au plateau actuel
	 * @return un chemin
	 */
	public Chemin getChemin() {
		return chemin;
	}
	
	/*
	 * Met à jour le chemin associé au plateau avec les valeurs du plateau
	 */
	public void updateChemin() {
		chemin.setMatrice(t);
	}
	/*
	 * Renvoie un String de n espaces
	 * @param n, le nombre d'espaces
	 * @return un String
	 */
	private String espaces(int n) {
		String s = "";
		for(int i = 0; i < n; ++i)
			s+= " ";
		return s;
	}
	
	/*
	 * Determine si une partie est gagnée ou non (chemin entre haut-bas ou chemin entre gauche-droite)
	 * @return true si la partie est gagnée, false sinon
	 */
	public boolean estGagne() {
		return (aCheminHB() || aCheminGD());
	}
	
	/*
	 * Checke si il y a un chemin entre le haut et le bas du plateau
	 * @return true si il y a un chemin, false sinon
	 */
	public boolean aCheminHB() {
		return chemin.aCheminHB();
	}
	
	/*
	 * Checke si il y a un chemin entre la gauche et la droite du plateau
	 * @return true si il y a un chemin, false sinon
	 */
	public boolean aCheminGD() {
		return chemin.aCheminGD();
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
}
