

public class Vertex<T>{

	private T value;

	public Vertex(T value){
		this.value = value;
	}

	public T getValue(){
		return this.value;
	}

	public void setValue(T value){
		this.value = value;
	}

	public String toString(){
		return this.value.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vertex))
			return false;
		Vertex other = (Vertex) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}

