package main.java.hex;

public class Chemin {
	private Pion[][] matrice;
	private boolean cheminHB;
	private boolean cheminGD;
	private int taille;
	
	public Chemin(Pion[][] plateau) {
		cheminHB = false;
		cheminGD=false;
		matrice = new Pion [plateau.length][plateau.length];
		taille=matrice.length;
		
		for (int lig = 0; lig < taille; ++lig)
			for (int col = 0; col < taille; ++col)
				matrice[lig][col] = Pion.Vide;
		setMatrice(plateau);
	}

	public void setMatrice(Pion[][] plateau){
		for (int lig = 0; lig < taille; ++lig)
			for (int col = 0; col < taille; ++col)
				matrice[lig][col] = plateau[col][lig];
	}
	
	// Methode pour verifier les bordures
    public boolean estValide(int i, int j)
    {
        if (i >= 0 && i < matrice.length && j >= 0
                && j < matrice[0].length)
            return true;
        return false;
    }
    
    // Methode qui renvoie true si le chemin existe entre le haut et le bas de la matrice
    public boolean aCheminHB(){	
    	if (!cheminGD && !cheminHB) {
    		// Matrice pour inscrire les cases visitées
	        boolean visites[][] = new boolean[taille][taille];
	
	        for (int i = 0; i < taille; i++) {
	            // si la case est un départ et n'est pas visitée
	            if (matrice[0][i] == Pion.Croix && !visites[0][i])
	                // On cherche un chemin depuis i,j
	                if (aChemin(0, i, visites,Pion.Croix)) {
	                    // si un chemin existe
	                    cheminHB = true;
	                }
	        }
        }
        return cheminHB;
    }
    
    // Methode qui renvoie true si le chemin existe entre la gauche et la droite de la matrice
   	public boolean aCheminGD() {
   		if (!cheminGD && !cheminHB) {
   			boolean visites[][] = new boolean[taille][taille];
            for (int i = 0; i < taille; i++) {
               if (matrice[i][0] == Pion.Rond && !visites[i][0])
                   if (aChemin(i,0, visites,Pion.Rond)) {
                       cheminGD = true;
                   }
           }
   		}
   		return cheminGD;
   	}
  
	// Methode recursive qui renvoie true si il y a un chemin depuis i,j / condition d'arrêt pour un chemin entre le haut et le bas
    public boolean aChemin(int i, int j, boolean visites[][],Pion pion)
    {
        // Verifie les bordures, si la case a bien la valeur qu'on cherche
    	// et si la case n'est pas encore visitée
        if (estValide(i, j) && (matrice[i][j] == pion)
                && !visites[i][j]) {
            // Marque la case comme visitée
        	visites[i][j] = true;
        	
        	// Ligne du bas
        	if (pion == Pion.Croix) {
        		if(i == matrice.length-1){
	            	return true;
	            	}
        	}
	        // Colonne de gauche
        	if (pion == Pion.Rond) {
        		if(j == matrice.length-1){
	            	return true;
	            	}
        	}
        	
            // haut
            boolean haut = aChemin(i - 1, j, visites, pion);

            // si chemin trouvé en haut
            if (haut) return true;

            // gauche
            boolean gauche = aChemin(i, j - 1, visites, pion);

            // si chemin trouvé à gauche
            if (gauche) return true;

            // bas_gauche
            boolean bas_gauche = aChemin(i + 1, j - 1, visites, pion);

            // si chemin trouvé en bas à gauche
            if (bas_gauche) return true;

            // bas 
            boolean bas = aChemin(i + 1, j, visites, pion);

            // si chemin trouvé en bas
            if (bas) return true;

            // droite
            boolean droite = aChemin(i, j + 1, visites, pion);

            // si chemin trouvé à droite
            if (droite) return true;

            // haut_droite
            boolean haut_droite = aChemin(i - 1, j + 1, visites, pion);

            // si chemin trouvé en haut à droite
            if (haut_droite) return true;
        }
        // pas de chemin trouvé
        return false;
    }
	
    public String toString() {
    	String s="";
    	for (int lig = 0; lig < taille; ++lig) {
			for (int col = 0; col < taille; ++col)
				s+= " "+ matrice[lig][col];
			s+='\n';
		}
    	return s;
    }
}