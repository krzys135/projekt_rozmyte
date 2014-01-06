
public class Cecha {

	private int stopien;

	public Cecha(int stopien){
		this.stopien=stopien;
	}
	
	public double trafnosc(int wartosc){
		switch(stopien){
		case 1: return trafnoscBm(wartosc);
		case 2: return trafnoscM(wartosc);
		case 3: return trafnoscS(wartosc);
		case 4: return trafnoscD(wartosc);
		case 5: return trafnoscBd(wartosc);
		default: return 0.0;
		}
	}
	
	double trafnoscBm(int wartosc){return 0.0;}
	double trafnoscM(int wartosc){return 0.0;}
	double trafnoscS(int wartosc){return 0.0;}
	double trafnoscD(int wartosc){return 0.0;}
	double trafnoscBd(int wartosc){return 0.0;}
	
	public boolean ustaw(int bd, int d, int m, int bm){return false;}
	
	public int[] getPrzedzialy(){return null;}
	
	public int wezNumer(){return 0;}
	
	public int przedzial(int wartosc){return 6;}

}
