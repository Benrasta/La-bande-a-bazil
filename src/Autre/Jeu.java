package Autre;

import java.util.ArrayList;

import java.util.Scanner;

import javax.swing.JOptionPane;

import Actions.Deplacement;
import Elements.Personages.Personnage;
import Ile.Ile;
import Menu.CreaEquipe;
import Menu.Equipe;

/**
 * classe permettant la jonction entre les autres
 * @author Gaby
 *
 */
public class Jeu {
	private Ile ile;
	private int equipe=0;
	private boolean vie;
	private ArrayList<Boolean> equi;
	private ArrayList<IA> ia;
	private static Scanner sc;

	/**
	 * Constructeur vide
	 */
	public Jeu (){}
	
	/**
	 * Constructeur avec une ile
	 * 
	 * @param ile
	 */
	public Jeu(Ile ile){this.ile=ile;}
	
	/**
	 * Lance l'initialisation de l'ile, e taille dim et avec obs% d'obstacles
	 * 
	 * @param dim
	 * @param obs
	 */
	public void CreaIle(int dim, int obs){
		//initialisation de la l'ile
		ile= new Ile(dim,dim);
		ile.initialized(obs);			
	}

	/**
	 * Lance le jeu avec deux equipe humaine avec un plateau de taille dim et de obs% d'obstacle et une equipe de nbp personnages
	 * 
	 * @param dim
	 * @param obs
	 * @param nbp
	 */
	public void LancementHVH(int dim, int obs, int nbp ){
		//perso de chaque equipe
		CreaIle(dim, obs);
		equi=new ArrayList<Boolean>();
		equi.add(true);
		equi.add(true);
		new CreaEquipe(1,this, nbp);
	}

	/**
	 * Lance le jeu avec une equipe humaine et une IA avec un plateau de taille dim et de obs% d'obstacle et une equipe de nbp personnages
	 * 
	 * @param dim
	 * @param obs
	 * @param nbp
	 */
	public void LancementHVI(int dim, int obs, int nbp){
		//perso de chaque equipe
		CreaIle(dim, obs);
		equi=new ArrayList<Boolean>();
		ia=new ArrayList<IA>();
		equi.add(false);
		equi.add(true);
		ia.add(new IA(1, nbp,this));
		new CreaEquipe(2,this,nbp);
	}

	/**
	 * Lance le jeu avec deux IA avec un plateau de taille dim et de obs% d'obstacle et une equipe de nbp personnages
	 * 
	 * @param dim
	 * @param obs
	 * @param nbp
	 */
	public void LancementIVI(int dim, int obs, int nbp){
		//perso de chaque equipe
		CreaIle(dim, obs);
		equi=new ArrayList<Boolean>();
		ia=new ArrayList<IA>();
		equi.add(false);
		equi.add(false);
		ia.add(new IA( 1, nbp,this));
		ia.add(new IA( 2, nbp,this));
		tour();
	}

	/**
	 * Permet de choisir ou on veut se deplacer
	 * 
	 * @param p
	 */
	public void Deplacement(Personnage p){
		if (p.getaction()){
			System.out.println("x:");
			int x=saisie();
			System.out.println("y:");
			int y=saisie();
			if(x >=0 && y>=0 && x <ile.getCarte().length && y < ile.getCarte().length ){
				new Deplacement(p,ile.getCarte()[x][y],this);
			}
		}else{
			JOptionPane.showMessageDialog(new JOptionPane(), "Vous ne pouvez plus agir avec ce personnage","erreur",JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Permet de choisir ou on veut agir
	 * 
	 * @param p
	 */
	public void Action(Personnage p){
		if (p.getaction()){
			System.out.println("x:");
			int x=saisie();
			System.out.println("y:");
			int y=saisie();
			if(x >=0 && y>=0 && x <ile.getCarte().length && y < ile.getCarte().length ){
				p.Agit(ile.getCarte()[x][y],ile);
			}
			ile.affichage(equipe+1, this);
		}else{
			JOptionPane.showMessageDialog(new JOptionPane(), "Vous ne pouvez plus agir avec ce personnage","erreur",JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Termine le tour et lance un nouveau
	 */
	public void FinDeTour(){
		if (equi.get(1)){
			ile.affichagebrouillard();
		}
			JOptionPane.showMessageDialog(new JOptionPane(), "Au Tour du prochain joueur",null,JOptionPane.INFORMATION_MESSAGE);
		for (int i=0; i<ile.getlistperso().size(); i++){
			if(!ile.getlistperso().get(i).getVie()){
				ile.getlistperso().remove(i);
			}
		}
		equipe=1-equipe;
		tour();
	}

	/**
	 * joue un nouveau tour
	 */
	public void tour(){
		vie=false;
		for (int i=0; i<ile.getlistperso().size(); i++){
			if (ile.getlistperso().get(i).getEquipe()==equipe+1){
				ile.getlistperso().get(i).setaction(true);
				if (ile.getlistperso().get(i).getP().equals(ile.getlistbateau().get(equipe).getP())){
					ile.getlistperso().get(i).setEnergie(ile.getlistperso().get(i).getEnergie()+10);
				}
				if(ile.getlistperso().get(i).gettour()!=0){
					ile.getlistperso().get(i).setaction(false);
					ile.getlistperso().get(i).settour();
					int j=0;
					while(!ile.getlistperso().get(i).getP().equals(ile.getlistmine().get(j).getPmine())){
						j++;
					}
					if (ile.getlistmine().get(j).getTour()==0){
						ile.getlistmine().get(j).getPmine().setEstMine(false);
					}else{
						ile.getlistmine().get(j).setTour();
					}
				}
			}else if (ile.getlistperso().get(i).getVie()){
				vie=true;
			}
		}
		if(!vie){
			ile.FinDeJeu(equipe+1);
		}else{
			ile.affichage(equipe+1, this);
			if(!equi.get(equipe)){
				ia.get(equipe).tour();
			}else{
				new Equipe(equipe+1, this).affichage();
			}
		}
	}

	/**
	 * @return l'ile
	 */
	public Ile getIle(){
		return ile;
	}

	/**
	 * @return la saisie
	 */
	private static int saisie(){
		sc = new Scanner(System.in);
		int i =0;
		while (sc.hasNextInt()) {
			i = sc.nextInt();
			return i;
		}
		return  i;
	}

	/**
	 * @return l'etat de la deuxieme equipe (humain=true, ia=false)
	 */
	public boolean getHumain(){
		return equi.get(1);
	}

}

