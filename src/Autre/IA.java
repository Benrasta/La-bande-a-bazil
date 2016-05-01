package Autre;

import java.util.ArrayList;
import java.util.Random;

import Actions.Deplacement;
import Elements.Personages.Explorateur;
import Elements.Personages.Guerrier;
import Elements.Personages.Personage;
import Elements.Personages.Voleur;
import Ile.Parcelle;

public class IA {

	Random r=new Random();
	private boolean[][] accessible;
	private boolean aTresor=false;
	private Parcelle estCoffre;
	private Parcelle estBateau;
	private Jeu jeu;

	public IA(int equipe, int nbperso, Jeu jeu){
		this.jeu=jeu;
		int ran=r.nextInt(nbperso+1);
		for(int i=0; i<ran; i++){
			jeu.getIle().getlistperso().add(new Explorateur(equipe,100, jeu.getIle().getlistbateau().get(equipe-1).getP()));
		}
		nbperso-=ran;
		ran=r.nextInt(nbperso+1);
		for(int i=0; i<ran; i++){
			jeu.getIle().getlistperso().add(new Guerrier(equipe,100, jeu.getIle().getlistbateau().get(equipe-1).getP()));
		}
		nbperso-=ran;
		for(int i=0; i<nbperso; i++){
			jeu.getIle().getlistperso().add(new Voleur(equipe,100, jeu.getIle().getlistbateau().get(equipe-1).getP()));
		}
		accessible=new boolean[jeu.getIle().getCarte().length][jeu.getIle().getCarte().length];
		for(int i=0; i<accessible.length; i++){
			for(int j=0; j<accessible.length; j++){
				if( jeu.getIle().getCarte()[i][j].getEstBateau()){
					accessible[i][j]= false;
					this.estBateau=jeu.getIle().getlistbateau().get(equipe-1).getP();
				}else{
					accessible[i][j]= true;
				}
			}
		}
		estCoffre=estBateau;
		jeu.Debut(equipe);
	}

	public void tour(){
		for (int i=0; i<(jeu.getIle().getlistperso().size()/2); i++){
			Personage p=jeu.getIle().getlistperso().get(i);
			if (!estBateau.equals(p.getP()) || p.getEnergie()==100){
				if (((estBateau.getX()-p.getP().getX())+(estBateau.getY()-p.getP().getY())+jeu.getIle().getCarte().length+5>=p.getEnergie())|| aTresor){
					retour(p,estBateau);
				}else{				
					if(p instanceof Explorateur){tourExplorateur (p);}
					if(p instanceof Guerrier){tourGuerrier(p);}
					if(p instanceof Voleur){tourVoleur(p);}
					if(p.isaTresor()){this.aTresor=true;}
				}
			}
		}
	}	



	private void retour (Personage p, Parcelle destination){
		int X=p.getP().getX();
		int Y=p.getP().getY();
		int x=destination.getX()-X;
		int y=destination.getY()-Y;
		if (Math.abs(x)>=Math.abs(y)){
			if (x>0){new Deplacement(p,jeu.getIle().getCarte() [X+1] [Y], jeu.getIle());}else{new Deplacement(p,jeu.getIle().getCarte() [X-1] [Y], jeu.getIle());}
		}else{
			if (y>0){new Deplacement(p,jeu.getIle().getCarte() [X] [Y+1], jeu.getIle());}else{new Deplacement(p,jeu.getIle().getCarte() [X] [Y-1], jeu.getIle());}
		}
	}


