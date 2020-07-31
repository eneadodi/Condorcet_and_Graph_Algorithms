import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeightedGraph<T>{
	
	//Adjency list will only feature Edges. Each edge will have a from and to.

	private Map<Vertex<T>, List<WeightedEdge<T>>> adjacencyMatrix;
	
	public void addVertex(T value) {
		Vertex<T> new_vertex = new Vertex<T>(value);
		ArrayList<WeightedEdge<T>> new_list = new ArrayList<WeightedEdge<T>>();
		
		this.adjacencyMatrix.put(new_vertex,new_list);
	}
	
	public void addVertex(Vertex<T> vertex){
		ArrayList<WeightedEdge<T>> new_list = new ArrayList<WeightedEdge<T>>();
		this.adjacencyMatrix.put(vertex,new_list);
	}
	
	public void addEdge(Vertex<T> source, Vertex<T> destination, T weight) {
		if(!this.adjacencyMatrix.containsKey(source)) {
			this.adjacencyMatrix.put(source, new ArrayList<WeightedEdge<T>>());
		}
		if(!this.adjacencyMatrix.containsKey(destination)) {
			this.adjacencyMatrix.put(destination, new ArrayList<WeightedEdge<T>>());
		}
		WeightedEdge<T> new_edge = new WeightedEdge<T>(source,destination,weight);
		this.adjacencyMatrix.get(source).add(new_edge);
	}
	
	public void addEdge(WeightedEdge<T> edge) {
		Vertex<T> source = edge.getSource();
		Vertex<T> destination = edge.getSource();
		if(!this.adjacencyMatrix.containsKey(source)) {
			this.adjacencyMatrix.put(source, new ArrayList<WeightedEdge<T>>());
		}
		if(!this.adjacencyMatrix.containsKey(destination)) {
			this.adjacencyMatrix.put(destination, new ArrayList<WeightedEdge<T>>());
		}
		this.adjacencyMatrix.get(source).add(edge);
	}
	
	public int getVertexCount() {
		return this.adjacencyMatrix.keySet().size();
	}
	
	public boolean hasVertex(T value) {
		return this.adjacencyMatrix.containsKey(new Vertex<T>(value));
	}
	
	public boolean hasVertex(Vertex<T> value) {
		return this.adjacencyMatrix.containsKey((value));
	}
	
	public boolean hasEdge(Vertex<T> source, Vertex<T> destination, T weight) {
		return this.adjacencyMatrix.get(source).contains(new WeightedEdge<T>(source,destination,weight));
	}
	
	/*
	public boolean hasEdge(Vertex<T> source, Vertex<T> destination) {
		
	}*/

	public Map<Vertex<T>, List<WeightedEdge<T>>> getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(Map<Vertex<T>, List<WeightedEdge<T>>> adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adjacencyMatrix == null) ? 0 : adjacencyMatrix.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof WeightedGraph))
			return false;
		WeightedGraph other = (WeightedGraph) obj;
		if (adjacencyMatrix == null) {
			if (other.adjacencyMatrix != null)
				return false;
		} else if (!adjacencyMatrix.equals(other.adjacencyMatrix))
			return false;
		return true;
	}

	public WeightedGraph<T> BFS(T value){
		return new WeightedGraph<T>();
	}
	
	public WeightedGraph<T> DFS(T value){
		return new WeightedGraph<T>();
	}
	
	public WeightedGraph<T> Djikstra(Vertex<T> a, Vertex<T> b){
		return new WeightedGraph<T>();
	}
	
	public WeightedGraph<T> Djikstra(T val1, T val2){
		return new WeightedGraph<T>();
	}
	

}