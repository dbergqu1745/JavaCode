package Final_Exam;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Final Exam - hashmap CityNeighbors
 * due 12/14/17
 */

public class CityNeighbors {

	public static HashMap<String, ArrayList<String>> createMap(HashMap<String, ArrayList<String>> map) {

		map.put("ATL", new ArrayList<String>());
		map.get("ATL").add("MKE");
		map.get("ATL").add("Chicago");

		map.put("Chicago", new ArrayList<String>());
		map.get("Chicago").add("Minneapolis");

		map.put("MKE", new ArrayList<String>());
		map.get("MKE").add("Chicago");

		map.put("Minneapolis", new ArrayList<String>());

		return map;
	}

	public static void findNeighbors(HashMap<String, ArrayList<String>> map, String city) {
		if (map.containsKey(city)) {
			System.out.print(city + " --> ");

			if (map.get(city).isEmpty()) {
				System.out.print("No connecting cities");

			} else {

				for (String s : map.get(city)) {
					System.out.print(s + " ");
				}
			}
			System.out.println();
		} else {
			System.out.println(city + " not present in map");
		}
	}

	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		map = CityNeighbors.createMap(map);

		findNeighbors(map, "ATL");
		findNeighbors(map, "Chicago");
		findNeighbors(map, "MKE");
		findNeighbors(map, "Minneapolis");
		findNeighbors(map, "Madison");
	}
}
