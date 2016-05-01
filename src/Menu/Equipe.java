package Menu;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
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

public class Equipe extends JPanel{
	
	private JFrame f;
	private int e;
	private Jeu jeu;
	private int cpt;
	
	public Equipe(int e, Jeu jeu){
		this.e=e;
		this.jeu=jeu;
		f = new JFrame("Equipe "+ (e));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((int)((dim.width-f.getSize().width)/2), (dim.height-(dim.height+f.getSize().height)));
		EquipePanel();
		f.getContentPane().add(this);
	}
	
	public void affichage(){
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public void EquipePanel(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		ArrayList<JPanel> pan=new ArrayList <JPanel>();
		ArrayList<JButton>dep=new ArrayList <JButton>();
		ArrayList<JButton>act=new ArrayList <JButton>();
		int j=0;
		int k=0;
		boolean equipement;
		for (int i=0; i<(jeu.getIle().getlistperso().size()); i++){
			if(jeu.getIle().getlistperso().get(i).getEquipe()==e){
				pan.add(new JPanel());
				pan.get(j).setLayout(new GridLayout(1, 9));
				pan.get(j).add(new JLabel(jeu.getIle().getlistperso().get(i).getnom()));
				if(jeu.getIle().getlistperso().get(i).getVie()){
					pan.get(j).add(new JLabel("Energie= "+jeu.getIle().getlistperso().get(i).getEnergie()));
					pan.get(j).add(new JLabel("Inventaire: "));
					equipement=false;
					if(jeu.getIle().getlistperso().get(i).isaClef()){
						pan.get(j).add(new JLabel("Clef"));
						equipement=true;
					}
					if(jeu.getIle().getlistperso().get(i).isaTresor()){
						pan.get(j).add(new JLabel("Tresor"));
						equipement=true;
					}
					if(jeu.getIle().getlistperso().get(i) instanceof Guerrier && jeu.getIle().getlistperso().get(i).isaArme()){
						pan.get(j).add(new JLabel("Epee"));
						equipement=true;
					}
					if(jeu.getIle().getlistperso().get(i) instanceof Piegeur && jeu.getIle().getlistperso().get(i).getNbMine()>0){
						pan.get(j).add(new JLabel("Mine: "+ jeu.getIle().getlistperso().get(i).getNbMine()));
						equipement=true;
					}
					if (!equipement){
						pan.get(j).add(new JLabel(""));
					}
					dep.add(new JButton("Deplacement"));
					ActionListenerDeplacement(dep.get(k), i);
					pan.get(j).add(dep.get(k));
					act.add(new JButton("Action"));
					ActionListenerAction(act.get(k), i);
					pan.get(j).add(act.get(k));
					k++;
				}else{
					pan.get(j).add(new JLabel("MORT"));
				}
				this.add(pan.get(j));
				j++;
			}
		}
		JButton fdt=new JButton("Fin du Tour");
		fdt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				jeu.FinDeTour();
			}
		});
		this.add(fdt);
	}
	
	public void ActionListenerAction(JButton j, int i ){
		cpt=i;
		j.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jeu.Action(jeu.getIle().getlistperso().get(cpt));
			}
		});
	}
	
	public void ActionListenerDeplacement(JButton j, int i){
		cpt=i;
		j.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jeu.Deplacement(jeu.getIle().getlistperso().get(cpt));
			}
		});
	}

}
