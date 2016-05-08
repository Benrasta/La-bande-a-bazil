package Menu;

import java.awt.Dimension;
import java.awt.FlowLayout;
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
import Elements.Personages.Personnage;

/**
 * classe affichant le panneau d'equipe sur le coter
 * @author Gaby
 *
 */
public class Equipe extends JPanel{


	private static final long serialVersionUID = 1L;
	private JFrame f;
	private int equipe;
	private Jeu jeu;

	/**
	 * Constructeur qui ajouter un EquipePanel
	 * 
	 * @param e
	 * @param jeu
	 */
	public Equipe(int e, Jeu jeu){
		equipe=e;
		this.jeu=jeu;
		f = new JFrame("Equipe "+ (e));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((int)((dim.width-f.getSize().width)/2.5), (dim.height-(dim.height+f.getSize().height)));
		EquipePanel();
		f.getContentPane().add(this);
	}

	/**
	 * affiche le panneau
	 */
	public void affichage(){
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	/**
	 * rempli le panneau avec tout les information necessaire
	 * nom du personnage, position, energie, inventaire 
	 * et un bouton pour ce deplacer ainsi que un pour agir
	 */
	public void EquipePanel(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		ArrayList<JPanel> pan=new ArrayList <JPanel>();
		ArrayList<JButton>dep=new ArrayList <JButton>();
		ArrayList<JButton>act=new ArrayList <JButton>();
		int j=0;
		int k=0;
		int cpt=0;
		for (Personnage i: jeu.getIle().getlistperso()){
			if(i.getEquipe()==equipe){
				pan.add(new JPanel());
				pan.get(j).setLayout(new GridLayout(1, 12));


				pan.get(j).add(new JLabel(i.getnom()));
				if(i.getVie()){
					pan.get(j).add(new JLabel("x: "+i.getP().getX()+" y: "+i.getP().getY()));
					pan.get(j).add(new JLabel("Energie= "+i.getEnergie()));
					pan.get(j).add(new JLabel("Inventaire: "));
					if(i.isaClef()){
						pan.get(j).add(new JLabel("Clef"));
					}else if(i.isaTresor()){
						pan.get(j).add(new JLabel("Tresor"));
					}else {
						pan.get(j).add(new JLabel(""));
					}
					if(i.isaArme()){
						pan.get(j).add(new JLabel("Epee"));
					}else {
						pan.get(j).add(new JLabel(""));
					}
					if(i.getNbMine()>0){
						pan.get(j).add(new JLabel("Mine: "+ i.getNbMine()));
					}else {
						pan.get(j).add(new JLabel(""));
					}

					dep.add(new JButton("Deplacer"));
					new ActionListenerDeplacement(dep.get(k), cpt, jeu);
					pan.get(j).add(dep.get(k));
					act.add(new JButton("Agir"));
					new ActionListenerAction(act.get(k), cpt,jeu);
					pan.get(j).add(act.get(k));
					k++;
				}else{
					pan.get(j).add(new JLabel("MORT"));
				}

				this.add(pan.get(j));
				j++;
			}
			cpt++;
		}

		JPanel pane= new JPanel();
		pane.setLayout(new FlowLayout());

		JButton regle= new JButton("Regle");
		regle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Regle();
			}
		});
		pane.add(regle);

		JButton fdt=new JButton("Fin du Tour");
		fdt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				jeu.FinDeTour();
			}
		});
		pane.add(fdt);

		JButton fdj=new JButton("Abandon");
		fdj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				jeu.getIle().FinDeJeu(1+(1-(equipe-1)));
			}
		});
		pane.add(fdj);

		this.add(pane);
	}

}
