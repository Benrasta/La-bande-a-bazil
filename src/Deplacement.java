
public class Deplacement extends Action {
	Ile ile;
	public Deplacement(Personage p, Parcelle cible,Ile ile){
		super(p,cible);
		this.ile=ile;
		
		
		int px=p.getP().getX();
		int py=p.getP().getY();
		int cx=cible.getX();
		int cy=cible.getY();
		
		if( p instanceof Voleur){
			//verifie si la cible est a porté du voleur
			if(!cible.estelement && !cible.estperso ){
				if( (px-1 ==cx && py==cy) || (py-1==cy && px==cx) || (px+1==cx && py-1==cy)
					|| (px-1==cx && py==cy) || (px+1==cx && py==cy)
					|| (px-1==cx && py+1==cy) || (py+1==cy && px==cx) || (px+1==cx && py+1==cy)){
					
					if(cible.equals(ile.listbateau.get(p.getEquipe()-1))){
						ile.getCarte()[p.getP().getX()][p.getP().getY()].estperso=false;
						ile.listperso.add(p);
					}else{
						if(p.getP().equals(ile.listbateau.get(p.getEquipe()-1))){
							ile.listperso.remove(p);
						}
					}
					
					// p prend pour parcelle la cible
					ile.getCarte()[p.getP().getX()][p.getP().getY()].estperso=false;
					p.setP(cible);
					p.setEnergie(p.getEnergie()-5);
					System.out.println(p.toString() +" se deplace en "+ cible.getX()+","+cible.getY() );
						cible.estperso=true;
					
					
			}	
			}
		}else{
			if( p instanceof Explorateur){
				if(!cible.estelement &&  !cible.estperso){
					//verifie si la cible et a porté de l'explorateur
					if((py-1==cy && px==cx)|| (px-1==cx && py==cy) || (px+1==cx&&py==cy) || (py+1==cy && px==cx) ){
						
						if(cible.equals(ile.listbateau.get(p.getEquipe()-1))){
							//ile.getCarte()[p.getP().getX()][p.getP().getY()].estperso=false;
							ile.listperso.add(p);
						}else{
							if(p.getP().equals(ile.listbateau.get(p.getEquipe()-1))){
								ile.listperso.remove(p);
							}
						}
						
					
						// p prend pour parcelle la cible
						ile.getCarte()[p.getP().getX()][p.getP().getY()].estperso=false;
						p.setP(cible);
						p.setEnergie(p.getEnergie()-5);
						System.out.println(p.toString() +" se deplace en "+ cible.getX()+","+cible.getY() );
						
						cible.estperso=true;
						}
					}
				
				}else{
				System.out.println(p.toString() +" ne peux se déplacé en "+ cible.getX()+","+cible.getY() );
				}
			}
		}
		
	
	
	
	
}
