import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Wyniki extends JPanel{

	static final long serialVersionUID = 37527564L;
	//private final Interfejs Up;
	private JTable Tab;
	private JScrollPane portTab;
	private JButton wroc;
	
	public Wyniki(final Interfejs Up){
		//this.Up=Up;
		//inicjalizacja tabeli
		setLayout(new GridBagLayout());
		Tab = new JTable(new ModelTabeli());
		Tab.setColumnSelectionAllowed(false);
		Tab.setRowSelectionAllowed(false);
		Tab.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Tab.setRowHeight(30);
		Tab.setShowVerticalLines(false);
		Tab.setGridColor(Color.black);
		Tab.setShowGrid(true);
		//---
		Tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Tab.getColumnModel().getColumn(0).setPreferredWidth(270);
		Tab.getColumnModel().getColumn(1).setPreferredWidth(100);
		Tab.getColumnModel().getColumn(2).setPreferredWidth(100);
		Tab.getColumnModel().getColumn(3).setPreferredWidth(100);
		Tab.getColumnModel().getColumn(4).setPreferredWidth(100);
		Tab.getColumnModel().getColumn(5).setPreferredWidth(100);
		//--- 		//Tab.setPreferredSize(new Dimension(800, 450));
		portTab = new JScrollPane(Tab);
		portTab.setPreferredSize(new Dimension(800, 450));
		wroc=new JButton("Powrót");
		wroc.setSize(80,30);
		wroc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				Up.utworzOknoSzukania();
			}
		});
		GridBagConstraints c= new GridBagConstraints();
		c.insets = new Insets(15,15,15,15);
		c.gridx=0;
		c.gridy=0;
		add(portTab,c);
		c.gridx=0;
		c.gridy=1;
		add(wroc,c);
		setVisible(true);
	}//konstruktor
	
	public void refresh(Rekord[] tab){
		Object[][] cont = new Object[tab.length][6];
		for(int i=0; i<tab.length; i++){
			cont[i][0] = tab[i].nazwa;
			cont[i][1] = tab[i].Bialko;
			cont[i][2] = tab[i].Tluszcz;
			cont[i][3] = tab[i].Wegl;
			cont[i][4] = tab[i].Kcal;
			cont[i][5] = tab[i].Satysfakcja;
		}
		ModelTabeli MTM=(ModelTabeli) Tab.getModel();
		MTM.nowaZawartosc(cont);
		Tab.repaint();
	}
}// E N D
