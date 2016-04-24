package Menu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Autre.Jeu;
import Elements.Personages.Guerrier;
import Elements.Personages.Piegeur;
import Ile.Ile;;

public class EquipePanel  extends JPanel{

	private ArrayList <JPanel> pan;
	private ArrayList <JButton> dep;
	private ArrayList <JButton> act;
	private JButton fdt;
	private int i;
	private int j;
	private int k;
	private boolean equipement;

	public EquipePanel(JFrame f, Jeu jeu , int e, Ile ile){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pan=new ArrayList <JPanel>();
		dep=new ArrayList <JButton>();
		act=new ArrayList <JButton>();
		j=0;
		k=0;
		for (i=0; i<(ile.getlistperso().size()); i++){
			if(ile.getlistperso().get(i).getEquipe()==e){
				pan.add(new JPanel());
				pan.get(j).setLayout(new GridLayout(1, 9));
				pan.get(j).add(new JLabel(ile.getlistperso().get(i).getnom()));
				if(ile.getlistperso().get(i).getVie()){
					pan.get(j).add(new JLabel("Energie= "+ile.getlistperso().get(i).getEnergie()));
					pan.get(j).add(new JLabel("Inventaire: "));
					equipement=false;
					if(ile.getlistperso().get(i).isaClef()){
						pan.get(j).add(new JLabel("Clef"));
						equipement=true;
					}
					if(ile.getlistperso().get(i).isaTresor()){
						pan.get(j).add(new JLabel("Tresor"));
						equipement=true;
					}
					if(ile.getlistperso().get(i) instanceof Guerrier && ile.getlistperso().get(i).isaArme()){
						pan.get(j).add(new JLabel("Epee"));
						equipement=true;
					}
					if(ile.getlistperso().get(i) instanceof Piegeur && ile.getlistperso().get(i).getNbMine()>0){
						pan.get(j).add(new JLabel("Mine: "+ ile.getlistperso().get(i).getNbMine()));
						equipement=true;
					}
					if (!equipement){
						pan.get(j).add(new JLabel(""));
					}
					dep.add(new JButton("Deplacement"));
					new ActionListenerDeplacement(dep.get(k), i, ile, jeu);
					pan.get(j).add(dep.get(k));
					act.add(new JButton("Action"));
					new ActionListenerAction(act.get(k), i, ile, jeu);
					pan.get(j).add(act.get(k));
					k++;
				}else{
					pan.get(j).add(new JLabel("MORT"));
				}
				this.add(pan.get(j));
				j++;
			}
		}
		fdt=new JButton("Fin du Tour");
		fdt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				jeu.FinDeTour(ile);
			}
		});
		this.add(fdt);
	}
}
