package sources.hex;

public class Plateau {
	// private final static int CROIX = -1;
	// private final static int ROND = 1;
	// private final static int VIDE = 0;
	private final static int TAILLE_MAX = 26;
	
	private int[][] t;
	public Plateau(int taille) {
		assert taille > 0 && taille <= TAILLE_MAX;
		
		t = new Pion [taille][taille];
		for (int lig = 0; lig < taille(); ++lig)
			for (int col = 0; col<taille(); ++col)
				t[col][lig] = Pion.Vide;
	}
	
	public int taille() {
		return t.length;
	}
	
	private char symbole (int val) {
		if (val == CROIX) 
			return 'X';
		else if (val == ROND)
			return 'O';
		else if (val == VIDE)
			return '.';
		else throw new IllegalArgumentException(
				"" + val + " : symbole inconnu");
	}
	
	private String espaces(int n) {
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
				s+= " "+ symbole(t[col][lig]);
			s+='\n';
		}
		return s;
	}





}
