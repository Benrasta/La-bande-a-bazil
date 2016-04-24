package Menu;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Autre.Jeu;
import Ile.Ile;

public class CreaEquipe {

	private JFrame f;
	private PersoPanel pp;

	public CreaEquipe(int equipe, Ile ile , Jeu j){
		f = new JFrame("Création d'équipe " + equipe);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		if (equipe ==1){
		f.setLocation((dim.width-f.getSize().width)/8, (dim.height-f.getSize().height)/8);
		}else{
			f.setLocation((int)((dim.width-f.getSize().width)/1.5), (dim.height-f.getSize().height)/8);
		}
		pp = new PersoPanel(f,ile, equipe, j);
		f.getContentPane().add(pp);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
