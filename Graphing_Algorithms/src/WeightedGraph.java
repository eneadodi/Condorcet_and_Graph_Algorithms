
import java.util.*;

//NOT WORKING IMPLEMENTATION. WILL LIKELY SCRAP AND RESTART TO AVOID
//SPAGHETTIFICATION
public class WeightedGraph<T>{
	
	//Adjency list will only feature Edges. Each edge will have a from and to.

	private Map<Vertex<T>, List<WeightedEdge<T>>> adjacencyList;
	private DeepCopy deepCopier = new DeepCopy();
	
	public void addVertex(T value) {
		Vertex<T> new_vertex = new Vertex<T>(value);
		ArrayList<WeightedEdge<T>> new_list = new ArrayList<WeightedEdge<T>>();
		
		this.adjacencyList.put(new_vertex,new_list);
	}
	
	public void addVertex(Vertex<T> vertex){
		ArrayList<WeightedEdge<T>> new_list = new ArrayList<WeightedEdge<T>>();
		this.adjacencyList.put(vertex,new_list);
	}
	
	public void addEdge(Vertex<T> source, Vertex<T> destination, T weight) {
		if(!this.adjacencyList.containsKey(source)) {
			this.adjacencyList.put(source, new ArrayList<WeightedEdge<T>>());
		}
		if(!this.adjacencyList.containsKey(destination)) {
			this.adjacencyList.put(destination, new ArrayList<WeightedEdge<T>>());
		}
		WeightedEdge<T> new_edge = new WeightedEdge<T>(source,destination,weight);
		this.adjacencyList.get(source).add(new_edge);
	}
	
	public void addEdge(WeightedEdge<T> edge) {
		Vertex<T> source = edge.getSource();
		Vertex<T> destination = edge.getSource();
		if(!this.adjacencyList.containsKey(source)) {
			this.adjacencyList.put(source, new ArrayList<WeightedEdge<T>>());
		}
		if(!this.adjacencyList.containsKey(destination)) {
			this.adjacencyList.put(destination, new ArrayList<WeightedEdge<T>>());
		}
		this.adjacencyList.get(source).add(edge);
	}
	
	public void removeEdge(Vertex<T> a, WeightedEdge<T> e) {
		List<WeightedEdge<T>> edges = this.adjacencyList.get(a);
		edges.remove(e);
	}
	
	public int getVertexCount() {
		return this.adjacencyList.keySet().size();
	}
	
	public boolean hasVertex(T value) {
		return this.adjacencyList.containsKey(new Vertex<T>(value));
	}
	
	public boolean hasVertex(Vertex<T> value) {
		return this.adjacencyList.containsKey((value));
	}
	
	public boolean hasEdge(Vertex<T> source, Vertex<T> destination, T weight) {
		return this.adjacencyList.get(source).contains(new WeightedEdge<T>(source,destination,weight));
	}
	
	/*
	public boolean hasEdge(Vertex<T> source, Vertex<T> destination) {
		
	}*/

