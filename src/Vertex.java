

public class Vertex<T>{

	private T value;
	private boolean flag;
	
	public Vertex(T value){
		this.value = value;
		this.flag = false;
	}

	public T getValue(){
		return this.value;
	}

	public void setValue(T value){
		this.value = value;
	}

	public boolean getFlag() {
		return this.flag;
	}
	
	public void setFlag(boolean f) {
		this.flag = f;
	}
	
	public String toString(){
		return this.value.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (flag ? 1231 : 1237);
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
		if (flag != other.flag)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}


	
}

