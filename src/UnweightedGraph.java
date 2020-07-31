import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnweightedGraph<T>{

	private Map<Vertex<T>, List<UnweightedEdge<T>>> adjacencyMatrix;

	public void addVertex(T value) {
		Vertex<T> new_vertex = new Vertex<T>(value);
		ArrayList<UnweightedEdge<T>> new_list = new ArrayList<UnweightedEdge<T>>();
		
		this.adjacencyMatrix.put(new_vertex,new_list);
	}
	
	public void addVertex(Vertex<T> vertex){
		ArrayList<UnweightedEdge<T>> new_list = new ArrayList<UnweightedEdge<T>>();
		this.adjacencyMatrix.put(vertex,new_list);
	}
	
	public void addEdge(Vertex<T> source, Vertex<T> destination, Boolean bidirectional) {
		
		if(!this.hasVertex(source)) {
			this.addVertex(source);
		}
		
		if(!this.hasVertex(destination)) {
			this.addVertex(destination);
		}
		
		this.adjacencyMatrix.get(source).add(new UnweightedEdge<T>(source,destination,bidirectional));
		if(bidirectional) {
			this.adjacencyMatrix.get(destination).add(new UnweightedEdge<T>(destination,source,bidirectional));
		}
	}
	
	public void addEdge(UnweightedEdge<T> edge) {
		Vertex<T> source = edge.getSource();
		Vertex<T> destination = edge.getDestination();
		
		if(!this.hasVertex(source)) {
			this.addVertex(source);
		}
		
		if(!this.hasVertex(destination)) {
			this.addVertex(destination);
		}
		
		this.adjacencyMatrix.get(source).add(edge);
		if(edge.isBidirectional()) {
			this.adjacencyMatrix.get(destination).add(edge);
		}
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
	
	public boolean hasEdge(Vertex<T> source, Vertex<T> destination, Boolean bidirectional) {
		return this.adjacencyMatrix.get(source).contains(new UnweightedEdge<T>(source,destination,bidirectional));
	}
	
	/*
	public void hasEdge(Vertex<T> source, Vertex<T> destination) {
		
	}*/

	public Map<Vertex<T>, List<UnweightedEdge<T>>> getAdjacencyMatrix() {
		return this.adjacencyMatrix;
	}

	public void setAdjacencyMatrix(Map<Vertex<T>, List<UnweightedEdge<T>>> adjacencyMatrix) {
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
		if (!(obj instanceof UnweightedGraph))
			return false;
		UnweightedGraph other = (UnweightedGraph) obj;
		if (adjacencyMatrix == null) {
			if (other.adjacencyMatrix != null)
				return false;
		} else if (!adjacencyMatrix.equals(other.adjacencyMatrix))
			return false;
		return true;
	}

	public UnweightedGraph<T> BFS(T value){
		return new UnweightedGraph<T>();
	}
	
	public UnweightedGraph<T> DFS(T value){
		return new UnweightedGraph<T>();
	}
	
	public UnweightedGraph<T> Djikstra(Vertex<T> a, Vertex<T> b){
		return new UnweightedGraph<T>();
	}
	
	public UnweightedGraph<T> Djikstra(T val1, T val2){
		return new UnweightedGraph<T>();
	}
	
}