	public Map<Vertex<T>, List<WeightedEdge<T>>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setadjacencyList(Map<Vertex<T>, List<WeightedEdge<T>>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public void setAllFlags(boolean t) {
		for(Vertex<T> key : this.adjacencyList.keySet()) {
			key.setFlag(t);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adjacencyList == null) ? 0 : adjacencyList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof WeightedGraph))
			return false;
		WeightedGraph other = (WeightedGraph) obj;
		if (adjacencyList == null) {
			if (other.adjacencyList != null)
				return false;
		} else if (!adjacencyList.equals(other.adjacencyList))
			return false;
		return true;
	}

	/*
	 * BFS always finds shortest path. Memory usage as Queue can become very large is a problem.
	 * The time complexity is also higher than DFS
	 * Returns the EdgeList if found from Vertex s, otherwise returns null.
	 */
	public List<WeightedEdge<T>> BFS_Search(Vertex<T> s, T d){
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
				return this.adjacencyList.get(curr_vertex);
			}
			for(WeightedEdge<T> e: this.adjacencyList.get(curr_vertex)) {
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
	public List<WeightedEdge<T>> DFS_Search(Vertex<T> s, T value){
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
				return this.adjacencyList.get(curr_vertex);
			}
			else {
				for(WeightedEdge<T> e : this.adjacencyList.get(curr_vertex)) {
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


	/*
	 * While building the WeightedEdge class, I decided to make the weight variable of generic type.
	 * 99% of the time, a double weight type is all that is needed.
	 * However, I am trying to generalize these classes as much as possible, to offer reuse in future
	 * scenarios. This increases the complexity of the task at hand, however it is also a good way to practice
	 * Java!
	 * This Comparator will be used only for the Collections.sort() method.
	 */
	class adjacencyListComparator implements Comparator<T>{ //Optimized to SIMPLY SORT the list of Weighted Edges on each Vertex.
		
		@Override
		public int compare(T arg0, T arg1) { // Currently only works for Double Integer String and List. others jsut returns 0.
			if((arg0 instanceof WeightedEdge<?>) && (arg1 instanceof WeightedEdge<?>)) {
				@SuppressWarnings("unchecked")
				WeightedEdge<T> v1 = (WeightedEdge<T>)arg0;
				@SuppressWarnings("unchecked")
				WeightedEdge<T> v2 = (WeightedEdge<T>)arg1;
				
				T argA = v1.getWeight();
				T argB = v2.getWeight();
				
				if((argA instanceof Double) && (argB instanceof Double)) {
					return Double.compare((Double)argA, (Double)argB);
				}
				else if((argA instanceof Integer) && (argB instanceof Integer)) {
					return Integer.compare((Integer)argA, (Integer)argB);
				}else if((argA instanceof String) && (argB instanceof String)) {
					String a = (String)argA;
					String b = (String)argB;
					return a.compareTo(b);
				}else if((argA instanceof List<?>) && (argB instanceof List<?>)){ // simply compares size.
					List<?> a = (List<?>)argA;
					List<?> b = (List<?>)argB;
					
					if(a.size() < b.size()) {
						return -1;
					}else if(a.size() > b.size()) {
						return 1;
					}else {
						return 0;
					}
					
				}
				else {
					return 0;
				}
			}else {
				return 0;
			}

				
		}
		
	}
	
	
	/*
	 * While building the WeightedEdge class, I decided to make the weight variable of generic type.
	 * 99% of the time, a double weight type is all that is needed.
	 * However, I am trying to generalize these classes as much as possible, to offer reuse in future
	 * scenarios. This increases the complexity of the task at hand, however it is also a good way to practice
	 * Java!
	 * This Comparator will be used only for comparing two weights to one another. So only using the compare function.
	 * Of course can be made to use Collections.sort() for a weight list.
	 */
	class WeightComparator implements Comparator<T>{

		@Override
		public int compare(T argA, T argB) {
			if(argA == null) {
				return 1;
			}
			if(argB == null) {
				return -1;
			}
			if((argA instanceof Double) && (argB instanceof Double)) {
				return Double.compare((Double)argA, (Double)argB);
			}
			else if((argA instanceof Integer) && (argB instanceof Integer)) {
				return Integer.compare((Integer)argA, (Integer)argB);
			}else if((argA instanceof String) && (argB instanceof String)) {
				String a = (String)argA;
				String b = (String)argB;
				return a.compareTo(b);
			}else if((argA instanceof List<?>) && (argB instanceof List<?>)){ // simply compares size.
				List<?> a = (List<?>)argA;
				List<?> b = (List<?>)argB;
				
				if(a.size() < b.size()) {
					return -1;
				}else if(a.size() > b.size()) {
					return 1;
				}else {
					return 0;
				}
				
			}
			else {
				return 0;
			}
		}
		
	}


	public WeightedEdge<T> smallestEdge(List<WeightedEdge<T>> edges){
		WeightComparator wc = new WeightComparator();
		WeightedEdge<T> smallest = null;
		for(WeightedEdge<T> e : edges) {
			if(smallest == null) {
				smallest = e;
			}
			else {
				if(e.getWeight() != null) {
					int order = wc.compare(e.getWeight(), smallest.getWeight());
					if(order < 0) {
						smallest = e;
					}
				}
			}
		}
		return smallest;
	}
	/*
	 * Shortest Path Algorithm between any two vertices. Where a is the starting vertex and b is the destination vertex.
	 * Returns a weighted graph where the Map is a LinkedHashMap so we can keep order in tact. This map
	 * will feature a set of vertices each with a single Weighted Edge, the edge that takes you from
	 * the source to the next destination which is also an edge which constitutes the shortest path between
	 * the two vertices.
	 */
	public WeightedGraph<T> Djikstra(Vertex<T> a, Vertex<T> b){
		/*
		 * 1A) Make a copy of the adjeancy matrix.
		 * 1) Make empty set (future versions may use a BST or better) for unvisited_vertices. Fill it with the graph's values.
		 * 2) Change all weights to null for unvisited_vertices weighted edges
		 * 3) Add new edge to WeightedEdge List of vertex 'a' which is source = a, destination = a, weight = 0.
		 * 4) Make empty set (future versions may use a BST or better) for visited_vertices
		 * 5) Iterate through vertex a edges, and find edge with lowest value. Return that edge.
		 * 6) make new weight T which is the tentative distance of previous edge to current vertex weight + weight to other vertex. This is the
		 * 	  tentative distance from A
		 * 7) If new weight is less than the previous weight connecting source to destination, remove old edge and add new edge whereas the new edge
		 * 	  is source = current vertex and destination = destination vertex. Otherwise do nothing.
		 * 8) Iterate through current vertex, find edge with lowest value. Return that edge. Push curr vertex to visited_vertices set. Add to Graph TEMP
		 * 9) Repeat steps 6-9 until destination vertex is reached. If reached, set final edge = to a Weighted edge declared out of iteration (call it edge Z)
		 * 10) Once destination vertex is reached, make a new List of Weighted Edges. Include edge Z. 
		 * 11) Make new Graph where we do the following steps:
		 * 		a) Get source of edge Z. Find that vertex in OG graph. Find edge that connects to vertex b. Add that edge and vertex to new graph
		 * 		b) Get source of edge Z. find the vertex that connects to edge G
		 */
		
		/*
		* This section simply makes a copy of the 
		*/
		WeightedGraph<T> djikstraGraph = new WeightedGraph<T>();
		Iterator it = this.adjacencyList.entrySet().iterator();
		WeightedEdge<T> initalEdge = null;
		
		while(it.hasNext()){
			//Make DEEP copy of each pair.
			Map.Entry<Vertex<T>,List<WeightedEdge<T>>> pair = (Map.Entry)it.next();

			/*A deep copy of the vertex is likely unnecassary. However I can always
			//implement a shallow copy of even reference if at the final stage
			//of the Application development there seems to be new use of a
			//deep copy.
			*/
			Vertex newVertex = pair.getKey();//(Vertex)deepCopy(pair.getKey());
			List<WeightedEdge<T>> oldEdges = pair.getValue();
			for(WeightedEdge<T> e : oldEdges){
				WeightedEdge<T> newE = (WeightedEdge<T>)this.deepCopier.deepCopy(e);
				newE.setWeight(null);
				djikstraGraph.addEdge(newE);
			}
			if(newVertex.equals(a)){
				initalEdge = new WeightedEdge<T>(newVertex,newVertex,null);
				djikstraGraph.addEdge(initalEdge);
			}
		}

		
		//Initalize List which will be iterated over and over, initalize starting tentative Distance, remove starting edge.
		List<WeightedEdge<T>> NodeEdgesOG = this.getadjacencyList().get(a);
		List<WeightedEdge<T>> NodeEdgesDjikstra = this.getadjacencyList().get(a);
		
		T tentativeDistance = initalEdge.getWeight();		
		
		int i = 0;
		for(WeightedEdge<T> e: NodeEdgesOG) {
			WeightedEdge<T> currEdge = NodeEdgesDjikstra.get(i);
			currEdge.setWeight(currEdge.getWeight().add(tentativeDistance));
		}
		
		djikstraGraph.removeEdge(a, initalEdge);
		WeightedEdge<T> smallest = djikstraGraph.findSmallestEdge();
		
		
		WeightedEdge<T> smallest = this.smallest_edge(NodeEdges);
		tentativeDistance = smallest.getWeight();
		
		//To be Continued.

	}
	
	
	
	public WeightedEdge<T> findSmallestEdge(){
		Iterator it = this.adjacencyList.entrySet().iterator();
		WeightedEdge<T> smallest = null;
		WeightComparator wc = new WeightComparator();
		while(it.hasNext()){
			//Make DEEP copy of each pair.
			Map.Entry<Vertex<T>,List<WeightedEdge<T>>> pair = (Map.Entry)it.next();
			List<WeightedEdge<T>> currEdges = pair.getValue();
			
			WeightedEdge<T> smallestComp = this.smallestEdge(currEdges);
			if(smallest == null) {
				smallest = smallestComp;
			}
			else {
				T val1 = smallest.getWeight();
				T val2 = smallestComp.getWeight();
				
				if(wc.compare(val1, val2) > 0) {
					smallest = smallestComp;
				}
				
			}
		}
		return smallest;
	}
	

	

}
