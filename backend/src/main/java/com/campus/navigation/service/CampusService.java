package com.campus.navigation.service;

import com.campus.navigation.model.Location;
import com.campus.navigation.model.RouteResponse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CampusService {
    // Institution-specific photographs from the institutions' public pages / campus directory.
    private static String imageFor(String id) {
        return switch (id) {
            case "dycoe" -> "https://dypakurdipune.edu.in/bridge/images/institutes_imges/dypcoe.jpg";
            case "dyiembr" -> "https://www.dypiemr.ac.in/bridge/images/slider_images/collegenamephoto.JPG";
            case "ybppoly" -> "https://dypakurdipune.edu.in/bridge/images/institutes_imges/YBPPbuilding23.png";
            case "dypiu" -> "https://dypakurdipune.edu.in/bridge/images/institutes_imges/DYPIUMainGate1.jpg";
            case "dycoph" -> "https://dypakurdipune.edu.in/bridge/images/institutes_imges/colg-pharmacy.png";
            case "dyioph" -> "https://dypakurdipune.edu.in/bridge/images/institutes_imges/institute-of-pharma.png";
            case "dycoarc" -> "https://dypakurdipune.edu.in/bridge/images/institutes_imges/architechure.png";
            case "dycaac" -> "https://www.collegebatch.com/static/clg-gallery/dr-d-y-patil-college-of-applied-arts-crafts-pune-292544.jpg";
            case "dycabm" -> "https://dypakurdipune.edu.in/bridge/images/institutes_imges/agriculture.png";
            case "dymcam" -> "https://dypakurdipune.edu.in/bridge/images/institutes_imges/computer-application.png";
            case "dypgdm" -> "https://dypakurdipune.edu.in/bridge/images/institutes_imges/pgdmi.png";
            case "dyacsjc" -> "https://edunext-main-storage-cf.edunexttechnologies.com/dypjrc/school___static/1712119715643_college_Building.jpg";
            case "dydschool" -> "https://dypakurdipune.edu.in/bridge/images/institutes_imges/dnyanashanti.png";
            case "dypacad" -> "https://cache.careers360.mobi/media/colleges/social-media/media-gallery/25397/2020/2/6/Campus%20view%20of%20DY%20Patil%20International%20University%20Akurdi_Campus-view.jpg";
            default -> "https://dypakurdipune.edu.in/bridge/images/institutes_imges/DYPIUMainGate1.jpg";
        };
    }
    private final Map<String, Location> locations = new LinkedHashMap<>();
    private final Map<String, Map<String, Integer>> graph = new HashMap<>();

    public CampusService() {
        add("dycoe", "D. Y. Patil College of Engineering, Akurdi", "DYCOE", "Engineering", "engineering", "Engineering college offering undergraduate and postgraduate programmes.", "Computer, IT, Mechanical, Civil, E&TC, Electrical", "Main Engineering Block", "G+3", "Computer Lab, Electronics Lab, Mechanics Lab, Physics Lab, Chemistry Lab", "Library, Auditorium, Canteen, Sports Complex, Hostel", 20, 30, 0);
        add("dyiembr", "Dr. D. Y. Patil Institute of Engineering, Management and Research", "DYPIEMR", "Engineering", "engineering", "Institute offering engineering, management and research programmes.", "Engineering, Management, Research", "Innovation Block", "G+4", "Robotics Lab, Data Science Lab, Business Simulation Lab", "Library, Seminar Hall, Cafeteria, Gym", 35, 20, 0);
        add("ybppoly", "Y. B. Patil Polytechnic", "YBP", "Engineering", "engineering", "Polytechnic institute offering diploma programmes in engineering.", "Mechanical, Civil, Electrical, Electronics", "Polytechnic Block", "G+2", "Workshop, Electrical Lab, Civil Lab", "Library, Canteen, Playground", 10, 55, 0);
        add("dypiu", "D. Y. Patil International University", "DYPIU", "University", "engineering", "Private university offering programmes across multiple disciplines.", "Engineering, Management, Law, Liberal Arts", "University Academic Block", "G+6", "Research Labs, Language Lab, Computer Centre", "Central Library, Hostel, Sports Stadium, Amphitheatre", 35, 35, 0);
        add("dycoph", "Dr. D. Y. Patil College of Pharmacy", "DYCOP", "Pharmacy", "pharmacy", "Pharmacy college offering pharmaceutical science programmes.", "Pharmaceutics, Pharmacology, Pharmaceutical Chemistry", "Pharmacy Building", "G+3", "Pharmaceutics Lab, Pharmacology Lab, Chemistry Lab, Microbiology Lab", "Library, Herbal Garden, Animal House", 45, 15, 0);
        add("dyioph", "Dr. D. Y. Patil Institute of Pharmacy", "DYIOP", "Pharmacy", "pharmacy", "Institute focused on education in pharmaceutical sciences.", "Pharmacy Practice, Quality Assurance", "Pharmacy Annex", "G+2", "Pharmacy Practice Lab, Instrumentation Lab", "Library, Seminar Room", 55, 10, 0);
        add("dycoarc", "D. Y. Patil College of Architecture", "DYCA", "Architecture", "architecture", "Architecture college with design studios and creative learning spaces.", "Architecture, Urban Design", "Architecture Block", "G+2", "Design Studio, Computer Lab, Model Making Workshop", "Library, Exhibition Hall, Material Museum", 60, 25, 0);
        add("dycaac", "Dr. D. Y. Patil College of Applied Arts and Crafts", "DYCAAC", "Architecture", "architecture", "College offering applied arts and crafts programmes.", "Applied Art, Visual Communication, Crafts", "Arts and Crafts Centre", "G+1", "Art Studio, Digital Design Lab, Pottery Workshop", "Gallery, Craft Museum", 50, 45, 0);
        add("dycabm", "D. Y. Patil College of Agriculture Business Management", "DYCABM", "Management", "management", "Institute combining agriculture studies with business management.", "Agribusiness, Farm Management, Food Processing", "Agri-Business Block", "G+2", "Soil Lab, Food Processing Lab, Computer Lab", "Library, Model Farm, Canteen", 45, 55, 0);
        add("dymcam", "D. Y. Patil Institute of Master of Computer Applications and Management", "DYMCA", "Management", "management", "Institute offering computer applications and management programmes.", "Computer Applications, Business Administration", "Management Block", "G+3", "Software Lab, Networking Lab, Business Lab", "Library, Conference Hall, Cafeteria", 40, 40, 0);
        add("dypgdm", "D. Y. Patil PGDM Institute", "DYPGDM", "Management", "management", "Institute offering postgraduate diploma programmes in management.", "Marketing, Finance, HR, Operations", "PGDM Tower", "G+5", "Analytics Lab, Finance Lab, Behavioural Lab", "Library, Auditorium, Business Centre", 55, 60, 0);
        add("dyacsjc", "Dr. D. Y. Patil Arts, Commerce and Science Junior College", "DYACSJC", "School", "school", "Junior college offering Arts, Commerce and Science streams.", "Science, Commerce, Arts", "Junior College Building", "G+3", "Science Lab, Computer Lab, Language Lab", "Library, Playground, Auditorium", 65, 40, 0);
        add("dydschool", "D. Y. Patil Dnyanshanti School", "DYDS", "School", "school", "School offering primary and secondary education.", "Primary, Secondary", "School Block", "G+2", "Science Lab, Computer Lab, Maths Lab", "Library, Playground, Activity Centre", 60, 55, 0);
        add("dypacad", "D. Y. Patil Academy", "DYPA", "School", "school", "Academy offering pre-primary and primary education.", "Pre-Primary, Primary", "Academy Wing", "G+1", "Early Learning Lab, Computer Lab", "Indoor Play Area, Library, Art Room", 70, 50, 0);

        // Sample walking-distance graph transcribed from the supplied frontend prototype.
        // Replace these estimates with verified campus walking measurements before deployment.
        connect("dycoe", "dyiembr", 300); connect("dycoe", "ybppoly", 500); connect("dycoe", "dypiu", 200);
        connect("dyiembr", "dypiu", 250); connect("dyiembr", "dycoph", 400); connect("dyiembr", "dymcam", 350);
        connect("ybppoly", "dycoph", 300); connect("ybppoly", "dycaac", 450);
        connect("dypiu", "dymcam", 150); connect("dypiu", "dycabm", 400);
        connect("dycoph", "dyioph", 200); connect("dycoph", "dycoarc", 500);
        connect("dyioph", "dycoarc", 300); connect("dycoarc", "dycaac", 250); connect("dycoarc", "dyacsjc", 600);
        connect("dycaac", "dyacsjc", 300); connect("dycaac", "dydschool", 400);
        connect("dycabm", "dymcam", 300); connect("dycabm", "dypgdm", 250); connect("dymcam", "dypgdm", 200);
        connect("dypgdm", "dyacsjc", 350); connect("dypgdm", "dypacad", 500);
        connect("dyacsjc", "dydschool", 200); connect("dydschool", "dypacad", 300);
    }

    private void add(String id, String name, String shortName, String category, String badge,
                     String description, String departments, String building, String floors,
                     String labs, String facilities, int x, int y, int floor) {
        locations.put(id, new Location(id, name, shortName, category, badge, description,
                departments, imageFor(id), building, floors, labs, facilities, x, y, floor));
        graph.put(id, new HashMap<>());
    }

    private void connect(String a, String b, int distance) {
        graph.get(a).put(b, distance);
        graph.get(b).put(a, distance);
    }

    public List<Location> getLocations() { return new ArrayList<>(locations.values()); }

    public RouteResponse findShortestRoute(String start, String end) {
        if (!locations.containsKey(start) || !locations.containsKey(end))
            throw new IllegalArgumentException("Unknown starting point or destination.");
        if (start.equals(end))
            return new RouteResponse(List.of(locations.get(start)), 0, "You are already at the destination.");

        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        Set<String> visited = new HashSet<>();
        PriorityQueue<NodeDistance> queue = new PriorityQueue<>(Comparator.comparingInt(NodeDistance::distance));
        for (String id : locations.keySet()) distances.put(id, Integer.MAX_VALUE);
        distances.put(start, 0);
        queue.add(new NodeDistance(start, 0));

        while (!queue.isEmpty()) {
            NodeDistance current = queue.poll();
            if (!visited.add(current.id())) continue;
            if (current.id().equals(end)) break;
            for (var edge : graph.get(current.id()).entrySet()) {
                String next = edge.getKey();
                int candidate = distances.get(current.id()) + edge.getValue();
                if (candidate < distances.get(next)) {
                    distances.put(next, candidate);
                    previous.put(next, current.id());
                    queue.add(new NodeDistance(next, candidate));
                }
            }
        }
        if (distances.get(end) == Integer.MAX_VALUE)
            throw new IllegalArgumentException("No walking route found between these locations.");
        LinkedList<Location> path = new LinkedList<>();
        String step = end;
        while (step != null) { path.addFirst(locations.get(step)); step = previous.get(step); }
        return new RouteResponse(path, distances.get(end), "Shortest route calculated using Dijkstra's Algorithm.");
    }

    private record NodeDistance(String id, int distance) {}
}
