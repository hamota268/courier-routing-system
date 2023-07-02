/*created by:
Youssef Mohamed Ahmed c6
 */

package Models;

import java.util.ArrayList;

public class Graph {
    private City[] cities;
    private ArrayList<Road> roads;

    public Graph(City[] cities, ArrayList<Road> roads) {
        this.cities = cities;
        this.roads = roads;
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public ArrayList<Road> getRoads() {
        return roads;
    }

    public void setRoads(ArrayList<Road> roads) {
        this.roads = roads;
    }
    
}
