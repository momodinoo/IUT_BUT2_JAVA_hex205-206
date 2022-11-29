package sources.hex;

public class Plateau {
	private final static int TAILLE_MAX = 26;
	private final static int NB_JOUEURS = 2;
	private final static char COL_0 = 'A';
	
	private Pion[][] t;

	public Plateau(int taille) { // crée un plateau vide
		assert taille > 0 && taille <= TAILLE_MAX;
		
		t = new Pion [taille][taille];
		
		for (int lig = 0; lig < taille(); ++lig)
			for (int col = 0; col < taille(); ++col)
				t[col][lig] = Pion.Vide;
	}
	
	public Plateau(int taille, String pos) {//crée un plateau à l'aide de pos
		assert taille > 0 && taille <= TAILLE_MAX;
		t = new Pion [taille][taille];
		
		String[] lignes = decouper(taille, pos);
		
		for (int lig = 0; lig < taille(); ++lig)
			for (int col = 0; col < taille(); ++col)
				t[col][lig] = Pion.get(lignes[lig].charAt(col));
	}
	
	public int taille() {
		return t.length;
	}
	
	
	private String espaces(int n) {
		String s = "";
		for(int i = 0; i < n; ++i)
			s+= " ";
		return s;
	}
	
	public String[] decouper(int taille,String position) {
		assert position.length() == taille* taille;
		String [] lignes= new String[taille];
		
		for (int i=0;i<taille;++i) {
			lignes[i]=position.substring(i*taille,(i+1)*taille);
		}
		
		return lignes;
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
	
	private int getColonne(String coord) {
		return coord.charAt(0) - COL_0;
	}

}
