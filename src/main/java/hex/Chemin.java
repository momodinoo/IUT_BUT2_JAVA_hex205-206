package main.java.hex;

public class Chemin {
	public Pion[][] matrice; // private
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

	// Methode pour verifier les bordures
    public boolean estValide(int i, int j)
    {
        if (i >= 0 && i < matrice.length && j >= 0
                && j < matrice[0].length)
            return true;
        return false;
    }
    
    public void setMatrice(Pion[][] plateau){
		for (int lig = 0; lig < taille; ++lig)
			for (int col = 0; col < taille; ++col)
				matrice[lig][col] = plateau[col][lig];
	}

	// Methode recursive qui renvoie true si il y a un chemin depuis i,j
    public boolean aChemin(int i, int j, boolean visites[][])
    {

        // Verifie les bordures, si la case a bien la valeur qu'on cherche
    	// et si la case n'est pas encore visitée
        if (estValide(i, j) && (matrice[i][j] != Pion.Vide && matrice[i][j] != Pion.Rond)
                && !visites[i][j]) {
            // Marque la case comme visitée
        	visites[i][j] = true;
        	
        	// Ligne du bas
            if(i==matrice.length-1 /*&& matrice[i][j] == Pion.Croix*/){
                //System.out.println(i + " " + j);
                //System.out.println(matrice[i][j]);
                //System.out.println(matrice[0][3]);
            	return true;}

            // haut
            boolean haut = aChemin(i - 1, j, visites);

            // si chemin trouvé en haut
            if (haut)
                return true;

            // haut_gauche
            boolean haut_gauche = aChemin(i - 1, j - 1, visites);

            // si chemin trouvé en haut à gauche
            if (haut_gauche)
                return true;

            // gauche
            boolean gauche
                    = aChemin(i, j - 1, visites);

            // si chemin trouvé à gauche
            if (gauche)
                return true;

            // bas_gauche
            boolean bas_gauche
                    = aChemin(i + 1, j - 1, visites);

            // si chemin trouvé en bas à gauche
            if (bas_gauche)
                return true;

            // bas 
            boolean bas
                    = aChemin(i + 1, j, visites);

            // si chemin trouvé en bas
            if (bas)
                return true;

            // bas_droite
            boolean bas_droite
                    = aChemin(i + 1, j + 1, visites);

            // si chemin trouvé en bas à droite
            if (bas_droite)
                return true;

            // droite
            boolean droite
                    = aChemin(i, j + 1, visites);

            // si chemin trouvé à droite
            if (droite)
                return true;

            // haut_droite
            boolean haut_droite
                    = aChemin(i - 1, j + 1, visites);

            // si chemin trouvé en haut à droite
            if (haut_droite)
                return true;
        }
        // pas de chemin trouvé
        return false;
    }

    // Methode qui renvoie true si le chemin existe
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
                    if (aChemin(i, j, visites)) {
                        // si un chemin existe
                        chemin = true;
                        break;
                    }
            }
        }
        /*for(int i = 0; i < visites.length; i++)
            System.out.println(Arrays.toString(visites[i]));
        System.out.println(chemin);

        for (Pion[] str : matrice) {
            for (Pion s : str) {
                System.out.print(s + "\t");
            }
            System.out.println("\n");

        }*/
        return chemin;
    }

	/*public boolean aCheminGD() {
		int taille=matrice.length;
    	
        // Matrice pour inscrire les cases visitées
        boolean visites[][] = new boolean[taille][taille];

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
            	// détermine le départ (ici la ligne de gauche)
                if (matrice[i][0]==Pion.Rond)  matrice[0][j]=Pion.Depart;
                
                // si la case est un départ et n'est pas visitée
                if (matrice[i][j] == Pion.Depart && !visites[i][j])
                    // On cherche un chemin depuis i,j
                    if (aChemin(i, j, visites)) {
                        // si un chemin existe
                        chemin = true;
                        break;
                    }
            }
        }
        for(int i = 0; i < visites.length; i++)
            System.out.println(Arrays.toString(visites[i]));

        for (Pion[] str : matrice) {
            for (Pion s : str) {
                System.out.print(s + "\t");
            }
            System.out.println("\n");

        }
        
		return chemin;
	}
	
	
	public boolean asrt(int i, int j, boolean visites[][])
    {
        if (estValide(i, j) && matrice[i][j] != Pion.Vide && matrice[i][j] != Pion.Rond
                && !visites[i][j]) {
        	visites[i][j] = true;
        	
        	// ligne de droite KLHZIFBZJ
            if(i==matrice.length-1){
                System.out.println(i);
                return true;}

            // haut
            boolean haut
            		= aChemin(i - 1, j, visites);
            if (haut)
                return true;
            boolean haut_gauche
            		= aChemin(i - 1, j - 1, visites);
            if (haut_gauche)
                return true;
            boolean gauche
                    = aChemin(i, j - 1, visites);
            if (gauche)
                return true;
            boolean bas_gauche
                    = aChemin(i + 1, j - 1, visites);
            if (bas_gauche)
                return true;
            boolean bas
                    = aChemin(i + 1, j, visites);
            if (bas)
                return true;
            boolean bas_droite
                    = aChemin(i + 1, j + 1, visites);
            if (bas_droite)
                return true;
            boolean droite
                    = aChemin(i, j + 1, visites);
            if (droite)
                return true;
            boolean haut_droite
                    = aChemin(i - 1, j + 1, visites);
            if (haut_droite)
                return true;
        }
        return false;
    }
*/
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