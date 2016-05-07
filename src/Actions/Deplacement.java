package Actions;
import Autre.Jeu;
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

	public Deplacement(Personage p, Parcelle cible,Jeu jeu){
		super(p,cible);
		ile=jeu.getIle();


		px=p.getP().getX();
		py=p.getP().getY();
		cx=cible.getX();
		cy=cible.getY();

		if( p instanceof Voleur || p instanceof Guerrier || p instanceof Piegeur){
			//verifie si la cible est a port� du voleur
			if(!cible.getEstElement() && !cible.getEstPersonage() ){
				if( (px-1 ==cx && py==cy) || (py-1==cy && px==cx) || (px+1==cx && py-1==cy)
						|| (px-1==cx && py-1==cy) || (px+1==cx && py==cy)
						|| (px-1==cx && py+1==cy) || (py+1==cy && px==cx) || (px+1==cx && py+1==cy)){
					p.setEnergie(p.getEnergie()-1);
					// p prend pour parcelle la cible
					ile.getCarte()[p.getP().getX()][p.getP().getY()].setEstPersonage(false);
					p.setP(cible);
					p.setaction(false);

					if(cible.equals(ile.getlistbateau().get(p.getEquipe()-1))){
						ile.getCarte()[p.getP().getX()][p.getP().getY()].setEstPersonage(false);
						ile.getlistbateau().get(p.getEquipe()-1).lp.add(p);
						if(p.isaTresor()){
							ile.getlistbateau().get(p.getEquipe()-1).setTresor(true);
							ile.FinDeJeu(p.getEquipe());
						}
						if(p instanceof Guerrier){
							p.setaArme(true);
						}
					}else if(p.getP().equals(ile.getlistbateau().get(p.getEquipe()-1))){
						ile.getlistbateau().get(p.getEquipe()-1).lp.remove(p);
					}else{
						cible.setEstPersonage(true);
						if (cible.getMort()){
							cible.setInventaire(p);
						}
						if(cible.getEstMine()){
							p.dansMine();
						}
					}
					System.out.println(p.toString() +" se deplace en "+ cible.getX()+","+cible.getY() );

				}else{
					System.out.println(p.toString() +" ne peux se deplacer en "+ cible.getX()+","+cible.getY() );
				}
			}else{
				System.out.println(p.toString() +" ne peux se deplacer en "+ cible.getX()+","+cible.getY() );
			}
		}else {
			if(!cible.getEstElement() &&  !cible.getEstPersonage()){
				//verifie si la cible et a port� de l'explorateur
				if((py-1==cy && px==cx)|| (px-1==cx && py==cy) || (px+1==cx&&py==cy) || (py+1==cy && px==cx) ){
					p.setEnergie(p.getEnergie()-1);
					// p prend pour parcelle la cible
					ile.getCarte()[p.getP().getX()][p.getP().getY()].setEstPersonage(false);
					p.setP(cible);
					p.setaction(false);
					if(cible.equals(ile.getlistbateau().get(p.getEquipe()-1))){
						//ile.getCarte()[p.getP().getX()][p.getP().getY()].setEstPersonage(false);
						ile.getlistbateau().get(p.getEquipe()-1).lp.add(p);
						if(p.isaTresor()){
							ile.getlistbateau().get(p.getEquipe()-1).setTresor(true);
							ile.FinDeJeu(p.getEquipe());
						}
					}else if(p.getP().equals(ile.getlistbateau().get(p.getEquipe()-1))){
						ile.getlistbateau().get(p.getEquipe()-1).lp.remove(p);

					}else{
						cible.setEstPersonage(true);
						if (cible.getMort()){
							cible.setInventaire(p);
						}
						if(cible.getEstMine()){
							p.dansMine();
						}
					}
					System.out.println(p.toString() +" se deplace en "+ cible.getX()+","+cible.getY() );
				}else{
					System.out.println(p.toString() +" ne peux se deplacer en "+ cible.getX()+","+cible.getY() );
				}
			}else{
				System.out.println(p.toString() +" ne peux se deplacer en "+ cible.getX()+","+cible.getY() );
			}

		}
		if (p.getEnergie()==0){
			p.mort(ile);
		}
		ile.affichage(p.getEquipe(), jeu);
	}

}
