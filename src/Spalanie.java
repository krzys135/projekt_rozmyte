
public class Spalanie extends Cecha{
	
	private static int max = 14;
	public static int bd = 11;
	public static int d = 9;
	public static int m = 7;
	public static int bm = 5;
	private static int min = 4;
	public static final int numer = 3;
	
	public Spalanie(int stopien){
            super(stopien);
	}
	
	double trafnoscBm(int wartosc){
		if(wartosc > bm) return Math.max(
				(1d/((double)bm - (double)m))*(double)wartosc +
				((double)m/(double)m-(double)bm), 0.0);
		else return 1.0;
	}
	
	double trafnoscM(int wartosc){
		if(wartosc > m) return Math.max(
				(1d/((double)m-(double)d))*(double)wartosc +
				(double)d/((double)d-(double)m), 0.0);
		else if(wartosc < bm) return Math.max(
				(1d/((double)bm-(double)min))*(double)wartosc +
				(double)min/((double)min-(double)bm), 0.0);
		else return 1.0;
	}
	
	double trafnoscS(int wartosc){
		if(wartosc > d) return Math.max(
				(1d/((double)d-(double)bd))*(double)wartosc + 
				(double)bd/((double)bd-(double)d), 0.0);
		else if(wartosc < m) return Math.max(
				(1d/((double)m-(double)bm))*(double)wartosc +
				(double)bm/((double)bm-(double)m), 0.0);
		else return 1.0;
	}
	
	double trafnoscD(int wartosc){
		if(wartosc > bd) return Math.max(
				(1d/((double)bd-(double)max))*(double)wartosc +
				(double)max/((double)max-(double)bd), 0.0);
		else if(wartosc < d) return Math.max(
				(1d/((double)d-(double)m))*(double)wartosc + 
				(double)m/((double)m-(double)d), 0.0);
		else return 1.0;
	}
	
	double trafnoscBd(int wartosc){
		if(wartosc < bd) return Math.max(
				(1d/((double)bd-(double)d))*(double)wartosc +
				(double)d/((double)d-(double)bd), 0.0);
		else return 1.0;
	}
	
	public boolean ustaw(int bdn, int dn, int mn, int bmn){
		if(max > (bdn+2) && bdn > (dn+2) && dn > (mn+2) && mn > (bmn+2) && bmn > (min+2) ){
			bd = bdn;
			d = dn;
			m = mn;
			bm = bmn;
			return true;
		} else return false;
	}
	
	public int[] getPrzedzialy(){
		int[] tab = new int[6];
		tab[0] = max;
		tab[1] = bd;
		tab[2] = d;
		tab[3] = m;
		tab[4] = bm;
		tab[5] = min;
		return tab;
	}
	
	public int wezNumer(){return numer;}
	
	public int przedzial(int wartosc){
		if(wartosc < bm) return 0;
		else if(wartosc < m) return 1;
		else if(wartosc < d) return 2;
		else if(wartosc < bd) return 3;
		else return 4;
	}
}
