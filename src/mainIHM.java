import java.util.Random;

public class mainIHM {

	public static void main(String args[]){
		Random r=new Random();
		String[] gifs={"images/arbre.png","images/rocher.png","images/1.navire.png",
				"images/2.navire.png","images/mer.png","images/coffre.png"};
		Ile carte= new Ile();
		carte.initialized();
		int taille =carte.getCarte().length;
		SuperPlateau p1 = new SuperPlateau(gifs, taille);
		int[][] jeu=new int[taille][taille];
		for (int i=0;i<taille;i++){
			for (int j=0;j<taille;j++){
				
					if(carte.getCarte()[i][j].estbateau && 
							carte.listbateau.get(0).getP().equals(carte.getCarte()[i][j])){
						jeu[i][j]=4;
					}
					if(carte.getCarte()[i][j].estbateau && 
							carte.listbateau.get(1).getP().equals(carte.getCarte()[i][j])){
						jeu[i][j]=3;
					}
					if(carte.getCarte()[i][j].estelement){
						jeu[i][j]=2;
						if(carte.listelement.get(2).getPe().equals(carte.getCarte()[i][j])){
								jeu[i][j]=6;
							}
													
					}
					if(!carte.getCarte()[i][j].estelement && !carte.getCarte()[i][j].estbateau ){
						jeu[i][j]=1;
					}
				
			}
		}
		p1.setJeu(jeu);
		p1.affichage();
		
	}
}
