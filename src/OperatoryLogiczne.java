
public class OperatoryLogiczne {
	
	protected int sposob;
	
	public double koniunkcja(double x, double y){
		switch(sposob){
		case 1: return Math.max(0d, x + y - 1d); //t - norma
		default: return Math.min(x, y); //minimum
		}
	}
	
	public double alternatywa(double x, double y){
		switch(sposob){
		case 1: return Math.min(1d, x + y); // t - konorma
		default: return Math.max(x, y); // maksimum
		}
	}
	
	public double implikacja(double x, double y){
		switch(sposob){
		case 1: return Math.min(1d - x + y, 1d); // Lukasiewicz
		default: return Math.max(1d - x, Math.min(x,y)); // Zadeh
		}
	}
	
	public void ustalSposob(int i){
		sposob = i;
	}
}
