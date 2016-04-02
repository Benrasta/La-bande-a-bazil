import java.util.Random;

public class Voleur extends Personage{
	
	
	public Voleur(int equipe, int energie, Parcelle p) {
		super(equipe, energie, p);
		
	}
	public void Agit(Parcelle cible,Ile ile){
		int chance = new Random().nextInt(100);
		int px=this.getP().getX();
		int py=this.getP().getY();
		int cx=cible.getX();
		int cy=cible.getY();
		if((py-1==cy && px==cx)|| (px-1==cx && py==cy) || (px+1==cx&&py==cy) || (py+1==cy && px==cx) ){
			if(cible.EstPersonage()){
				
				for(int i =0 ; i <ile.listperso.size();i++){
					if(this.getP().equals(ile.listperso.get(i).getP()) 
							&& this.getEquipe()!= ile.listperso.get(i).getEquipe()){
						if(ile.listperso.get(i).isaClef() && ile.listperso.get(i).isaTresor() && chance >=50){
							ile.listperso.get(i).setaClef(false);
							ile.listperso.get(i).setaTresor(false);
							this.setaClef(true);
							this.setaTresor(true);
						}else{
							if(ile.listperso.get(i).isaClef()&& chance >=50){
								ile.listperso.get(i).setaClef(false);
								this.setaClef(true);
							}else{
								if(ile.listperso.get(i).isaTresor()&& chance >=50){
									ile.listperso.get(i).setaTresor(false);
									this.setaTresor(true);
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
