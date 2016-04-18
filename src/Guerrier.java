
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
			if((py-1==cy && px==cx)|| (px-1==cx && py==cy) || (px+1==cx&&py==cy) || (py+1==cy && px==cx) ){
				if(cible.EstPersonage()){
					
					for(int i =0 ; i <ile.listperso.size();i++){
						if(this.getP().equals(ile.listperso.get(i).getP()) 
								&& this.getEquipe()!= ile.listperso.get(i).getEquipe()){
							ile.listperso.get(i).setEnergie(ile.listperso.get(i).getEnergie()-15);
							this.setEnergie(this.getEnergie()-5);
							break;
						}
					}
				}
				
			}
		}
		
	}



}
