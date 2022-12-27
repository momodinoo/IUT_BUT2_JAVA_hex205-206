package main.java.hex;

public class Chemin {
	private Pion[][] matrice;
	private boolean chemin;
	private int taille;
	
	public Chemin(Pion[][] plateau) {
		chemin = false;
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
    public boolean aCheminHB()
    {
    	// Matrice pour inscrire les cases visitées
        boolean visites[][] = new boolean[taille][taille];

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
            	// détermine le départ (ici la ligne du haut)
                if (matrice[0][j]==Pion.Croix)  matrice[0][j]=Pion.Depart;
                
                // si la case est un départ et n'est pas visitée
                if (matrice[i][j] == Pion.Depart && !visites[i][j])
                    // On cherche un chemin depuis i,j
                    if (aCheminHB2(i, j, visites)) {
                        // si un chemin existe
                        chemin = true;
                        break;
                    }
            }
        }
        return chemin;
    }
    
    // Methode qui renvoie true si le chemin existe entre la gauche et la droite de la matrice
   	public boolean aCheminGD() {
           boolean visites[][] = new boolean[taille][taille];

           for (int i = 0; i < taille; i++) {
               for (int j = 0; j < taille; j++) {
                   if (matrice[i][0]==Pion.Rond)  matrice[i][0]=Pion.Depart2;
                   
                   if (matrice[i][j] == Pion.Depart2 && !visites[i][j])
                       if (aCheminGD2(i,j, visites)) {
                           chemin = true;
                           break;
                       }
               }
           }
   		return chemin;
   	}
  
	// Methode recursive qui renvoie true si il y a un chemin depuis i,j / condition d'arrêt pour un chemin entre le haut et le bas
    public boolean aCheminHB2(int i, int j, boolean visites[][])
    {
        // Verifie les bordures, si la case a bien la valeur qu'on cherche
    	// et si la case n'est pas encore visitée
        if (estValide(i, j) && (matrice[i][j] == Pion.Croix || matrice[i][j] == Pion.Depart)
                && !visites[i][j]) {
            // Marque la case comme visitée
        	visites[i][j] = true;
        	
        	// Ligne du bas
            if(i==matrice.length-1){
            	return true;}

            // haut
            boolean haut = aCheminHB2(i - 1, j, visites);

            // si chemin trouvé en haut
            if (haut) return true;

            // gauche
            boolean gauche = aCheminHB2(i, j - 1, visites);

            // si chemin trouvé à gauche
            if (gauche) return true;

            // bas_gauche
            boolean bas_gauche = aCheminHB2(i + 1, j - 1, visites);

            // si chemin trouvé en bas à gauche
            if (bas_gauche) return true;

            // bas 
            boolean bas = aCheminHB2(i + 1, j, visites);

            // si chemin trouvé en bas
            if (bas) return true;

            // droite
            boolean droite = aCheminHB2(i, j + 1, visites);

            // si chemin trouvé à droite
            if (droite) return true;

            // haut_droite
            boolean haut_droite = aCheminHB2(i - 1, j + 1, visites);

            // si chemin trouvé en haut à droite
            if (haut_droite) return true;
        }
        // pas de chemin trouvé
        return false;
    }

    // Methode recursive qui renvoie true si il y a un chemin depuis i,j / condition d'arrêt pour un chemin entre la gauche et la droite
	public boolean aCheminGD2(int i, int j, boolean visites[][])
    {
        if (estValide(i, j) && (matrice[i][j] == Pion.Rond || matrice[i][j] == Pion.Depart2)
                && !visites[i][j]) {
        	visites[i][j] = true;
        	
        	// Ligne de droite
            if(j==matrice.length-1){
            	return true;}

            // haut
            boolean haut = aCheminGD2(i - 1, j, visites);
            if (haut)return true;

            // gauche
            boolean gauche = aCheminGD2(i, j - 1, visites);
            if (gauche) return true;

            // bas_gauche
            boolean bas_gauche = aCheminGD2(i + 1, j - 1, visites);
            if (bas_gauche) return true;

            // bas 
            boolean bas = aCheminGD2(i + 1, j, visites);
            if (bas) return true;

            // droite
            boolean droite = aCheminGD2(i, j + 1, visites);
            if (droite)return true;

            // haut_droite
            boolean haut_droite = aCheminGD2(i - 1, j + 1, visites);
            if (haut_droite) return true;
            }
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