package Menu;

import java.awt.Dimension;
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

public class PersoPanel extends JPanel {

	private JPanel pexp;
	private JPanel pvol;
	private JPanel pgue;
	private JPanel ppie;
	private JSpinner exp;
	private JSpinner vol;
	private JSpinner gue;
	private JSpinner pie;
	private JButton ok;
	private Ile laplaya;
	private Jeu jeu;
	private int team;

	public PersoPanel(JFrame f,Ile ile, int eq, Jeu j) {
		super();
		laplaya=ile;
		jeu=j;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pexp = new JPanel();
		pvol = new JPanel();
		pgue = new JPanel();
		ppie = new JPanel();
		pexp.setLayout(new BoxLayout(pexp, BoxLayout.X_AXIS));
		pvol.setLayout(new BoxLayout(pvol, BoxLayout.X_AXIS));
		pgue.setLayout(new BoxLayout(pgue, BoxLayout.X_AXIS));
		ppie.setLayout(new BoxLayout(ppie, BoxLayout.X_AXIS));
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
		pexp.add(lexp);
		pexp.add(exp);
		add(pexp);
		JLabel lvol =new JLabel("Nombre de Voleurs:");
        lvol.setPreferredSize(new Dimension (200,20));
		pvol.add(lvol);
		pvol.add(vol);
		add(pvol);
		JLabel lgue =new JLabel("Nombre de Guerriers:");
        lgue.setPreferredSize(new Dimension (200,20));
		pgue.add(lgue);
		pgue.add(gue);
		add(pgue);
		JLabel lpie =new JLabel("Nombre de Piegeurs:");
        lpie.setPreferredSize(new Dimension (200,20));
		ppie.add(lpie);
		ppie.add(pie);
		add(ppie);
		ok=new JButton("Valider");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				Creationequipe(eq);
				j.Debut(eq,ile);
			}
		});
		
		add(ok);
	}
	
	public Equipe Creationequipe(int eq){
		for(int i=0; i<(int) exp.getValue();i++){
			laplaya.getlistperso().add(new Explorateur(eq, 100, laplaya.getlistbateau().get(eq-1).getP()));
		}
		
		for(int i=0; i<(int) vol.getValue();i++){
			laplaya.getlistperso().add(new Voleur(eq, 100, laplaya.getlistbateau().get(eq-1).getP()));
		}
		
		for(int i=0; i<(int) gue.getValue();i++){
			laplaya.getlistperso().add(new Guerrier(eq, 100, laplaya.getlistbateau().get(eq-1).getP()));
		}
		
		for(int i=0; i<(int) pie.getValue();i++){
			laplaya.getlistperso().add(new Piegeur(eq, 100, laplaya.getlistbateau().get(eq-1).getP()));
		}
		return new Equipe(eq, jeu, laplaya);

	}
}