	private void tourExplorateur(Personage p){
		int X=p.getP().getX();
		int Y=p.getP().getY();
		if (p.isaClef() && !estCoffre.equals(estBateau)){retour(p,estCoffre);}
		else if( jeu.getIle().getCarte() [X-1] [Y].getEstBateau()){
			ArrayList<Parcelle> possible= new ArrayList<>();
			for(int i=-1; i<=1; i++){
				for(int j=-1; j<=1; j++){
					if(X+i<jeu.getIle().getCarte().length && Y+j<jeu.getIle().getCarte().length && X+i>=0 && Y+j>=0){
						if(jeu.getIle().getCarte() [X+i] [Y+j].getEstElement() && accessible [X+i][Y+j]){possible.add(jeu.getIle().getCarte() [X+i] [Y+j]);}
					}
				}
			}
			if (possible.size()==0){
				int x;
				int y;
				do{
					x = (r.nextInt(4))-1;
					y = (r.nextInt(4))-1;
				}while ( !(x==0 ^ y==0) || jeu.getIle().getCarte() [x] [y].getEstBateau() || !jeu.getIle().getCarte() [x] [y].getEstPersonage() || !jeu.getIle().getCarte() [x] [y].getEstElement() || !jeu.getIle().getCarte() [x] [y].getEstMine());
				new Deplacement(p,jeu.getIle().getCarte() [x] [y], jeu.getIle());
			}else{new Deplacement(p, possible.get(r.nextInt(possible.size())), jeu.getIle());}
		}else{
			if(X-1>=0 && accessible[X-1][Y] && jeu.getIle().getCarte() [X-1] [Y].getEstElement()){
				p.Agit(jeu.getIle().getCarte() [X-1] [Y], jeu.getIle());
				accessible[X-1][Y]= false;
				if (jeu.getIle().getCarte() [X-1] [Y].getEstCoffre()){this.estCoffre=jeu.getIle().getCarte() [X-1] [Y];}
			}else if(Y-1>=0 && accessible[X][Y-1] && jeu.getIle().getCarte() [X] [Y-1].getEstElement()){
				p.Agit(jeu.getIle().getCarte() [X] [Y-1], jeu.getIle());
				accessible[X][Y-1]= false;
				if (jeu.getIle().getCarte() [X] [Y-1].getEstCoffre()){this.estCoffre=jeu.getIle().getCarte() [X] [Y-1];}
			}else if(Y+1<jeu.getIle().getCarte().length && accessible[X][Y+1] && jeu.getIle().getCarte() [X] [Y+1].getEstElement()){
				p.Agit(jeu.getIle().getCarte() [X] [Y+1], jeu.getIle());
				accessible[X][Y+1]= false;
				if (jeu.getIle().getCarte() [X] [Y+1].getEstCoffre()){this.estCoffre=jeu.getIle().getCarte() [X] [Y+1];}
			}else if(X+1<jeu.getIle().getCarte().length && accessible[X+1][Y] && jeu.getIle().getCarte() [X+1] [Y].getEstElement()){
				p.Agit(jeu.getIle().getCarte() [X+1] [Y], jeu.getIle());
				accessible[X+1][Y]= false;
				if (jeu.getIle().getCarte() [X+1] [Y].getEstCoffre()){this.estCoffre=jeu.getIle().getCarte() [X+1] [Y];}
			}else{
				ArrayList<Parcelle> possible= new ArrayList<>();
				for(int i=-1; i<=1; i++){
					for(int j=-1; j<=1; j++){
						if(X+i<jeu.getIle().getCarte().length && Y+j<jeu.getIle().getCarte().length && X+i>=0 && Y+j>=0){
							if(jeu.getIle().getCarte() [X+i] [Y+j].getEstElement() && accessible [X+i][Y+j]){possible.add(jeu.getIle().getCarte() [X+i] [Y+j]);}
						}
					}
				}
				if (possible.size()==0){
					int x;
					int y;
					do{
						x = (r.nextInt(4))-1;
						y = (r.nextInt(4))-1;
					}while ( !(x==0 ^ y==0) || jeu.getIle().getCarte() [x] [y].getEstBateau() || !jeu.getIle().getCarte() [x] [y].getEstPersonage() || !jeu.getIle().getCarte() [x] [y].getEstElement() || !jeu.getIle().getCarte() [x] [y].getEstMine());
					new Deplacement(p,jeu.getIle().getCarte() [x] [y], jeu.getIle());
				}else{new Deplacement(p, possible.get(r.nextInt(possible.size())), jeu.getIle());}
			}
		}				
	}

