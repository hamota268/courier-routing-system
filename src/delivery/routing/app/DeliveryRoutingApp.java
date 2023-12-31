/*created by:
Youssef Mohamed Ahmed c6
 */
package delivery.routing.app;

import static Controllers.Dijkstra.calculateShortestPath;
import Models.Graph;
import Models.City;
import Models.Road;
import java.util.ArrayList;

public class DeliveryRoutingApp {
    static City[] cities;
    static ArrayList<Road> roads;

    public static void main(String[] args) {
        
        calculateShortestPath(cityGraph(), null, null);
        
        
    }
    
    public static Graph cityGraph(){
        cities = new City[6];
        roads = new ArrayList();
        
        cities[0] = new City("Cairo");
        cities[1] = new City("Sinaii");
        cities[2] = new City("Alex");
        cities[3] = new City("Hurghada");
        cities[4] = new City("Qena");
        cities[5] = new City("Aswan");
        
        roads.add(new Road(cities[0], cities[1], 20));
        roads.add(new Road(cities[1], cities[2], 10));
        roads.add(new Road(cities[2], cities[3], 7));
        roads.add(new Road(cities[3], cities[4], 8));
        roads.add(new Road(cities[4], cities[5], 6));
        
        Graph g = new Graph(cities, roads);
        return g;
    }
    
}
