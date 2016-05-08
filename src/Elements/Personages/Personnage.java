package Elements.Personages;
import javax.swing.JOptionPane;

import Ile.Ile;
import Ile.Parcelle;

public abstract class Personnage {
	private boolean aArme;
	private boolean aClef;
	private boolean aTresor;
	private int nbMine;
	private int equipe;
	private int energie;
	private Parcelle p;
	private boolean action;
	private int tour;
	private boolean vie;

	/**
	 * Constructeur d'un personnage sur la parcelle p,d'equipe et avec energie
	 * 
	 * @param equipe
	 * @param energie
	 * @param p
	 */
	public Personnage(int equipe,int energie,Parcelle p){
		this.equipe=equipe;
		this.energie=energie;
		this.p=p;
		vie=true;	
	}

	/**
	 * Permet de s'echanger entre personnages
	 * 
	 * @param cible
	 * @param jeu
	 */
	public void echange(Parcelle cible, Ile ile){
		int i=0;
		while(cible != ile.getlistperso().get(i).getP()){
			i++;
		}
		if(equipe == ile.getlistperso().get(i).getEquipe()) {
			String[] stuff= new String [4];
			int cpt=0;
			if(aArme){
				stuff[cpt]="Arme";
				cpt++;
			}
			if(aClef){
				stuff[cpt]="Clef";
				cpt++;
			}
			if(aTresor){
				stuff[cpt]="Tresor";
				cpt++;
			}
			if(nbMine>0){
				stuff[cpt]="Mines";
				cpt++;
			}
			if (cpt>0){ 
				String reponse =(String)JOptionPane.showInputDialog(new JOptionPane(),"Que voulez nous echanger","Echange",JOptionPane.INFORMATION_MESSAGE,null,stuff,stuff[0]);
				setaction(false);
				if(reponse.equals("Mines")){
					int rep= Integer.parseInt((String)JOptionPane.showInputDialog(new JOptionPane(),"Combien de Mine voulez vous donner?\n"+"Vous en avez "+ nbMine, JOptionPane.INFORMATION_MESSAGE));
					nbMine-=rep;
					ile.getlistperso().get(i).setNbMine(ile.getlistperso().get(i).getNbMine()+rep);
				}else if(reponse.equals("Tresor")){
					aTresor=false;
					ile.getlistperso().get(i).setaTresor(true);
				}else if(reponse.equals("Clef")){
					aClef=false;
					ile.getlistperso().get(i).setaClef(true);
				}else if(reponse.equals("Arme")){
					aArme=false;
					ile.getlistperso().get(i).setaArme(true);
				}
			}else{
				JOptionPane.showMessageDialog(new JOptionPane(),"Vous n'avez aucun objet sur vous",null,JOptionPane.ERROR_MESSAGE);
			}
		}
	}




	/**
	 * @return l'equipe
	 */
	public int getEquipe() {
		return equipe;
	}

	/**
	 * @return l'energie
	 */
	public int getEnergie() {
		return energie;
	}

	/**
	 * change l'ancienne energie par la nouvelle, bloquant entre 100  et 0
	 * 
	 * @param energie
	 */
	public void setEnergie(int energie) {
		if (energie>100){
			energie=100;
		}
		if (energie<0){
			energie=0;
		}
		this.energie = energie;
		System.out.println(this.getnom()+" : "+this.energie+" energies.");
	}

	/**
	 * @return la parcelle
	 */
	public Parcelle getP() {
		return p;
	}

	/**
	 * modifie la position du personnage
	 * 
	 * @param p
	 */
	public void setP(Parcelle p) {
		this.p = p;
	}

	/**
	 * @return l'affiche en mode texte
	 */
	public String toString(){
		if(this instanceof Guerrier){
			return "Guerrier";
		}else{
			if(this instanceof Piegeur){
				return "Piegeur";
			}else{
				if(this instanceof Voleur){
					return "Voleur";
				}else{
					return "Explorateur";
				}
			}
		}

	}


	/**
	 * Permet de faire une action  differente en fonction du personnage qui agit
	 * l'action ce fait sur la parcelle cible
	 * 
	 * @param cible
	 * @param ile
	 */
	public abstract void Agit(Parcelle cible,Ile ile);

	/**
	 * @return si il a le tresor
	 */
	public boolean isaTresor() {
		return aTresor;
	}

	/**
	 * change l'étant du boolean aTresor
	 * 
	 * @param aTresor
	 */
	public void setaTresor(boolean aTresor) {
		this.aTresor = aTresor;
	}

	/**
	 * @return si il a la clef
	 */
	public boolean isaClef() {
		return aClef;
	}

	/**
	 * change l'étant du boolean aClef
	 * 
	 * @param aClef
	 */
	public void setaClef(boolean aClef) {
		this.aClef = aClef;
	}

	/**
	 * @return si il a une arme
	 */
	public boolean isaArme() {
		return aArme;
	}

	/**
	 * change l'étant du boolean aArme
	 * 
	 * @param aArme
	 */
	public void setaArme(boolean aArme) {
		this.aArme = aArme;
	}

	/**
	 * @return le nombre de mine qu'il possede
	 */
	public int getNbMine() {
		return nbMine;
	}

	/**
	 * ramplace l'ancien nombre de mines par le nouveau
	 * 
	 * @param nbMine
	 */
	public void setNbMine(int nbMine) {
		this.nbMine = nbMine;
	}

	/**
	 * @return si il a une action disponible
	 */
	public boolean getaction(){
		return action;
	}

	/**
	 * change l'étant du boolean action par le boolean b
	 * 
	 * @param b
	 */
	public void setaction(boolean b){
		action = b;
	}

	/**
	 * @return le nombre de tour qu'il lui reste a passer dans un piege
	 */
	public int gettour(){
		return tour;
	}

	/**
	 *retire un au nombre de tour qu'il lui reste a passer dans un piege
	 */
	public void settour(){
		tour-=1;
	}

	/**
	 *tombe dans un piege
	 */
	public void dansMine(){
		tour=3;
	}

	/**
	 * tue le personnage et depose son inventaire sur le sol
	 */
	public void mort(Ile ile){
		JOptionPane.showMessageDialog(new JOptionPane(), getnom() +" de l'equipe" +equipe+" est mort",null,JOptionPane.INFORMATION_MESSAGE);
		p.setEstPersonnage(false);
		vie=false;
		p.setMort(aArme, aClef, aTresor, nbMine);
	}

	/**
	 * @return si le personnage vie toujours
	 */
	public boolean getVie(){
		return vie;
	}

	/**
	 * @return le nom du personnage
	 */
	public abstract String getnom();

}