	private void tourGuerrier (Personage p){
		int X=p.getP().getX();
		int Y=p.getP().getY();
		int k;
		boolean aAgit=false;
		if(p.isaClef()){
			int i=0;
			while(jeu.getIle().getlistperso().get(i).getEquipe()!= p.getEquipe()){i++;}
			retour(p,jeu.getIle().getlistperso().get(i).getP());
		}else if(!p.isaArme()){
			retour(p,estBateau);
		}else{
			for(int i=-1; i<=1 ; i++){
				for(int j=-1; j<=1 ; j++){
					if(!aAgit && (X+i>=0 && Y+j>=0 && X+i<jeu.getIle().getCarte().length && Y+j<jeu.getIle().getCarte().length) &&(i!=0 || j!=0 ) && ( jeu.getIle().getCarte() [X+i] [Y+j].getEstPersonage())){
						k=0;
						while(!(jeu.getIle().getCarte() [X+i] [Y+j].equals(jeu.getIle().getlistperso().get(k).getP()))){k++;}
						if(jeu.getIle().getlistperso().get(k).getEnergie()!=p.getEnergie()){
							p.Agit(jeu.getIle().getCarte() [X+i] [Y+j], jeu.getIle());
							aAgit=true;
						}
					}
				}
			}
			if(!aAgit){
				ArrayList<Parcelle> possible= new ArrayList<>();
				for(int i=-1; i<=1; i++){
					for(int j=-1; j<=1; j++){
						if( (X+i<jeu.getIle().getCarte().length && Y+j<jeu.getIle().getCarte().length && X+i>=0 && Y+j>=0) && (Math.abs(i)!=1 && Math.abs(j)!=1)){
							if(jeu.getIle().getCarte()[i][j].getEstPersonage()){
								k=0;
								while(!(jeu.getIle().getCarte() [X+i] [Y+j].equals(jeu.getIle().getlistperso().get(i).getP()))){k++;}
								if(jeu.getIle().getlistperso().get(i).getEquipe()!=p.getEquipe()){possible.add(jeu.getIle().getCarte() [X+i] [Y+j]);}
							}
						}
					}
				}
				if (possible.size()==0){
					int x;
					int y;
					do{
						x = (r.nextInt(4))-1;
						y = (r.nextInt(4))-1;
					}while ( !(x==0 ^ y==0) || jeu.getIle().getCarte() [x] [y].getEstBateau() || !jeu.getIle().getCarte() [x] [y].getEstPersonage() || !jeu.getIle().getCarte() [x] [y].getEstElement() || !jeu.getIle().getCarte() [x] [y].getEstMine());
					new Deplacement(p,jeu.getIle().getCarte() [x] [y], jeu.getIle());
				}else{new Deplacement(p, possible.get(r.nextInt(possible.size())), jeu.getIle());}
			}
		}
	}

	private void tourVoleur (Personage p){
		int X=p.getP().getX();
		int Y=p.getP().getY();
		int k;
		boolean aAgit=false;
		if(p.isaClef()){
			int i=0;
			while(jeu.getIle().getlistperso().get(i).getEquipe()!=p.getEquipe()){i++;}
			retour(p,jeu.getIle().getlistperso().get(i).getP());
		}else{
			for(int i=-1; i<=1 ; i++){
				for(int j=-1; j<=1 ; j++){
					if((X+i>=0 && Y+j>=0 && X+i<jeu.getIle().getCarte().length && Y+j<jeu.getIle().getCarte().length) &&(i!=0 || j!=0 ) && ( jeu.getIle().getCarte() [X+i] [Y+j].getEstPersonage())){
						k=0;
						while(!(jeu.getIle().getCarte() [X+i] [Y+j].equals(jeu.getIle().getlistperso().get(k).getP()))){k++;}
						if(jeu.getIle().getlistperso().get(k).getEquipe()!=p.getEquipe()){
							p.Agit(jeu.getIle().getCarte() [X+i] [Y+j], jeu.getIle());
						}
					}
				}
			}
			if(!aAgit){
				ArrayList<Parcelle> possible= new ArrayList<>();
				for(int i=-2; i<=2; i++){
					for(int j=-2; j<=1; j++){
						if( (X+i<jeu.getIle().getCarte().length && Y+j<jeu.getIle().getCarte().length && X+i>=0 && Y+j>=0) && (Math.abs(i)!=1 && Math.abs(j)!=1)){
							if(jeu.getIle().getCarte()[i][j].getEstPersonage()){
								k=0;
								while(!(jeu.getIle().getCarte() [X+i] [Y+j].equals(jeu.getIle().getlistperso().get(i).getP()))){k++;}
								if(jeu.getIle().getlistperso().get(i).getEquipe()!=p.getEquipe()){possible.add(jeu.getIle().getCarte() [X+i] [Y+j]);}
							}
						}
					}
				}
				if (possible.size()==0){
					int x;
					int y;
					do{
						x = (r.nextInt(4))-1;
						y = (r.nextInt(4))-1;
					}while ( !(x==0 ^ y==0) || jeu.getIle().getCarte() [x] [y].getEstBateau() || !jeu.getIle().getCarte() [x] [y].getEstPersonage()|| !jeu.getIle().getCarte() [x] [y].getEstElement() || !jeu.getIle().getCarte() [x] [y].getEstMine());
					new Deplacement(p,jeu.getIle().getCarte() [x] [y], jeu.getIle());
				}else{new Deplacement(p, possible.get(r.nextInt(possible.size())), jeu.getIle());}
			}
		}
	}
}

