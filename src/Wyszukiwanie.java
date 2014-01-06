import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Wyszukiwanie extends JPanel{
	
	static final long serialVersionUID = 7938059L;
	//private final Interfejs Up;
	private JLabel bialko;
	private JComboBox War1;
	private JComboBox War1_Prior;
	private JCheckBox War1_Ch;
	private JLabel tluszcz;
	private JComboBox War2;
	private JComboBox War2_Prior;
	private JCheckBox War2_Ch;
	private JLabel weglowodany;
	private JComboBox War3;
	private JComboBox War3_Prior;
	private JCheckBox War3_Ch;
	private JLabel kalorie;
	private JComboBox War4;
	private JComboBox War4_Prior;
	private JCheckBox War4_Ch;
	private JLabel sposobLab;
	private JComboBox sposob;
	private JButton Szukaj;
	private JButton ustawieniaBia;
	private JButton ustawieniaTlu;
	private JButton ustawieniaWeg;
	private JButton ustawieniaKca;
	private JComboBox warunekCecha;
	private JLabel warunekL;
	private JCheckBox warW;
	
 	public Wyszukiwanie(final Interfejs Up){
		//lajaut
		setLayout(new GridBagLayout());
		//inicjalizacja komponentów
		//this.Up=Up;
		Szukaj = new JButton("Szukaj");
		Szukaj.setSize(80,30);
		String[] OpcjePrior = {"Po¿¹dany", "Konieczny"};
		String[] OpcjeWar1 = {"Bardzo ma³o", "Ma³o", "Œrednio", "Du¿o", "Bardzo du¿o"};
		String[] OpcjeWar2 = {"Bardzo ma³o", "Ma³o", "Œrednio", "Du¿o", "Bardzo du¿o"};
		String[] OpcjeWar3 = {"Bardzo ma³o", "Ma³o", "Œrednio", "Du¿o", "Bardzo du¿o"};
		String[] OpcjeWar4 = {"Bardzo ma³o", "Ma³o", "Œrednio", "Du¿o", "Bardzo du¿o"};
		String[] OpcjeSposob = {"Lukasiewicz", "Zadeh&MinMax"};
		String[] OpcjeWarunek = {"Pojemnoœæ baga¿nika", "Spalanie", "Iloœæ drzwi", "Cena"};
		War1_Prior = new JComboBox(OpcjePrior);
		War2_Prior = new JComboBox(OpcjePrior);
		War3_Prior = new JComboBox(OpcjePrior);
		War4_Prior = new JComboBox(OpcjePrior);
		sposob = new JComboBox(OpcjeSposob);
		warunekCecha = new JComboBox(OpcjeWarunek);
		bialko = new JLabel("<html><b>Pojemnoœæ baga¿nika</b></html>"); 
		tluszcz = new JLabel("<html><b>Spalanie</b></html>");
		weglowodany = new JLabel("<html><b>Iloœæ drzwi</b></html>"); 
		kalorie = new JLabel("<html><b>Cena</b></html>");
		sposobLab = new JLabel("<html><b>Sposób obliczania</b></html>");
		warunekL = new JLabel("<html><b>Zapytanie warunkowe</b></html>");
		War1 = new JComboBox(OpcjeWar1);
		War2 = new JComboBox(OpcjeWar2);
		War3 = new JComboBox(OpcjeWar3);
		War4 = new JComboBox(OpcjeWar4);
		War1_Ch = new JCheckBox();
		War2_Ch = new JCheckBox();
		War3_Ch = new JCheckBox();
		War4_Ch = new JCheckBox();
		warW = new JCheckBox();
/*		ustawieniaBia = new JButton("Ustawienia");
		ustawieniaBia.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new OknoUstawien(new PojemnoscBagaznika(1));
			}
		});
		ustawieniaTlu = new JButton("Ustawienia");
		ustawieniaTlu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new OknoUstawien(new Spalanie(1));
			}
		});
		ustawieniaWeg = new JButton("Ustawienia");
		ustawieniaWeg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new OknoUstawien(new IloscDrzwi(1));
			}
		});
		ustawieniaKca = new JButton("Ustawienia");
		ustawieniaKca.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new OknoUstawien(new Cena(1));
			}
		});*/
		War1.setEnabled(false);
		War2.setEnabled(false);
		War3.setEnabled(false);
		War4.setEnabled(false);
		warunekCecha.setEnabled(false);
		War1_Prior.setEnabled(false);
		War2_Prior.setEnabled(false);
		War3_Prior.setEnabled(false);
		War4_Prior.setEnabled(false);
		//listenery
		War1_Ch.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie){
				Object source = ie.getItemSelectable();
				if (source == War1_Ch){
					if (ie.getStateChange() == ItemEvent.DESELECTED){
						War1.setEnabled(false);
						War1_Prior.setEnabled(false);
					} else {
						War1.setEnabled(true);
						War1_Prior.setEnabled(true);
					}
				} else if (source == War2_Ch){
					if (ie.getStateChange() == ItemEvent.DESELECTED){
						War2.setEnabled(false);
						War2_Prior.setEnabled(false);
					} else {
						War2.setEnabled(true);
						War2_Prior.setEnabled(true);
					}
				} else if (source == War3_Ch){
					if (ie.getStateChange() == ItemEvent.DESELECTED){
						War3.setEnabled(false);
						War3_Prior.setEnabled(false);
					} else {
						War3.setEnabled(true);
						War3_Prior.setEnabled(true);
					}
				} else if (source == War4_Ch){
					if (ie.getStateChange() == ItemEvent.DESELECTED){
						War4.setEnabled(false);
						War4_Prior.setEnabled(false);
					} else {
						War4.setEnabled(true);
						War4_Prior.setEnabled(true);
					}
				}
			}
		});
		War2_Ch.addItemListener(War1_Ch.getItemListeners()[0]);
		War3_Ch.addItemListener(War1_Ch.getItemListeners()[0]);
		War4_Ch.addItemListener(War1_Ch.getItemListeners()[0]);
		warW.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie){
				if (ie.getStateChange() == ItemEvent.DESELECTED){
					warunekCecha.setEnabled(false);
				} else {
					warunekCecha.setEnabled(true);
				}
			}
		});
		Szukaj.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				Up.zapytania.Konieczne.clear();
				Up.zapytania.Pozadane.clear();
				String zapytaj = 
					"select Nazwa, Pojemnosc_bagaznika, Spalanie, Ilosc_drzwi, Cena from tabela where 1 ";
				String opcja;
				if(War1.isEnabled()){
					opcja=(String) War1.getSelectedItem();
					if(opcja.equals("Bardzo ma³o")){
						if(War1_Prior.getSelectedIndex()==1) { 
							Up.zapytania.Konieczne.add(new PojemnoscBagaznika(1));
							zapytaj = zapytaj + 
							"and Pojemnosc_bagaznika < " + String.valueOf(PojemnoscBagaznika.m) + " ";
						} else {
							Up.zapytania.Pozadane.add(new PojemnoscBagaznika(1));
						}
					} else if(opcja.equals("Ma³o")){
						if(War1_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new PojemnoscBagaznika(2));
							zapytaj = zapytaj + 
							"and Pojemnosc_bagaznika < " + String.valueOf(PojemnoscBagaznika.d) + " ";
						} else {
							Up.zapytania.Pozadane.add(new PojemnoscBagaznika(2));
						}
					} else if(opcja.equals("Œrednio")){
						if(War1_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new PojemnoscBagaznika(3));
							zapytaj = zapytaj + 
							"and Pojemnosc_bagaznika < " + String.valueOf(PojemnoscBagaznika.bd) + " ";
							zapytaj = zapytaj + 
							"and Pojemnosc_bagaznika > " + String.valueOf(PojemnoscBagaznika.bm) + " ";
						} else {
							Up.zapytania.Pozadane.add(new PojemnoscBagaznika(3));
						}
					} else if(opcja.equals("Du¿o")){
						if(War1_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new PojemnoscBagaznika(4));
							zapytaj = zapytaj + 
							"and Pojemnosc_bagaznika > " + String.valueOf(PojemnoscBagaznika.m) + " ";
						} else {
							Up.zapytania.Pozadane.add(new PojemnoscBagaznika(4));
						}
					} else if(opcja.equals("Bardzo du¿o")){
						if(War1_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new PojemnoscBagaznika(5));
							zapytaj = zapytaj + 
							"and Pojemnosc_bagaznika > " + String.valueOf(PojemnoscBagaznika.d) + " ";
						} else {
							Up.zapytania.Pozadane.add(new PojemnoscBagaznika(5));
						}
					}
				}//war1
				if(War2.isEnabled()){
					opcja=(String) War2.getSelectedItem();
					if(opcja.equals("Bardzo ma³o")){
						if(War2_Prior.getSelectedIndex()==1) {
							Up.zapytania.Konieczne.add(new Spalanie(1));
							zapytaj = zapytaj + 
							"and Spalanie < " + String.valueOf(Spalanie.m) + " ";
						} else {
							Up.zapytania.Pozadane.add(new Spalanie(1));
						}
					} else if(opcja.equals("Ma³o")){
						if(War2_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new Spalanie(2));
							zapytaj = zapytaj + 
							"and Spalanie < " + String.valueOf(Spalanie.d) + " ";
						} else {
							Up.zapytania.Pozadane.add(new Spalanie(2));
						}
					} else if(opcja.equals("Œrednio")){
						if(War2_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new Spalanie(3));
							zapytaj = zapytaj + 
							"and Spalanie < " + String.valueOf(Spalanie.bd) + " " +
							"and Spalanie > " + String.valueOf(Spalanie.bm) + " ";
						} else {
							Up.zapytania.Pozadane.add(new Spalanie(3));
						}
					} else if(opcja.equals("Du¿o")){
						if(War2_Prior.getSelectedIndex()==1){
							zapytaj = zapytaj + 
							"and Spalanie > " + String.valueOf(Spalanie.m) + " ";
							Up.zapytania.Konieczne.add(new Spalanie(4));
						} else {
							Up.zapytania.Pozadane.add(new Spalanie(4));
						}
					} else if(opcja.equals("Bardzo du¿o")){
						if(War2_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new Spalanie(5));
							zapytaj = zapytaj + 
							"and Spalanie > " + String.valueOf(Spalanie.d) + " ";
						} else {
							Up.zapytania.Pozadane.add(new Spalanie(5));
						}
					}
				}//war2
				if(War3.isEnabled()){
					opcja=(String) War3.getSelectedItem();
					if(opcja.equals("Bardzo ma³o")){
						if(War3_Prior.getSelectedIndex()==1) {
							Up.zapytania.Konieczne.add(new IloscDrzwi(1));
							zapytaj = zapytaj + 
							"and Ilosc_drzwi < " + String.valueOf(IloscDrzwi.m) + " ";
						} else {
							Up.zapytania.Pozadane.add(new IloscDrzwi(1));
						}
					} else if(opcja.equals("Ma³o")){
						if(War3_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new IloscDrzwi(2));
							zapytaj = zapytaj + 
							"and Ilosc_drzwi < " + String.valueOf(IloscDrzwi.d) + " ";
						} else {
							Up.zapytania.Pozadane.add(new IloscDrzwi(2));
						}
					} else if(opcja.equals("Œrednio")){
						if(War3_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new IloscDrzwi(3));
							zapytaj = zapytaj + 
							"and Ilosc_drzwi < " + String.valueOf(IloscDrzwi.bd) + " " +
							"and Ilosc_drzwi > " + String.valueOf(IloscDrzwi.bm) + " ";
						} else {
							Up.zapytania.Pozadane.add(new IloscDrzwi(3));
						}
					} else if(opcja.equals("Du¿o")){
						if(War3_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new IloscDrzwi(4));
							zapytaj = zapytaj + 
							"and Ilosc_drzwi > " + String.valueOf(IloscDrzwi.m) + " ";
						} else {
							Up.zapytania.Pozadane.add(new IloscDrzwi(4));
						}
					} else if(opcja.equals("Bardzo du¿o")){
						if(War3_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new IloscDrzwi(5));
							zapytaj = zapytaj + 
							"and Ilosc_drzwi > " + String.valueOf(IloscDrzwi.d) + " ";
						} else {
							Up.zapytania.Pozadane.add(new IloscDrzwi(5));
						}
					}
				}//war3
				if(War4.isEnabled()){
					opcja=(String) War4.getSelectedItem();
					if(opcja.equals("Bardzo ma³o")){
						if(War4_Prior.getSelectedIndex()==1) {
							Up.zapytania.Konieczne.add(new Cena(1));
							zapytaj = zapytaj + 
							"and Cena < " + String.valueOf(Cena.m) + " ";
						} else {
							Up.zapytania.Pozadane.add(new Cena(1));
						}
					} else if(opcja.equals("Ma³o")){
						if(War4_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new Cena(2));
							zapytaj = zapytaj + 
							"and Cena < " + String.valueOf(Cena.d) + " ";
						} else {
							Up.zapytania.Pozadane.add(new Cena(2));
						}
					} else if(opcja.equals("Œrednio")){
						if(War4_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new Cena(3));
							zapytaj = zapytaj + 
							"and Cena < " + String.valueOf(Cena.bd) + " " +
							"and Cena > " + String.valueOf(Cena.bm) + " ";
						} else {
							Up.zapytania.Pozadane.add(new Cena(3));
						}
					} else if(opcja.equals("Du¿o")){
						if(War4_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new Cena(4));
							zapytaj = zapytaj + 
							"and Cena > " + String.valueOf(Cena.m) + " ";
						} else {
							Up.zapytania.Pozadane.add(new Cena(4));
						}
					} else if(opcja.equals("Bardzo du¿o")){
						if(War4_Prior.getSelectedIndex()==1){
							Up.zapytania.Konieczne.add(new Cena(5));
							zapytaj = zapytaj + 
							"and Cena > " + String.valueOf(Cena.d) + " ";
						} else {
							Up.zapytania.Pozadane.add(new Cena(5));
						}
					}
				}//war4
				
				opcja = (String) sposob.getSelectedItem();
				if(opcja.equals("Lukasiewicz")) Up.zapytania.rozwiaz.ustalSposob(1);
				else if(opcja.equals("Zadeh&MinMax")) Up.zapytania.rozwiaz.ustalSposob(0);
				if(warunekCecha.isEnabled()){
					opcja = (String) warunekCecha.getSelectedItem();
					if(opcja.equals("Pojemnoœæ baga¿nika")) Up.zapytania.warunek = new PojemnoscBagaznika(1);
					else if(opcja.equals("Iloœæ drzwi")) Up.zapytania.warunek = new IloscDrzwi(1);
					else if(opcja.equals("Spalnie")) Up.zapytania.warunek = new Spalanie(1);
					else if(opcja.equals("Cena")) Up.zapytania.warunek = new Cena(1);
				} else Up.zapytania.warunek = null;
				if(Up.zapytania.connected){
					Up.utworzOknoWynikow(Up.zapytania.posortuj(zapytaj));
				} else {
					Up.utworzOknoLaczenia();
				}
			}//akszyn performd
		});
		
		rozmiesc();
		
		setVisible(true);
	} // konstruktor
	
	private void rozmiesc(){
		//rozmieszczenie		Insets(top,left,bottom,right)
		GridBagConstraints c= new GridBagConstraints();
		c.insets=new Insets(20,40,20,40);
		c.gridwidth=GridBagConstraints.REMAINDER;
		JLabel tytul=new JLabel("");
		c.gridx=0;
		c.gridy=0;
		add(tytul,c);
		c.insets=new Insets(20,40,20,40);
		c.gridwidth=1;
		
		c.gridx=1;
		c.gridy=1;
		add(sposobLab,c);
		c.gridx=2;
		c.gridy=1;
		add(sposob,c);
		
		c.gridx=0;
		c.gridy=2;
		add(War1_Ch,c);
		c.gridx=1;
		c.gridy=2;
		add(bialko,c);
		c.gridx=2;
		c.gridy=2;
		add(War1,c);
		c.gridx=3;
		c.gridy=2;
		add(War1_Prior,c);
/*		c.gridx=4;
		c.gridy=1;
		add(ustawieniaBia,c);*/
		//---
		c.gridx=0;
		c.gridy=3;
		add(War2_Ch,c);
		c.gridx=1;
		c.gridy=3;
		add(tluszcz,c);
		c.gridx=2;
		c.gridy=3;
		add(War2,c);
		c.gridx=3;
		c.gridy=3;
		add(War2_Prior,c);
/*		c.gridx=4;
		c.gridy=2;
		add(ustawieniaTlu,c);*/
		//--
		c.gridx=0;
		c.gridy=4;
		add(War3_Ch,c);
		c.gridx=1;
		c.gridy=4;
		add(weglowodany,c);
		c.gridx=2;
		c.gridy=4;
		add(War3,c);
		c.gridx=3;
		c.gridy=4;
		add(War3_Prior,c);
/*		c.gridx=4;
		c.gridy=3;
		add(ustawieniaWeg,c);*/
		//--
		c.gridx=0;
		c.gridy=5;
		add(War4_Ch,c);
		c.gridx=1;
		c.gridy=5;
		add(kalorie,c);
		c.gridx=2;
		c.gridy=5;
		add(War4,c);
		c.gridx=3;
		c.gridy=5;
		add(War4_Prior,c);
/*		c.gridx=4;
		c.gridy=4;
		add(ustawieniaKca,c);*/
		//--
		c.gridx=0;
		c.gridy=6;
		add(warW,c);
		c.gridx=1;
		c.gridy=6;
		add(warunekL,c);
		c.gridx=2;
		c.gridy=6;
		add(warunekCecha,c);
		//--
/*		c.gridx=1;
		c.gridy=6;
		add(sposobLab,c);
		c.gridx=2;
		c.gridy=6;
		add(sposob,c);*/
		c.gridx=1;
		c.gridy=7;
		add(Szukaj,c);
	}
	
}// E N D
