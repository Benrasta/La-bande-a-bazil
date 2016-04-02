
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
		if( (px-1 ==cx && py==cy) || (py-1==cy && px==cx) || (px+1==cx && py-1==cy)
				|| (px-1==cx && py==cy) || (px+1==cx && py==cy)
				|| (px-1==cx && py+1==cy) || (py+1==cy && px==cx) || (px+1==cx && py+1==cy)){
			if(cible.estelement){
			
				if(ile.listelement.get(1).getPe().equals(cible)){
					//explorateur prend clef
					this.setaClef(true);
					// la clef est retirer de la carte
					ile.listelement.get(1).setElement(1);;
				}			
				if(ile.listelement.get(0).getPe().equals(cible)
						&& this.isaClef()  ){
					//explorateur prend letrésord
					this.setaTresor(true);
					//le coffre se vide
					ile.listelement.get(0).setTresor(false);
				}
			}
				
		}
	}
			
		
	
	
	
}
