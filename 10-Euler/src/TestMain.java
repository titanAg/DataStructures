//Kyle Orcutt

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class TestMain {

	public static void main(String[] args) throws FileNotFoundException {

		Graph[] g = new Graph[6];
		g[0] = readGraph("small1");
		g[1] = readGraph("small2");
		g[2] = readGraph("medium1");
		g[3] = readGraph("medium2");
		g[4] = readGraph("medium3");
		g[5] = readGraph("medium4");
		
		// This will view the adjacency list of a graph
		System.out.println(g[0]);
		
		for (int i=0; i<6; i++)
			System.out.println(isEulerian(g[i]));

	}
	
	private static boolean isEulerian(Graph graph) {	
		HashMap<String, ArrayList<String>> list = graph.getList();	
		ArrayList<String> colors = graph.getKeys();		
		ArrayList<String> neighsOfNeighs = new ArrayList<>();		
		
		for (String color : colors) {
			neighsOfNeighs.addAll(list.get(color));
		}
		
		int oddCount = 0;
		for (String color : colors) {
			int degreeCount = 0;
			for (String neigh : neighsOfNeighs) {
				if (neigh.equals(color))
					degreeCount++;
			}
			if (degreeCount % 2 == 1)
				oddCount++;
		}
		if (oddCount == 0 || oddCount == 2)
			return true; 
		
		return false;
	}
	/**
	 * This function reads a list of edges from a given filename
	 * and returns a simple Graph.
	 * DO NOT EDIT THIS METHOD.
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Graph readGraph(String filename) throws FileNotFoundException {

		FileReader f = new FileReader(filename);
		Scanner sc = new Scanner(f);

		Graph g = new Graph();
		while (sc.hasNext()) {
			String u = sc.next();
			String v = sc.next();
			g.add(u);
			g.add(v);
			g.add(u,v);
		}
		sc.close();
		return g;
	}
}
