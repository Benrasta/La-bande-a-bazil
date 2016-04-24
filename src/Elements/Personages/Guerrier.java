package Elements.Personages;
import Ile.Ile;
import Ile.Parcelle;

public class Guerrier extends Personage {
	
	
	public Guerrier(int equipe, int energie, Parcelle p) {
		super(equipe, energie, p);
		this.setaArme(true);
		
	}

	/**
	 * attaque du gerrier
	 * @see Personage#Agit(Parcelle, Ile)
	 */
	public void Agit(Parcelle cible, Ile ile) {
		if(this.isaArme()){
			int px=this.getP().getX();
			int py=this.getP().getY();
			int cx=cible.getX();
			int cy=cible.getY();
			if((px-1 ==cx && py==cy) || (py-1==cy && px==cx) || (px+1==cx && py-1==cy)
					|| (px-1==cx && py==cy) || (px+1==cx && py+1==cy)
					|| (px-1==cx && py+1==cy) || (py+1==cy && px==cx) || (px+1==cx && py+1==cy) ){
				if(cible.getEstPersonage()){
					setaction(false);
					for(int i =0 ; i <ile.getlistperso().size();i++){
						if(this.getP().equals(ile.getlistperso().get(i).getP()) 
								&& this.getEquipe()!= ile.getlistperso().get(i).getEquipe()){
							ile.getlistperso().get(i).setEnergie(ile.getlistperso().get(i).getEnergie()-15);
							if(ile.getlistperso().get(i).getEnergie()<=0){
								ile.getlistperso().get(i).mort(ile);
							}
							this.setEnergie(this.getEnergie()-10);
							if(this.getEnergie()<=0){
								this.mort(ile);
							}
							break;
						}
					}
				}
				
			}
		}
		
	}


	public String getnom(){
		return "Guerrier";
	}

}
