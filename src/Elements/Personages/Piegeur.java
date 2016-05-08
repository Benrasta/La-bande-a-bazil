package Elements.Personages;
import Actions.Mine;
import Ile.Ile;
import Ile.Parcelle;

public class Piegeur extends Personnage {

	
	/**
	 * fait apelle au Constructeur de Personnage
	 * @param equipe
	 * @param energie
	 * @param p
	 */
	public Piegeur(int equipe, int energie, Parcelle p) {
		super(equipe, energie, p);
		this.setNbMine(10);
	}

	/**
	 * pose d'un piege
	 * 
	 * @see Personnage#Agit(Parcelle, Ile)
	 */
	public void Agit(Parcelle cible, Ile ile) {
		if(this.getNbMine()>0){
			int px=this.getP().getX();
			int py=this.getP().getY();
			int cx=cible.getX();
			int cy=cible.getY();
			if((px-1 ==cx && py==cy) || (py-1==cy && px==cx) || (px+1==cx && py-1==cy)
					|| (px-1==cx && py-1==cy) || (px+1==cx && py==cy)
					|| (px-1==cx && py+1==cy) || (py+1==cy && px==cx) || (px+1==cx && py+1==cy) ){
				if(!cible.getEstPersonnage() && !cible.getEstElement() && !cible.getEstBateau()){
					ile.getlistmine().add(new Mine(cible,this.getEquipe()));
					this.setNbMine(this.getNbMine()-1);
					this.setEnergie(this.getEnergie()-5);
					System.out.println("Vous avez pose une mine en "+cx+"-"+cy);
					if(this.getEnergie()==0){
						this.mort(ile);
					}
					cible.setEstMine(true);
					
				}else if (cible.getEstPersonnage()){
					this.echange(cible, ile);
				}else{
					System.out.println("Vous ne pouvez pas agir en "+cx+"-"+cy);
				}
				
			}else{
				System.out.println("Vous ne pouvez pas agir en "+cx+"-"+cy);
			}
		}
				
	}


	/**
	 * @return Piegeur
	 */	
	public String getnom(){
		return "Piegeur";
	}


}
