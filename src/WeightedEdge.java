

public class WeightedEdge<T>{

	private Vertex<T> source;
	private Vertex<T> destination;
	private T weight;

	public WeightedEdge(Vertex<T> source, Vertex<T> destination, T weight){
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public Vertex<T> getSource(){
		return this.source;
	}

	public Vertex<T> getDestination(){
		return this.destination;
	}

	public T getWeight(){
		return this.weight;
	}

	public void setSource(Vertex<T> source){
		this.source = source;
	}

	public void setDesination(Vertex<T> destination){
		this.destination = destination;
	}

	public void setWeight(T weight){
		this.weight = weight;
	}

	public String toString(){
		return "Edge ( " + this.source.toString() + " , " + this.destination.toString() + " ) Weight : " + this.weight.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof WeightedEdge))
			return false;
		WeightedEdge other = (WeightedEdge) obj;
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
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	
	

}