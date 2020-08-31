import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

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
	
	public void setAllFlags(boolean t) {
		for(Vertex<T> key : this.adjacencyMatrix.keySet()) {
			key.setFlag(t);
		}
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

	/*
	 * BFS always finds shortest path. Memory usage as Queue can become very large is a problem.
	 * The time complexity is also higher than DFS
	 * Returns the EdgeList if found from Vertex s, otherwise returns null.
	 */
	public List<UnweightedEdge<T>> BFS_Search(Vertex<T> s, T d){
		/*
		 * 1) Initialize a Queue for the ordering.
		 * 3) add vertex s to Queue
		 * 4) while Queue is not empty, add all destination vertices from the adjacency matrix edge list.
		 * 	At the same time, check if the value of the destination vertexd is equal to the value that we 
		 * are searching for. 
		 * 5A) If vertex found, return the edge list. This means ther eis a path from vertex s to d. 
		 * 5B) if not found, return NULL This means there is no path from vertex s to d
		 * 
		 * The returning graph is the path from
		 * the starting node to the value we are searching for. This path has the additional 
		 * property of being the shortest path. 
		 */
		Queue<Vertex<T>> visitedKeys = new LinkedList<Vertex<T>>();
		
		visitedKeys.add(s);
		visitedKeys.peek().setFlag(true);
		while(!visitedKeys.isEmpty()) {
			Vertex<T> curr_vertex = visitedKeys.poll();
			
			if(curr_vertex.getValue().equals(d)) {
				this.setAllFlags(false);
				return this.adjacencyMatrix.get(curr_vertex);
			}
			for(UnweightedEdge<T> e: this.adjacencyMatrix.get(curr_vertex)) {
				if(!e.getDestination().getFlag()) {
					e.getDestination().setFlag(true);
					visitedKeys.add(e.getDestination());
				}
			}
			
		}
		
		this.setAllFlags(false);
	
		return null;
	}
	
	
	/*
	 * DFS finds a path if it exists. Memory usage is better than BFS but risks falling into
	 * a cycle if not tracking seen values. Path is not guranteed to bethe shortest. Time Complexity is better
	 * than BFS.
	 * DFS would've been easier implemented if done recursively. I assumed graphs can be larger than max memory stack size 
	 * thus i chose the iterative version. 
	 * Returns the EdgeList if found from Vertex s, otherwise returns null.
	 */
	public List<UnweightedEdge<T>> DFS_Search(Vertex<T> s, T value){
		/*
		 * 1) Initialize a Stack for the ordering.
		 * 3) add vertex s to Stack
		 * 4) while Queue is not empty, add all destination vertices from the adjacency matrix edge list.
		 * 	At the same time, check if the value of the destination vertex is equal to the value that we 
		 * are searching for. 
		 * 5A) If vertex found, return the edge list. This means there is a path from vertex s to d. 
		 * 5B) if not found, return NULL This means there is no path from vertex s to d
		 * 
		 * The returning graph is the path from
		 * the starting node to the value we are searching for. This path has the additional 
		 * prop
		return new UnweightedGraph<T>();*/
		Stack<Vertex<T>> visitedKeys = new Stack<Vertex<T>>();
		visitedKeys.push(s);
		visitedKeys.peek().setFlag(true);
		
		while(!visitedKeys.empty()) {
			Vertex<T> curr_vertex = visitedKeys.pop();
			if(curr_vertex.getValue().equals(value)) {
				this.setAllFlags(false);
				return this.adjacencyMatrix.get(curr_vertex);
			}
			else {
				for(UnweightedEdge<T> e : this.adjacencyMatrix.get(curr_vertex)) {
					if(!e.getDestination().getFlag()) {
						e.getDestination().setFlag(true);
						visitedKeys.push(e.getDestination());
					}
				}
			}
		}
		
		this.setAllFlags(false);
		return null;
	}
	
	public UnweightedGraph<T> Djikstra(Vertex<T> a, Vertex<T> b){
		return new UnweightedGraph<T>();
	}
	
	public UnweightedGraph<T> Djikstra(T val1, T val2){
		return new UnweightedGraph<T>();
	}
	
}