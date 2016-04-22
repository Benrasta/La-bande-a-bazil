package Elements;
import Ile.Parcelle;

public class Element {
	
	private int element;		// 1 = rocher, 2 = clef, 3 = coffre
	private Parcelle pe;
	private boolean tresor=false;
	/**
	 * construit un element
	 * @param element
	 * @param pe
	 */
	public Element(int element,Parcelle pe){
		this.element=element;
		this.pe=pe;
		if(this.EstCoffre()){
			setTresor(true);
			pe.setEstCoffre(true);
		}
	}
	/**
	 * renvoie le type de l'element
	 * @return un entier
	 */
	public int getElement() {
		return element;
	}

	/**
	 * écrase l'élément courant par celui entrer en paramètre
	 * @param element
	 */
	public void setElement(int element) {
		this.element = element;
	}
	/**
	 * revoie la parcel de l'element courant
	 * @return
	 */
	public Parcelle getPe() {
		return pe;
	}

	/**
	 * revoie vrai si l'element courant et de type coffre
	 * @return
	 */
	public boolean EstCoffre(){
		return this.getElement()==3;
		
	}
	/**
	 * revoie vrai si l'element courant et de type clef
	 * @return
	 */
	public boolean EstCle(){
		return this.getElement()==2;
	}
	/**
	 * revoie vrai si l'element courant et de type rocher
	 * @return
	 */
	public boolean EstRocher(){
		return this.getElement()==1;
		
	}
	public boolean isTresor() {
		return tresor;
	}
	public void setTresor(boolean tresor) {
		this.tresor = tresor;
	}
}
