package Elements.Personages;
import Actions.Mine;
import Ile.Ile;
import Ile.Parcelle;

public class Piegeur extends Personage {

	
	
	public Piegeur(int equipe, int energie, Parcelle p) {
		super(equipe, energie, p);
		this.setNbMine(10);
	}

	
	public void Agit(Parcelle cible, Ile ile) {
		if(this.getNbMine()>0){
			int px=this.getP().getX();
			int py=this.getP().getY();
			int cx=cible.getX();
			int cy=cible.getY();
			if((px-1 ==cx && py==cy) || (py-1==cy && px==cx) || (px+1==cx && py-1==cy)
					|| (px-1==cx && py-1==cy) || (px+1==cx && py==cy)
					|| (px-1==cx && py+1==cy) || (py+1==cy && px==cx) || (px+1==cx && py+1==cy) ){
				if(!cible.getEstPersonage() && !cible.getEstElement() && !cible.getEstBateau()){
					ile.getlistmine().add(new Mine(cible,this.getEquipe()));
					this.setNbMine(this.getNbMine()-1);
					this.setEnergie(this.getEnergie()-5);
					System.out.println("Vous avez posez une mine en "+cx+"-"+cy);
					if(this.getEnergie()==0){
						this.mort(ile);
					}
					cible.setEstMine(true);
					
				}else{
					System.out.println("Vous ne pouvez pas agir en "+cx+"-"+cy);
				}
				
			}else{
				System.out.println("Vous ne pouvez pas agir en "+cx+"-"+cy);
			}
		}
				
	}


	public String getnom(){
		return "Piegeur";
	}


}
