import java.util.Scanner;

public class Main {

	public static int saisie(){
		Scanner sc = new Scanner(System.in);
		int i =0;
		while (sc.hasNextInt()) {
	          i = sc.nextInt();
	          return i;
		}
		return  i;
	}
	
	
	
	public static void main(String[] args) {
		
		Ile laplaya = new Ile();
		laplaya.initialized(10);
		System.out.println(laplaya.toString());
		int i=1;
		Personage p1 = new Explorateur(1, 100,laplaya.listbateau.get(0).getP());
		laplaya.listperso.add(p1);
		Personage p2 = new Explorateur(2, 100,laplaya.listbateau.get(1).getP());
		laplaya.listperso.add(p2);
		while(true){
			System.out.println(" exporateur de l'equipe "+ i +" vie :"+ laplaya.listperso.get(i-1).getEnergie());
			System.out.println(" a la clef : "+laplaya.listperso.get(i-1).isaClef() );
			System.out.println(" a le tresor : " +laplaya.listperso.get(i-1).isaTresor());
			System.out.println("joueur " + i + " que veut tu faire ?");
			System.out.println("1: deplacement?");
			System.out.println("2 agir sur un element ?");
			int choix =saisie();
			if(i==1){
				System.out.println(p1.getP().getX()+";"+p1.getP().getY());
				if(choix == 1 ){
					
					System.out.println("joueur" + i + "ou veut tu te deplacer ?");
					System.out.println("x:");
					int x=saisie();
					System.out.println("y:");
					int y=saisie();
				
					if(x >=0 && y>=0 && x <laplaya.getCarte().length && y < laplaya.getCarte().length ){
						Action tmp = new Deplacement(p1,laplaya.getCarte()[x][y],laplaya);
					}
				} if(choix ==2){
					System.out.println("ou cherche tu?");
					System.out.println("x:");
					int x=saisie();
					System.out.println("y:");
					int y=saisie();
					if(x >=0 && y>=0 && x <laplaya.getCarte().length && y < laplaya.getCarte().length ){
						p1.Agit(laplaya.getCarte()[x][y],laplaya);
					}
				}
				
			}
			if(i==2){
				System.out.println(p2.getP().getX()+";"+p2.getP().getY());
				if(choix == 1 ){
					System.out.println();
					System.out.println("joueur" + i + "ou veut tu te deplacer ?");
					System.out.println("x:");
					int x=saisie();
					System.out.println("y:");
					int y=saisie();
				
					if(x >=0 && y>=0 && x <laplaya.getCarte().length && y < laplaya.getCarte().length ){
						Action tmp = new Deplacement(p2,laplaya.getCarte()[x][y],laplaya);
					}
				} if(choix ==2){
					System.out.println("ou cherche tu?");
					System.out.println("x:");
					int x=saisie();
					System.out.println("y:");
					int y=saisie();
					if(x >=0 && y>=0 && x <laplaya.getCarte().length && y < laplaya.getCarte().length ){
						p2.Agit(laplaya.getCarte()[x][y],laplaya);
					}
					
					}
					
			
			}
			if(i==1){
				i=2;
			}else{
				i=1;
			}
			System.out.println(laplaya.toString());
		}
		
	}

}
