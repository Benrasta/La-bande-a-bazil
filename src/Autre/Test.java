package Autre;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import Elements.Personages.Explorateur;
import Elements.Personages.Guerrier;
import Elements.Personages.Personnage;
import Elements.Personages.Piegeur;
import Elements.Personages.Voleur;
import Ile.Ile;
import Menu.Equipe;

public class Test extends JPanel{

	private static final long serialVersionUID = 1L;
	private Ile ile;
	private Jeu jeu;
	private JButton equipe;
	private JSpinner x,y,energie,classe;
	private int e;

	/**
	 * Constructeur amenant a la création d'équipe et créeant l'ile
	 * 
	 * @param dim
	 * @param obs
	 */
	public Test(int dim, int obs){
		ile= new Ile(dim,dim);
		ile.initialized(obs);
		jeu=new Jeu(ile);
		jeu.setHumain(false);
		ile.affichage(1, jeu);
		JFrame f=new JFrame("Test");
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		bouttonchoix(dim);
		f.getContentPane().add(this);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	/**
	 * permet de choisir quel personnage mettre et où
	 * 
	 * @param dim
	 */
	public void bouttonchoix(int dim){
		JPanel pan=new JPanel();
		pan.setLayout(new FlowLayout());
		pan.setPreferredSize(new Dimension(500,100));
		pan.add(new JLabel("x: "));
		x=new JSpinner(new SpinnerNumberModel(0,0,dim-1,1));
		pan.add(x);
		pan.add(new JLabel("y: "));
		y=new JSpinner(new SpinnerNumberModel(0,0,dim-1,1));
		pan.add(y);
		pan.add(new JLabel("Energie"));
		energie=new JSpinner(new SpinnerNumberModel(100, 0, 300, 10));
		pan.add(energie);
		pan.add(new JLabel("Equipe :"));
		equipe=new JButton("1");
		equipe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				equipe.setText((1-(Integer.parseInt(equipe.getText())-1))+1+"");
			}
		});
		pan.add(equipe);
		classe= new JSpinner(new SpinnerListModel(new String[]{"Explorateur","Voleur","Guerrier","Piegeur"}));
		pan.add(classe);
		JButton ok=new JButton("Placer");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!jeu.getIle().getCarte()[(int)x.getValue()][(int)y.getValue()].getEstElement() && !jeu.getIle().getCarte()[(int)x.getValue()][(int)y.getValue()].getEstPersonnage()){
				if (classe.getValue().equals("Explorateur")){
					jeu.getIle().getlistperso().add(new Explorateur(Integer.parseInt(equipe.getText()), (int)energie.getValue(), jeu.getIle().getCarte()[(int)x.getValue()][(int)y.getValue()]));
				}else if (classe.getValue().equals("Voleur")){
					jeu.getIle().getlistperso().add(new Voleur(Integer.parseInt(equipe.getText()), (int)energie.getValue(), jeu.getIle().getCarte()[(int)x.getValue()][(int)y.getValue()]));
				}else if (classe.getValue().equals("Guerrier")){
					jeu.getIle().getlistperso().add(new Guerrier(Integer.parseInt(equipe.getText()), (int)energie.getValue(), jeu.getIle().getCarte()[(int)x.getValue()][(int)y.getValue()]));
				}else if (classe.getValue().equals("Piegeur")){
					jeu.getIle().getlistperso().add(new Piegeur(Integer.parseInt(equipe.getText()), (int)energie.getValue(), jeu.getIle().getCarte()[(int)x.getValue()][(int)y.getValue()]));
				}
				tour();
			}else{
				JOptionPane.showMessageDialog(new JOptionPane(), "Impossible de crée un personnage la",null, JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		pan.add(ok);
		this.add(pan);
	}
	
	/**
	 * Enchaine les tours
	 */
	public void tour(){
		jeu.getIle().affichage(e+1, jeu);
		for (Personnage p: jeu.getIle().getlistperso()){
			p.setaction(true);
		}
		new Equipe(e+1,jeu).affichage();
	}
}
