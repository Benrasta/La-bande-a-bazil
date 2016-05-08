package Elements.Personages;
import Ile.Ile;
import Ile.Parcelle;

public class Guerrier extends Personnage {
	
	/**
	 * fait apelle au Constructeur de Personnage
	 * @param equipe
	 * @param energie
	 * @param p
	 */
	public Guerrier(int equipe, int energie, Parcelle p) {
		super(equipe, energie, p);
		this.setaArme(true);
		
	}

	/**
	 * attaque du gerrier
	 * @see Personnage#Agit(Parcelle, Ile)
	 */
	public void Agit(Parcelle cible, Ile ile) {
		if(this.isaArme()){
			int px=this.getP().getX();
			int py=this.getP().getY();
			int cx=cible.getX();
			int cy=cible.getY();
			if((px-1 ==cx && py==cy) || (py-1==cy && px==cx) || (px+1==cx && py-1==cy)
					|| (px-1==cx && py-1==cy) || (px+1==cx && py==cy)
					|| (px-1==cx && py+1==cy) || (py+1==cy && px==cx) || (px+1==cx && py+1==cy) ){
				if(cible.getEstPersonnage()){
					setaction(false);
					for(int i =0 ; i <ile.getlistperso().size();i++){
						if(this.getP().equals(ile.getlistperso().get(i).getP()) 
								&& this.getEquipe()!= ile.getlistperso().get(i).getEquipe()){
							ile.getlistperso().get(i).setEnergie(ile.getlistperso().get(i).getEnergie()-15);
							if(ile.getlistperso().get(i).getEnergie()==0){
								ile.getlistperso().get(i).mort(ile);
							}
							System.out.println("Vous avez attaque :" + ile.getlistperso().get(i).getnom() );
							this.setEnergie(this.getEnergie()-10);
							if(this.getEnergie()==0){
								this.mort(ile);
							}
							break;
						}
					}
				}else{
					System.out.println("Vous ne pouvez pas agir en "+cx+"-"+cy);
				}
				
			}else{
				System.out.println("Vous ne pouvez pas agir en "+cx+"-"+cy);
			}
		}else{
			System.out.println("Vous n'avez pas d'arme");
		}
		
	}


	/**
	 * @return Guerrier
	 */	
	public String getnom(){
		return "Guerrier";
	}

}
