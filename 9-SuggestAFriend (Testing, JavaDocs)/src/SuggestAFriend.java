//Kyle Orcutt

import java.util.ArrayList;
import java.util.HashMap;

public class SuggestAFriend {

	/**
	 * Given social network g and name s, returns an ArrayList of all
	 * the names that this social network would suggest s may know
	 * @param g
	 * @param s
	 */
	public static ArrayList<String> suggest(Graph g, String s) {
		// First, let's make sure name s exists in this graph g
		if (g.containsName(s) == false) {
			System.err.println(s + " does not exist in this graph");
			return null;
		}
		
		ArrayList<String> friends = g.getNbrs(s);

		ArrayList<String> commonFriends = new ArrayList<>();

		for (String friend : friends) {
			ArrayList<String> temp = g.getNbrs(friend);
			temp.remove(s);
			
			for (String t : temp) {
				commonFriends.add(t);
			}
		}

		HashMap<String,Integer> friendMap = new HashMap<>();
		Integer highest = 0;
		for (String friend : commonFriends) {
			if (friendMap.containsKey(friend) && !friends.contains(friend)) {
				Integer num = friendMap.get(friend);
				friendMap.put(friend, ++num);
				if (num > highest)
					highest = num;
			}else {
				friendMap.put(friend, 1);
			}
		}		
		
		ArrayList<String> highestCommon = new ArrayList<>();
		for (String friend : commonFriends) {
			if (friendMap.get(friend) == highest && !highestCommon.contains(friend)) {
				highestCommon.add(friend);

			}
		}
		
		return highestCommon;
	}

	
	

}
