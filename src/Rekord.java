import java.math.BigDecimal;


public class Rekord implements Comparable<Object>{
	
	String nazwa;
	int Bialko;
	int Tluszcz;
	int Wegl;
	int Kcal;
	double TrafKon=0;
	double TrafKonSum = 0;
	int TrafKonIle = 0;
	double TrafPoz=0;
	double TrafPozSum = 0;
	int TrafPozIle = 0;
	double satysfakcja;
	BigDecimal Satysfakcja;
	protected int nr;
	//(double)
	public Rekord(String nazwa, int Bialko, int Tluszcz, int Wegl, int Kcal){
		this.nazwa=nazwa;
		this.Bialko=Bialko;
		this.Tluszcz=Tluszcz;
		this.Wegl=Wegl;
		this.Kcal=Kcal;
		nr = 0;
	}

	public double getTrafKon() {
		return TrafKon;
	}

	public void setTrafKon(double trafKon) {
		TrafKonSum = TrafKonSum + trafKon;
		TrafKonIle++;
		TrafKon = TrafKonSum/(double)TrafKonIle;
	}

	public double getTrafPoz() {
		return TrafPoz;
	}

	public void setTrafPoz(double trafPoz) {
		TrafPozSum = TrafPozSum + trafPoz;
		TrafPozIle++;
		TrafPoz = TrafPozSum/(double)TrafPozIle;
	}
	
	public void setSatysfakcja(double d){
		satysfakcja = d;
		int decimalPlaces = 3;
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
		Satysfakcja = bd;
	}
	
	public int compareTo(Object arg0) throws ClassCastException{
		Rekord rec = (Rekord) arg0;
		if(this.satysfakcja > rec.satysfakcja){
			return 1;
		} else {
			if(this.satysfakcja == rec.satysfakcja) return 0;
			else return -1;
		}
	}	

	public String toString(){
		return nazwa + " " + String.valueOf(Bialko) + " " + String.valueOf(Tluszcz) + " " +
			String.valueOf(Wegl) + " " + String.valueOf(Kcal) + " " + Satysfakcja;
	}
}
