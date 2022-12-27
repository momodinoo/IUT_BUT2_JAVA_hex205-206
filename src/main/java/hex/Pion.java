package main.java.hex;

public enum Pion {
	Croix('X'), Rond('O'), Vide('.'), Depart('D'), Depart2('E');
	// La valeur Depart sert seulement pour la détection d'un chemin de haut en bas
	// La valeur Depart2 sert seulement pour la détection d'un chemin de gauche à droite
	private char symbole;
	private Pion (char symbole) {
		this.symbole = symbole;
	}
	@Override
	public String toString() {
		return ""+symbole;
	}
	public static Pion get(char c) {
		// transforme 'X' en Croix
		for (Pion p : Pion.values())
			if (p.symbole == c)
				return p;
		throw new IllegalArgumentException(
				"symbole inconnu " + c);
	}
}
