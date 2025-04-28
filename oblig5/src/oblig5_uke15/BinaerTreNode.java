package oblig5_uke15;

public class BinaerTreNode<T extends Comparable<T>> {
	
	private T element;
	private BinaerTreNode<T> venstre, hoyre;
	private BinaerTreNode<T> rot;
	private int hoydeU;
	
	public BinaerTreNode(T element){
		this.element = element;
		venstre = hoyre = null;
		hoydeU = 1; // gir en enkelt node høyde 1 
	}
		public T getElement() {
			return element;
		}
		
		public void setElement(T element) {
			this.element = element;
		}
		
		public BinaerTreNode<T> getVenstre() { 
			return venstre;
		}
		
		public void setVenstre(BinaerTreNode<T> venstre) {
			this.venstre = venstre;
		}
		
		public BinaerTreNode<T> getHoyre(){
			return hoyre;
		}
		
		public BinaerTreNode<T> getRot(){
			return rot;
		}
		
		public void setRot(BinaerTreNode<T> rot) {
			this.rot = rot;
		}
		
		public void setHoyre(BinaerTreNode<T> hoyre) {
			this.hoyre = hoyre; 
		}
		
		public int getHoydeU() {
			return hoydeU;
		}
		
		public void setHoydeU(int hoyde) {
			this.hoydeU = hoyde;
		}
		
		public boolean erBalansert() {
		    return erBalansertRek(rot);
		}

		private boolean erBalansertRek(BinaerTreNode<T> node) {
		    if (node == null) {
		        return true;
		    }

		    int venstreHoyde = (node.getVenstre() != null) ? node.getVenstre().getHoydeU() : 0;
		    int hogreHoyde = (node.getHoyre() != null) ? node.getHoyre().getHoydeU() : 0;

		    int differanse = Math.abs(venstreHoyde - hogreHoyde);

		    if (differanse > 1) {
		        return false;
		    }
		    return erBalansertRek(node.getVenstre()) && erBalansertRek(node.getHoyre());
		}


	}