package Menu;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Autre.Jeu;
import Ile.Ile;

public class Equipe extends JPanel {
	
	private JFrame f;
	private EquipePanel p;
	
	public Equipe(int e, Jeu jeu ,Ile ile){
		super();
		f = new JFrame("Equipe "+ (e));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((int)((dim.width-f.getSize().width)/2), (dim.height-(dim.height+f.getSize().height)));
		p=new EquipePanel(f, jeu, e, ile);
		f.getContentPane().add(p);
	}
	
	public void affichage(){
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
