package graph.elements;

public class Edge implements Comparable<Edge> {

	public static final byte VERT_0 = 0;
	public static final byte VERT_1 = 1;

	private int v1, v2;

	public Edge(int v1, int v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	public int getV(int type) {
		if (type == VERT_0) {
			return v1;
		} else {
			return v2;
		}
	}

	@Override
	public int compareTo(Edge o) {
		if (v1 > o.v1) {
			return 1;
		} else if (v1 == o.v1) {
			if (v2 > o.v2) {
				return 1;
			} else if (v2 == o.v2) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}