
public class Element {
	
	private int element;		// 1 = rocher, 2 = clef, 3 = coffre
	private Parcelle pe;
	/**
	 * construit un element
	 * @param element
	 * @param pe
	 */
	public Element(int element,Parcelle pe){
		this.element=element;
		this.pe=pe;
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
	boolean EstCoffre(){
		return this.getElement()==3;
		
	}
	/**
	 * revoie vrai si l'element courant et de type clef
	 * @return
	 */
	boolean EstCle(){
		return this.getElement()==2;
	}
	/**
	 * revoie vrai si l'element courant et de type rocher
	 * @return
	 */
	boolean EstRocher(){
		return this.getElement()==1;
		
	}
}
