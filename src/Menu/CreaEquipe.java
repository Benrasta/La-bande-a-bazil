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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Autre.Jeu;
import Elements.Personages.Explorateur;
import Elements.Personages.Guerrier;
import Elements.Personages.Piegeur;
import Elements.Personages.Voleur;

public class CreaEquipe {

	private JFrame f;
	private int eq;
	private Jeu jeu;
	private int valexp;
	private int valvol;
	private int valgue;
	private int valpie;
	private JSpinner exp;
	private JSpinner vol;
	private JSpinner gue;
	private JSpinner pie;
	private int nbperso;
	private JLabel nbper;

	public CreaEquipe(int equipe, Jeu j, final int nbp){
		eq=equipe;
		jeu=j;
		nbperso=nbp;
		
		f = new JFrame("Création d'équipe " + equipe);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((int)((dim.width-f.getSize().width)/2.5), (dim.height-f.getSize().height)/3);
		
		JPanel p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		PersoPanel(p);
		
		JButton ok=new JButton("Valider");
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				Creationequipe(eq);
				if (eq==1){
					new CreaEquipe(2, jeu, nbp);
				}else{
					jeu.tour();
				}
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
		pp.setLayout(new GridLayout(5,2));
		
		
		JLabel lexp =new JLabel("Nombre d'Explorateurs:");
		lexp.setPreferredSize(new Dimension (200,20));
		pp.add(lexp);
		
		exp = new JSpinner(new SpinnerNumberModel(1, 0, 20, 1));
		valexp=(int) exp.getValue();
		nbperso-=valexp;
		exp.setPreferredSize(new Dimension (150,45));
		exp.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (nbperso+(valexp-(int) exp.getValue()) >= 0){
					nbperso+=(valexp-(int) exp.getValue());
					valexp=(int) exp.getValue();
					nbper.setText(": " +nbperso);
				}else{
					exp.setValue(valexp);
				}
			}
		});
		pp.add(exp);
		
		
		JLabel lvol =new JLabel("Nombre de Voleurs:");
		lvol.setPreferredSize(new Dimension (200,20));
		pp.add(lvol);
		
		vol = new JSpinner(new SpinnerNumberModel(1, 0, 20, 1));
		valvol=(int) vol.getValue();
		nbperso-=valvol;
		vol.setPreferredSize(new Dimension (150,45));
		vol.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (nbperso+(valvol-(int) vol.getValue()) >= 0){
					nbperso+=(valvol-(int) vol.getValue());
					valvol=(int) vol.getValue();
					nbper.setText(": " +nbperso);
				}else{
					vol.setValue(valvol);
				}
			}
		});
		pp.add(vol);
		
		
		JLabel lgue =new JLabel("Nombre de Guerriers:");
		lgue.setPreferredSize(new Dimension (200,20));
		pp.add(lgue);
		
		gue = new JSpinner(new SpinnerNumberModel(1, 0, 20, 1));
		valgue=(int) gue.getValue();
		nbperso-=valgue;
		gue.setPreferredSize(new Dimension (150,45));
		gue.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (nbperso+(valgue-(int) gue.getValue()) >= 0){
					nbperso+=(valgue-(int) gue.getValue());
					valgue=(int) gue.getValue();
					nbper.setText(": " +nbperso);
				}else{
					gue.setValue(valgue);
				}
			}
		});
		pp.add(gue);
		
		
		JLabel lpie =new JLabel("Nombre de Piegeurs:");
		lpie.setPreferredSize(new Dimension (200,20));
		pp.add(lpie);
		
		pie = new JSpinner(new SpinnerNumberModel(1, 0, 20, 1));
		valpie=(int) pie.getValue();
		nbperso-=valpie;
		pie.setPreferredSize(new Dimension (150,45));
		pie.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (nbperso+(valpie-(int) pie.getValue()) >= 0){
					nbperso+=(valpie-(int) pie.getValue());
					valpie=(int) pie.getValue();
					nbper.setText(": " +nbperso);
				}else{
					pie.setValue(valpie);
				}
			}
		});
		pp.add(pie);
		
		JLabel nbp=new JLabel("Nombre de perso disponible");
		nbp.setPreferredSize(new Dimension (200,20));
		pp.add(nbp);
		nbper=new JLabel(": " +nbperso);
		pp.add(nbper);
		
		p.add(pp);		
	}

	public Equipe Creationequipe(int eq){
		for(int i=0; i<(int) exp.getValue();i++){
			jeu.getIle().getlistperso().add(new Explorateur(eq, 100, jeu.getIle().getlistbateau().get(eq-1).getP()));
		}

		for(int i=0; i<(int) vol.getValue();i++){
			jeu.getIle().getlistperso().add(new Voleur(eq, 100, jeu.getIle().getlistbateau().get(eq-1).getP()));
		}

		for(int i=0; i<(int) gue.getValue();i++){
			jeu.getIle().getlistperso().add(new Guerrier(eq, 100, jeu.getIle().getlistbateau().get(eq-1).getP()));
		}

		for(int i=0; i<(int) pie.getValue();i++){
			jeu.getIle().getlistperso().add(new Piegeur(eq, 100, jeu.getIle().getlistbateau().get(eq-1).getP()));
		}
		return new Equipe(eq, jeu);

	}

}
