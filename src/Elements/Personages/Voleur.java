package Elements.Personages;
import java.util.Random;

import Ile.Ile;
import Ile.Parcelle;

public class Voleur extends Personnage{


	/**
	 * fait apelle au Constructeur de Personnage
	 * @param equipe
	 * @param energie
	 * @param p
	 */
	public Voleur(int equipe, int energie, Parcelle p) {
		super(equipe, energie, p);

	}
	/**
	 * action du voleur(chance de voler un objet a  l'adersaire)
	 * 
	 * @see Personnage#Agit(Parcelle, Ile)
	 */
	public void Agit(Parcelle cible,Ile ile){
		int chance = new Random().nextInt(100);
		int px=this.getP().getX();
		int py=this.getP().getY();
		int cx=cible.getX();
		int cy=cible.getY();
		if((px-1 ==cx && py==cy) || (py-1==cy && px==cx) || (px+1==cx && py-1==cy)
				|| (px-1==cx && py-1==cy) || (px+1==cx && py==cy)
				|| (px-1==cx && py+1==cy) || (py+1==cy && px==cx) || (px+1==cx && py+1==cy) ){
			if(cible.getEstPersonnage()){
				for(int i =0 ; i <ile.getlistperso().size();i++){
					if(this.getP().equals(ile.getlistperso().get(i).getP()) 
							&& this.getEquipe()!= ile.getlistperso().get(i).getEquipe()){
						setaction(false);
						if (chance <50){
							System.out.println("Vous n'avez pas reussi a voler cette personne");
						}else if(ile.getlistperso().get(i).isaClef() && ile.getlistperso().get(i).isaTresor()){
							ile.getlistperso().get(i).setaClef(false);
							ile.getlistperso().get(i).setaTresor(false);
							this.setaClef(true);
							this.setaTresor(true);
							System.out.println("Vous avez vole la clef et le tresor.");
						}else if(ile.getlistperso().get(i).isaClef()){
							ile.getlistperso().get(i).setaClef(false);
							this.setaClef(true);
							System.out.println("Vous avez vole la clef.");
						}else if(ile.getlistperso().get(i).isaTresor()){
							ile.getlistperso().get(i).setaTresor(false);
							this.setaTresor(true);
							System.out.println("Vous avez vole le tresor.");
						} else if(ile.getlistperso().get(i) instanceof Guerrier && ile.getlistperso().get(i).isaArme()){
							ile.getlistperso().get(i).setaArme(false);
							System.out.println("Vous avez voler une arme.");
						}else{
							System.out.println("Vous ne pouvez rien lui voler");
						}
						this.setEnergie(this.getEnergie()-10);
						if(this.getEnergie()==0){
							this.mort(ile);
						}
					}
				}
			}else{
				System.out.println("Vous ne pouvez pas agir en "+cx+"-"+cy);
			}
		}else{
			System.out.println("Vous ne pouvez pas agir en "+cx+"-"+cy);
		}
	}

	/**
	 * @return Voleur
	 */	
	public String getnom(){
		return "Voleur";
	}

}
