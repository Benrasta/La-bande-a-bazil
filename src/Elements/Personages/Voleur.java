package Elements.Personages;
import java.util.Random;

import Ile.Ile;
import Ile.Parcelle;

public class Voleur extends Personage{
	
	
	public Voleur(int equipe, int energie, Parcelle p) {
		super(equipe, energie, p);
		
	}
	/**
	 * action du voleur(chance de volé un objet a  l'adersaire
	 */
	public void Agit(Parcelle cible,Ile ile){
		int chance = new Random().nextInt(100);
		int px=this.getP().getX();
		int py=this.getP().getY();
		int cx=cible.getX();
		int cy=cible.getY();
		if((py-1==cy && px==cx)|| (px-1==cx && py==cy) || (px+1==cx&&py==cy) || (py+1==cy && px==cx) ){
			if(cible.getEstPersonage()){
				
				for(int i =0 ; i <ile.getlistperso().size();i++){
					if(this.getP().equals(ile.getlistperso().get(i).getP()) 
							&& this.getEquipe()!= ile.getlistperso().get(i).getEquipe()){
						if(ile.getlistperso().get(i).isaClef() && ile.getlistperso().get(i).isaTresor() && chance >=50){
							ile.getlistperso().get(i).setaClef(false);
							ile.getlistperso().get(i).setaTresor(false);
							this.setaClef(true);
							this.setaTresor(true);
						}else{
							if(ile.getlistperso().get(i).isaClef()&& chance >=50){
								ile.getlistperso().get(i).setaClef(false);
								this.setaClef(true);
							}else{
								if(ile.getlistperso().get(i).isaTresor()&& chance >=50){
									ile.getlistperso().get(i).setaTresor(false);
									this.setaTresor(true);
								} else {
									if(ile.getlistperso().get(i) instanceof Guerrier && ile.getlistperso().get(i).isaArme()&& chance >=50 ){
									ile.getlistperso().get(i).setaArme(false);
									}
								}
							}
							
						}
					}
				}
				this.setEnergie(this.getEnergie()-5);
			}
		}
	
	
	
	
	}
}
