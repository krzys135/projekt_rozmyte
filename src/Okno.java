import javax.swing.*;
public class Okno extends JFrame{

	static final long serialVersionUID = 36775493L;

	public Okno(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850, 600);
		setTitle("Projekt ERKdBD");
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}catch(Exception E){System.out.println(
				"wyst�pi� wyj�tek mened�era wra�enia i wygl�du");}
		setContentPane(new Interfejs());
		setVisible(true);
	}
}
