package Autre;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Actions.Deplacement;
import Elements.Personages.Personage;
import Ile.Ile;
import Menu.CreaEquipe;
import Menu.Equipe;

public class Jeu {
	private Ile ile;
	private int equipe=0;
	private boolean vie;
	private ArrayList<Boolean> equi;
	private ArrayList<IA> ia;
	private static Scanner sc;

	public Jeu (){}
	public Jeu(Ile ile){this.ile=ile;}
	public void CreaIle(int dim, int obs){
		//initialisation de la laplaya	
		ile= new Ile(dim,dim);
		ile.initialized(obs);			
	}

	public void LancementHVH(int dim, int obs, int nbp ){
		//perso de chaque equipe
		CreaIle(dim, obs);
		equi=new ArrayList<Boolean>();
		equi.add(true);
		equi.add(true);
		new CreaEquipe(1,this, nbp);
	}

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

	public void Deplacement(Personage p){
		if (p.getaction()){
			System.out.println("x:");
			int x=saisie();
			System.out.println("y:");
			int y=saisie();
			if(x >=0 && y>=0 && x <ile.getCarte().length && y < ile.getCarte().length ){
				new Deplacement(p, ile.getCarte()[x][y],this);
			}
		}else{
			JOptionPane.showMessageDialog(new JOptionPane(), "Vous ne pouvez plus agir avec ce personnage","erreur",JOptionPane.WARNING_MESSAGE);
		}
	}

	public void Action(Personage p){
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

	public void FinDeTour(){
		if (equi.get(1)){
		ile.affichagebrouillard();
		JOptionPane.showMessageDialog(new JOptionPane(), "Au Tour du prochain joueur",null,JOptionPane.INFORMATION_MESSAGE);
		}
		equipe=1-equipe;
		tour();
	}

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
		if (equipe==1){
			for (int i=0; i<ile.getlistperso().size(); i++){
				if(!ile.getlistperso().get(i).getVie()){
					ile.getlistperso().remove(i);
				}
			}
		}
	}

	public Ile getIle(){
		return ile;
	}

	public static int saisie(){
		sc = new Scanner(System.in);
		int i =0;
		while (sc.hasNextInt()) {
			i = sc.nextInt();
			return i;
		}
		return  i;
	}
	
	public boolean getHumain(){
		return equi.get(1);
	}
	
	// TODO clique de souris ou clavier
}

