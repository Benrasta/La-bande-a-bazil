
public class Element {
	
	private int element;
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

	public void setPe(Parcelle pe) {
		this.pe = pe;
	}
	
}
