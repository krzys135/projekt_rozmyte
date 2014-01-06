import java.sql.*;
import java.util.*;

public class Zapytania {

	private Statement Stm;
	private Connection Con;
	protected ResultSet Wyniki;
	public LinkedList<Cecha> Konieczne;
	public LinkedList<Cecha> Pozadane;
	boolean connected;
	protected OperatoryLogiczne rozwiaz;
	protected Cecha warunek;
	
	public Zapytania(){
		Konieczne = new LinkedList<Cecha>();
		Pozadane = new LinkedList<Cecha>();
		rozwiaz = new OperatoryLogiczne();
	}//konstruktor
	
	public void polacz(String user, String pass, String adres) {
		System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://" + adres + "/baza_rozmyte";
		try{
			Con = DriverManager.getConnection(url, user, pass);
			Stm = Con.createStatement();
			connected=true;
		}catch(SQLException e){
			connected=false;
		}
	}
	
	private void zapytaj(String zapytanie) throws SQLException{
			Wyniki=Stm.executeQuery(zapytanie);
	}//zapytaj
	
	public Rekord[] posortuj(String zapytanie){
		boolean som = true;
		try{
			zapytaj(zapytanie);
		}catch(SQLException sqle){ 
			if(sqle.getErrorCode() == 0) connected = false;
			som = false;
		}
		
		if(som){
			
			//			***			***			***
			
			ArrayList<Rekord> Rekordy = new ArrayList<Rekord>();
			Rekord rekord;
			double max[];
			if(warunek == null) max = new double[1];
			else max = new double[5];
			double tmp = 0;
			int nr = 0;
			double dSum = 0;
			try{
				//ustalenie stopnia spe³nienia zapytania
				//dla wszystkich rekordów spêlniaj¹cych warunki konieczne
				while(Wyniki.next()){
					rekord = new Rekord(Wyniki.getString(1), Wyniki.getInt(2),
							Wyniki.getInt(3), Wyniki.getInt(4), Wyniki.getInt(5));
					for(Cecha cecha: Konieczne){
						rekord.setTrafKon(cecha.trafnosc(Wyniki.getInt(cecha.wezNumer())));	
					}
					for(Cecha cecha: Pozadane){
						rekord.setTrafPoz(cecha.trafnosc(Wyniki.getInt(cecha.wezNumer())));	
					}
					
					tmp = rozwiaz.koniunkcja(rekord.TrafKon, rekord.TrafPoz);
					if(warunek == null){
						if(tmp > max[0]) max[0] = tmp;
					} else {
						nr = warunek.przedzial(Wyniki.getInt(warunek.wezNumer()));
						rekord.nr = nr;
						if(tmp > max[nr]) max[nr] = tmp;
					}
					Rekordy.add(rekord);
				}
			}catch(SQLException sqle) { System.out.println(sqle.getMessage()); }
			if(Rekordy.size() == 0) {
				Rekord[] rekordy = new Rekord[1];
				rekordy[0] = new Rekord("",0,0,0,0);
				return rekordy;
			}
			//******
			System.out.println("---------");
			for(int i = 0; i < max.length; i++){
				System.out.print(max[i] + " ");
			}
			System.out.println("---------");
			//*******
			// ustalenie atrakcyjnosci rekordu na podstawie 
			// wzoru Lacroix Lavency'ego
			for(Rekord record : Rekordy){
				double d = rozwiaz.koniunkcja(
						record.TrafKon, rozwiaz.implikacja( max[record.nr], record.TrafPoz));
				record.setSatysfakcja(d);
				dSum += d;
			}
			System.out.println(dSum);
			Collections.sort(Rekordy);
			//			***			***			***
			
			int ile = Math.min(Rekordy.size(), 50);
			Rekord[] tab = new Rekord[ile];
			int k = Rekordy.size()-1;
			for(int i = 0; i < tab.length; i++){
				tab[i] = Rekordy.get(k);
				k--;
			}
			return tab;
		} else { 
			Rekord[] rekordy = new Rekord[1];
			rekordy[0] = new Rekord("",0,0,0,0);
			return rekordy;
		}
	}//posortuj
	
	
}// E N D
