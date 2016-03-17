
public class Element {
	
	private int element;		// 1 = rocher, 2 = clef, 3 = coffre
	private Parcelle pe;
	
	public Element(int element,Parcelle pe){
		this.element=element;
		this.pe=pe;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public Parcelle getPe() {
		return pe;
	}


	boolean EstCoffre(){
		return this.getElement()==3;
		
	}
	boolean EstCle(){
		return this.getElement()==2;
	}
	boolean EstRocher(){
		return this.getElement()==1;
		
	}
}
