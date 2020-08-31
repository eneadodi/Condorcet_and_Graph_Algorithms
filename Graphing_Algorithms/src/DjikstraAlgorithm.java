import java.util.*;
import java.util.stream.Stream;

public class DjikstraAlgorithm<T> {

	private WeightedGraph<T> graph;
	private WeightedGraph<T> dGraph;
	private HashMap<Vertex<T>, Double> dDistance;
	private HashMap<Vertex<T>,Vertex<T>> dPrevious;
	private List<WeightedEdge<Double>> localEdges;
	private DeepCopy deepCopier = new DeepCopy();
	public DjikstraAlgorithm(WeightedGraph<Double> g) {
		this.graph = (WeightedGraph<T>)deepCopier.deepCopy(g);
		this.dGraph = initalizeDjikstraGraph();
		initalizeDandP();
	}
    
	public WeightedGraph<T> initalizeDjikstraGraph() {
		WeightedGraph<T> djikstraGraph = new WeightedGraph<T>();
		Iterator it = this.graph.getAdjacencyList().entrySet().iterator();
		WeightedEdge<T> initalEdge = null;
		
		while(it.hasNext()){
			//Make DEEP copy of each pair.
			Map.Entry<Vertex<T>,List<WeightedEdge<T>>> pair = (Map.Entry)it.next();

			/*A deep copy of the vertex is likely unnecassary. However I can always
			//implement a shallow copy of even reference if at the final stage
			//of the Application development there seems to be new use of a
			//deep copy.
			*/
			Vertex v = pair.getKey();//(Vertex)deepCopy(pair.getKey());
			List<WeightedEdge<T>> eL = pair.getValue();
			this.localEdges = (List<WeightedEdge<Double>>) Stream.of(eL,localEdges).flatMap(Collections::stream).collect
		}
		return djikstraGraph;
	}
	
	public void initalizeDandP() {
		Iterator it = this.graph.getAdjacencyList().entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<Vertex<T>,List<WeightedEdge<T>>> pair = (Map.Entry)it.next();

			/*A deep copy of the vertex is likely unnecassary. However I can always
			//implement a shallow copy of even reference if at the final stage
			//of the Application development there seems to be new use of a
			//deep copy.
			*/
			Vertex v= pair.getKey();//(Vertex)deepCopy(pair.getKey());
			List<WeightedEdge<T>> el = pair.getValue();
			
		}
	}
	
	
}
