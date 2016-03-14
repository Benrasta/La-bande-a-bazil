
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


	boolean EstCoffre(){
		if( this.getElement()==3){
			return true;
		}else {
		return false;
		}
	}
	boolean EstCle(){
		if( this.getElement()==2){
			return true;
		}else {
		return false;
		}
	}
	boolean EstRocher(){
		if( this.getElement()==1){
			return true;
		}else {
		return false;
		}
	}
	/*
	boolean EstEau(){
		if( this.getElement()==0){
			return true;
		}else {
		return false;
		}
	}
	*/
	
}
