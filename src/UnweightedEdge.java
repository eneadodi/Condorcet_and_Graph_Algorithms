

public class  UnweightedEdge<T>{

	private Vertex<T> source;
	private Vertex<T> destination;
	private Boolean bidirectional;

	public UnweightedEdge(Vertex<T> source, Vertex<T> destination, boolean bidirectional){
		this.source = source;
		this.destination = destination;
		this.bidirectional = bidirectional;
	}

	public Vertex<T> getSource(){
		return this.source;
	}

	public Vertex<T> getDestination(){
		return this.destination;
	}

	public Boolean isBidirectional(){
		return this.bidirectional;
	}

	public void setSource(Vertex<T> source){
		this.source = source;
	}

	public void setDesination(Vertex<T> destination){
		this.destination = destination;
	}

	public void setBidirectionality(Boolean bidirectional){
		this.bidirectional = bidirectional;
	}

	public String toString(){
		String tS = "Edge ( " + this.source.toString() + " , " + this.destination.toString() + " ) Weight : " + this.bidirectional.toString();
		tS = (this.bidirectional) ? "Bidirectional " + tS : "Unidirectoinal" + tS ;
		return tS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bidirectional == null) ? 0 : bidirectional.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof UnweightedEdge))
			return false;
		UnweightedEdge other = (UnweightedEdge) obj;
		if (bidirectional == null) {
			if (other.bidirectional != null)
				return false;
		} else if (!bidirectional.equals(other.bidirectional))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}
	

}