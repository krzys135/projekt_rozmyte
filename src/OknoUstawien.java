import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;


public class OknoUstawien extends JFrame implements WindowListener{

	private static final long serialVersionUID = 8458488254001375784L;
	//private Okno przodek;

	public OknoUstawien(Cecha cecha){
		addWindowListener(this);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(700,500);
		setTitle("Ustawienia funkcji przynalezosci");
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}catch(Exception E){System.out.println(
				"wyst¹pi³ wyj¹tek mened¿era wra¿enia i wygl¹du");}
		setContentPane(new InterfejsUstawien(cecha));
		setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowClosed(WindowEvent arg0) {}

	@Override
	public void windowClosing(WindowEvent arg0) {
		//przodek.setEnabled(true);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {}

	@Override
	public void windowDeiconified(WindowEvent arg0) {}

	@Override
	public void windowIconified(WindowEvent arg0) {}

	@Override
	public void windowOpened(WindowEvent arg0) {}
}
