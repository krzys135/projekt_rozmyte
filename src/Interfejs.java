import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;

public class Interfejs extends JPanel{
	
	static final long serialVersionUID = 17320776L;
	private Wyszukiwanie panelSzukania;
	private Wyniki panelWynikow;
	protected Zapytania zapytania;
	private JButton polacz = new JButton("Po³¹cz");
	private JLabel userl = new JLabel("U¿ytkownik");
	private JLabel passl = new JLabel("Has³o");
	private JLabel adresl = new JLabel("adres");
	private JLabel problem = new JLabel("");
	private JTextField user = new JTextField(25);
	private JPasswordField pass = new JPasswordField(25);
	private JTextField adres = new JTextField(25);
	
	public Interfejs(){
		setLayout(new GridBagLayout());		
		panelSzukania = new Wyszukiwanie(this);
		panelWynikow  = new Wyniki(this);
		zapytania = new Zapytania();		
/*		polacz.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				zapytania.polacz(user.getText(), new String(pass.getPassword()), adres.getText());
				if(zapytania.connected){utworzOknoSzukania();} 
				else { problem.setText("Nie uda³o siê po³¹czyæ z baz¹ danych."); 
						repaint();	}
			}
		});*/
		zapytania.polacz("root", "", "localhost");
		if(zapytania.connected){utworzOknoSzukania();} 
		else { //problem.setText("Nie uda³o siê po³¹czyæ z baz¹ danych."); 
				repaint();	}
		//rozmiesc();		
	}
	
	protected void utworzOknoSzukania(){
		removeAll();
		add(panelSzukania);
		validate();
		repaint();
	}
	
	protected void utworzOknoWynikow(Rekord[] tab){
		removeAll();
		panelWynikow.refresh(tab);
		add(panelWynikow);
		validate();
		repaint();
	}
	
	protected void utworzOknoLaczenia(){
		removeAll();
		rozmiesc();
		validate();
		repaint();	
	}
	
	private void rozmiesc() {		
		GridBagConstraints c= new GridBagConstraints();
		c.insets=new Insets(15,15,15,15);
		c.gridx=0;
		c.gridy=0;
		add(userl,c);
		c.gridx=1;
		c.gridy=0;
		add(user,c);
		c.gridx=0;
		c.gridy=1;
		add(passl,c);
		c.gridx=1;
		c.gridy=1;
		add(pass,c);
		c.gridx=0;
		c.gridy=2;
		add(adresl,c);
		c.gridx=1;
		c.gridy=2;
		add(adres,c);
		c.gridx=1;
		c.gridy=3;
		add(polacz,c);
		c.gridx=0;
		c.gridy=4;
		add(problem,c);
	}
	
}// E N D
