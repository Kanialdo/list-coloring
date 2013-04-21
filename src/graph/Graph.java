package graph;

import graph.elements.Edge;
import graph.elements.Vert;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Graph {

	protected ArrayList<Vert> verts;
	protected ArrayList<Edge> edges;

	protected String log;

	Random r = new Random();

	public Graph() {
		log = new String();
		verts = new ArrayList<>();
		edges = new ArrayList<>();
	}

	public int getVertCount() {
		return verts.size();
	}

	public void addVert(int id) {
		verts.add(new Vert(id));
	}

	public void addEdge(int id1, int id2) {
		edges.add(new Edge(id1, id2));
	}

	public ArrayList<Vert> getVerts() {
		return verts;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public String getLog() {
		return log;
	}

	public void generate(int v, int e) {

		verts = new ArrayList<>();
		edges = new ArrayList<>();

		log = new String();

		for (int i = 0; i < v; i++) {
			verts.add(new Vert(i));
			System.out.println("Dodano wierzcholek o id : " + i);
			log += "Vert : " + i + "\n";
		}

		log += "\n -------- \n\n";

		for (int j = 0; j < e; j++) {
			int v1, v2;
			v1 = r.nextInt(v);
			v2 = r.nextInt(v);
			edges.add(new Edge(v1, v2));
			System.out.println("Dodano krawedz miedzy : " + v1 + " - " + v2);
			log += "Edge : " + v1 + " - " + v2 + "\n";

		}

		Collections.sort(edges);
	}
}
