package Menu;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Autre.Jeu;
import Elements.Personages.Explorateur;
import Elements.Personages.Guerrier;
import Elements.Personages.Piegeur;
import Elements.Personages.Voleur;
import Ile.Ile;

public class CreaEquipe {

	private JFrame f;
	private int eq;
	private Ile ile;
	private Jeu j;
	private JSpinner exp;
	private JSpinner vol;
	private JSpinner gue;
	private JSpinner pie;

	public CreaEquipe(int equipe, Ile ile , Jeu j){
		eq=equipe;
		this.ile=ile;
		this.j=j;
		f = new JFrame("Création d'équipe " + equipe);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		if (equipe ==1){
		f.setLocation((dim.width-f.getSize().width)/8, (dim.height-f.getSize().height)/8);
		}else{
			f.setLocation((int)((dim.width-f.getSize().width)/1.5), (dim.height-f.getSize().height)/8);
		}
		JPanel p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		PersoPanel(p);
		JButton ok=new JButton("Valider");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				Creationequipe(eq);
				j.Debut(eq,ile);
			}
		});
		p.add(new JPanel().add(ok));
		f.getContentPane().add(p);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public void PersoPanel(JPanel p) {
		JPanel pp=new JPanel();
		pp.setLayout(new GridLayout(4,2));
		exp = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
		vol = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));
		gue = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));
		pie = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));
		exp.setPreferredSize(new Dimension (150,45));
        vol.setPreferredSize(new Dimension (150,45));
        gue.setPreferredSize(new Dimension (150,45));
        pie.setPreferredSize(new Dimension (150,45));
        JLabel lexp =new JLabel("Nombre d'Explorateurs:");
        lexp.setPreferredSize(new Dimension (200,20));
		pp.add(lexp);
		pp.add(exp);
		JLabel lvol =new JLabel("Nombre de Voleurs:");
        lvol.setPreferredSize(new Dimension (200,20));
		pp.add(lvol);
		pp.add(vol);
		JLabel lgue =new JLabel("Nombre de Guerriers:");
        lgue.setPreferredSize(new Dimension (200,20));
		pp.add(lgue);
		pp.add(gue);
		JLabel lpie =new JLabel("Nombre de Piegeurs:");
        lpie.setPreferredSize(new Dimension (200,20));
		pp.add(lpie);
		pp.add(pie);
		p.add(pp);
	}
	
	public Equipe Creationequipe(int eq){
		for(int i=0; i<(int) exp.getValue();i++){
			ile.getlistperso().add(new Explorateur(eq, 100, ile.getlistbateau().get(eq-1).getP()));
		}
		
		for(int i=0; i<(int) vol.getValue();i++){
			ile.getlistperso().add(new Voleur(eq, 100, ile.getlistbateau().get(eq-1).getP()));
		}
		
		for(int i=0; i<(int) gue.getValue();i++){
			ile.getlistperso().add(new Guerrier(eq, 100, ile.getlistbateau().get(eq-1).getP()));
		}
		
		for(int i=0; i<(int) pie.getValue();i++){
			ile.getlistperso().add(new Piegeur(eq, 100, ile.getlistbateau().get(eq-1).getP()));
		}
		return new Equipe(eq, j, ile);

	}

}
