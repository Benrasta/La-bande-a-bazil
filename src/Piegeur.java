
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
			if((py-1==cy && px==cx)|| (px-1==cx && py==cy) || (px+1==cx&&py==cy) || (py+1==cy && px==cx) ){
				if(!cible.EstPersonage() && !cible.estelement && !cible.estbateau){
					ile.listmine.add(new Mine(cible,this.getEquipe()));
					this.setNbMine(this.getNbMine()-1);
					this.setEnergie(this.getEnergie()-5);
					cible.estMine =true;
					
				}
				
			}
		}
		
		
	}


	




}
