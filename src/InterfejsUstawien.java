import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class InterfejsUstawien extends JPanel implements ActionListener {

	private static final long serialVersionUID = -5953169939763973087L;
	private Cecha cecha;
	private JTextField textbd = new JTextField(5);
	private JTextField textd = new JTextField(5);
	private JTextField textm = new JTextField(5);
	private JTextField textbm = new JTextField(5);
	private JLabel labbd = new JLabel("Bardzo du¿o");
	private JLabel labd = new JLabel("Du¿o");
	private JLabel labs = new JLabel("Œrednio");
	private JLabel labm = new JLabel("Ma³o");
	private JLabel labbm = new JLabel("Bardzo ma³o");
	private JButton zapisz = new JButton("Zastosuj");
	private JLabel problem = new JLabel(" ");
	private Wykres wykres;
	private int max;
	private int bd;
	private int d;
	private int m;
	private int bm;
	private int min;
	private int[] tab;
	
	private class Wykres extends Canvas{

		private static final long serialVersionUID = -6984996551991422216L;
		public Wykres(){
			setPreferredSize(new Dimension(460,120));
			setBackground(Color.white);
		}
		public void paint(Graphics g){
			//Graphics2D g2 = (Graphics2D) g;
			if(max < 900){
				g.setColor(Color.blue);
				g.drawLine(min, 10, bm*3, 10);
				g.drawLine(bm*3, 10, m*3, 110);
				g.setColor(Color.green);
				g.drawLine(min, 110, bm*3, 10);
				g.drawLine(bm*3, 10, m*3, 10);
				g.drawLine(m*3, 10, d*3, 110);
				g.setColor(Color.yellow);
				g.drawLine(bm*3, 110, m*3, 10);
				g.drawLine(m*3, 10, d*3, 10);
				g.drawLine(d*3, 10, bd*3, 110);
				g.setColor(Color.orange);
				g.drawLine(m*3, 110, d*3, 10);
				g.drawLine(d*3, 10, bd*3, 10);
				g.drawLine(bd*3, 10, max*3, 110);
				g.setColor(Color.red);
				g.drawLine(d*3, 110, bd*3, 10);
				g.drawLine(bd*3, 10, max*3, 10);
			} else {
				g.setColor(Color.blue);
				g.drawLine(min, 10, bm/2, 10);
				g.drawLine(bm/2, 10, m/2, 110);
				g.setColor(Color.green);
				g.drawLine(min, 110, bm/2, 10);
				g.drawLine(bm/2, 10, m/2, 10);
				g.drawLine(m/2, 10, d/2, 110);
				g.setColor(Color.yellow);
				g.drawLine(bm/2, 110, m/2, 10);
				g.drawLine(m/2, 10, d/2, 10);
				g.drawLine(d/2, 10, bd/2, 110);
				g.setColor(Color.orange);
				g.drawLine(m/2, 110, d/2, 10);
				g.drawLine(d/2, 10, bd/2, 10);
				g.drawLine(bd/2, 10, max/2, 110);
				g.setColor(Color.red);
				g.drawLine(d/2, 110, bd/2, 10);
				g.drawLine(bd/2, 10, max/2, 10);
			}
		}	 
	}
	
	public InterfejsUstawien(Cecha cecha){
		this.cecha = cecha;
		tab = cecha.getPrzedzialy();
		przywroc();
		zapisz.addActionListener(this);
		wykres = new Wykres();
		setLayout(new GridBagLayout());
		rozmiesc();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		bd = Integer.valueOf(textbd.getText());
		d = Integer.valueOf(textd.getText());
		m = Integer.valueOf(textm.getText());
		bm = Integer.valueOf(textbm.getText());
		if(!cecha.ustaw(bd, d, m, bm)) {
			problem.setText(
				"Podane wartosci zostaly uznane za niepoprawne");
				przywroc();
				wykres.repaint();
		} else { 
			problem.setText(
				"Ustawiono nowe przedzialy"); 
			tab = cecha.getPrzedzialy();
			przywroc();
			wykres.repaint();
		}
	}
	
	private void przywroc(){
		max = tab[0];
		bd = tab[1];
		d = tab[2];
		m = tab[3];
		bm = tab[4];
		min = tab[5];
		textbd.setText(String.valueOf(bd));
		textd.setText(String.valueOf(d));
		textm.setText(String.valueOf(m));
		textbm.setText(String.valueOf(bm));
	}

	private void rozmiesc(){
		GridBagConstraints c= new GridBagConstraints();
		c.insets=new Insets(10,10,10,10);
		c.gridx=0;
		c.gridy=0;
		add(labbd,c);
		c.gridx=1;
		c.gridy=0;
		add(textbd,c);
		c.gridx=2;
		c.gridy=0;
		add(labd,c);
		c.gridx=3;
		c.gridy=0;
		add(textd,c);
		c.gridx=4;
		c.gridy=0;
		add(labs,c);
		c.gridx=5;
		c.gridy=0;
		add(textm,c);
		c.gridx=6;
		c.gridy=0;
		add(labm,c);
		c.gridx=7;
		c.gridy=0;
		add(textbm,c);
		c.gridx=8;
		c.gridy=0;
		add(labbm,c);
		c.gridx=6;
		c.gridy=1;
		add(zapisz,c);
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridx=0;
		c.gridy=2;
		add(problem,c);
		c.gridx=0;
		c.gridy=3;
/*		add(wykres,c);
		wykres.repaint();*/
	}
}
