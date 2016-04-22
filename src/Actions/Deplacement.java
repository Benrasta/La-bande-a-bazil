package Actions;
import Elements.Personages.Explorateur;
import Elements.Personages.Guerrier;
import Elements.Personages.Personage;
import Elements.Personages.Piegeur;
import Elements.Personages.Voleur;
import Ile.Ile;
import Ile.Parcelle;

public class Deplacement extends Action {
	
	Ile ile;
	private int px;
	private int py;
	private int cx;
	private int cy;
	
	public Deplacement(Personage p, Parcelle cible,Ile ile){
		super(p,cible);
		this.ile=ile;
		
		
		px=p.getP().getX();
		py=p.getP().getY();
		cx=cible.getX();
		cy=cible.getY();
		
		if( p instanceof Voleur || p instanceof Guerrier || p instanceof Piegeur){
			//verifie si la cible est a porté du voleur
			if(!cible.getEstElement() && !cible.getEstPersonage() ){
				if( (px-1 ==cx && py==cy) || (py-1==cy && px==cx) || (px+1==cx && py-1==cy)
					|| (px-1==cx && py==cy) || (px+1==cx && py==cy)
					|| (px-1==cx && py+1==cy) || (py+1==cy && px==cx) || (px+1==cx && py+1==cy)){
					p.setEnergie(p.getEnergie()-5);
					
					// p prend pour parcelle la cible
					ile.getCarte()[p.getP().getX()][p.getP().getY()].setEstPersonage(false);
					p.setP(cible);
					
					if(cible.equals(ile.getlistbateau().get(p.getEquipe()-1))){
						ile.getCarte()[p.getP().getX()][p.getP().getY()].setEstPersonage(false);
						ile.getlistbateau().get(p.getEquipe()-1).lp.add(p);
						p.setEnergie(100);
						if(p.isaTresor()){
							ile.getlistbateau().get(p.getEquipe()-1).setTresor(true);
						}
						if(p instanceof Guerrier){
							p.setaArme(true);
						}
					}else{
						if(p.getP().equals(ile.getlistbateau().get(p.getEquipe()-1))){
							ile.getlistbateau().get(p.getEquipe()-1).lp.remove(p);
						}
					}
					
					
					if(cible.getEstMine()){
						p.setEnergie(p.getEnergie()-10);
						cible.setEstMine(false);
					}
					
					System.out.println(p.toString() +" se deplace en "+ cible.getX()+","+cible.getY() );
					if(!cible.getEstBateau()){
					cible.setEstPersonage(true);
					}	
					
			}	
			}
		}else{
			if( p instanceof Explorateur){
				if(!cible.getEstElement() &&  !cible.getEstPersonage()){
					//verifie si la cible et a porté de l'explorateur
					if((py-1==cy && px==cx)|| (px-1==cx && py==cy) || (px+1==cx&&py==cy) || (py+1==cy && px==cx) ){
						p.setEnergie(p.getEnergie()-5);
						
						// p prend pour parcelle la cible
						ile.getCarte()[p.getP().getX()][p.getP().getY()].setEstPersonage(false);
						p.setP(cible);
						
						if(cible.equals(ile.getlistbateau().get(p.getEquipe()-1))){
							//ile.getCarte()[p.getP().getX()][p.getP().getY()].setEstPersonage(false);
							ile.getlistbateau().get(p.getEquipe()-1).lp.add(p);
							p.setEnergie(100);
							if(p.isaTresor()){
								ile.getlistbateau().get(p.getEquipe()-1).setTresor(true);
							}
						}else{
							if(p.getP().equals(ile.getlistbateau().get(p.getEquipe()-1))){
								ile.getlistbateau().get(p.getEquipe()-1).lp.remove(p);
							}
						}
						
					
						
						if(cible.getEstMine()){
							p.setEnergie(p.getEnergie()-10);
							cible.setEstMine(false);
						}
						System.out.println(p.toString() +" se deplace en "+ cible.getX()+","+cible.getY() );
						if(!cible.getEstBateau()){
							cible.setEstPersonage(true);
							}
						}
					}
				
				}else{
				System.out.println(p.toString() +" ne peux se déplacé en "+ cible.getX()+","+cible.getY() );
				}
			}
		}
		
	
	
	
	
}
