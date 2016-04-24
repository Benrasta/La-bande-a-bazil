package Elements.Personages;
import Ile.Ile;
import Ile.Parcelle;

public class Explorateur extends Personage{
	
	
	public Explorateur(int equipe, int energie, Parcelle p) {
		super(equipe, energie, p);
		
	}

	//action de l'explorateur sur un element
	public void Agit(Parcelle cible,Ile ile){
		int px=this.getP().getX();
		int py=this.getP().getY();
		int cx=cible.getX();
		int cy=cible.getY();
		if( (px-1 ==cx && py==cy) || (py-1==cy && px==cx) || (px-1==cx && py==cy) || (py+1==cy && px==cx)){
			if(cible.getEstElement()){
				
				setaction(false);
			
				if(ile.getlistelement().get(1).getPe().equals(cible)){
					//explorateur prend clef
					System.out.println("Vous avez trouvez la clef");
					this.setaClef(true);
					// la clef est retirer de la carte
					ile.getlistelement().get(1).setElement(1);;
				}else if(ile.getlistelement().get(0).getPe().equals(cible)
						&& this.isaClef()  ){
					//explorateur prend letr�sord
					System.out.println("Vous avez trouvez le tresor");
					this.setaTresor(true);
					//le coffre se vide
					ile.getlistelement().get(0).setTresor(false);
				}else if(ile.getlistelement().get(0).getPe().equals(cible)){
					System.out.println("Vous avez trouvez le coffre, mais vous n'avez pas la clef");
				}else{
					System.out.println("Vous n'avez rien trouvez");
				}
				this.setEnergie(this.getEnergie()-5);
				if(this.getEnergie()<=0){
					this.mort(ile);
				}
			}else{
				System.out.println("Vous ne pouvez pas agir en "+cx+"-"+cy);
			}
				
		}else{
			System.out.println("Vous ne pouvez pas agir en "+cx+"-"+cy);
		}
	}
			
		
	public String getnom(){
		return "Explorateur";
	}
	
	
}