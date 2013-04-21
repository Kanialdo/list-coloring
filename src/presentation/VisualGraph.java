package presentation;

import graph.Graph;
import graph.elements.Edge;
import graph.elements.Vert;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import presentation.elements.VisualEdge;
import presentation.elements.VisualVert;

public class VisualGraph extends JPanel {

	private static final long serialVersionUID = -1520385573567591587L;

	Graph graph;

	ArrayList<VisualVert> verts = new ArrayList<VisualVert>();
	ArrayList<VisualEdge> edges = new ArrayList<VisualEdge>();

	int centerX, centerY;
	int r, vR;

	public VisualGraph() {

		centerX = 200;
		centerY = 200;
		r = 100;
		vR = 5;

		graph = new Graph();

		this.setPreferredSize(new Dimension(800, 500));

	}

	public void setNewGraph(Graph graph) {
		this.graph = graph;
		resetVisualElem();
	}

	public void resetVisualElem() {

		int quantity = graph.getVertCount();
		int i = 0;

		ArrayList<double[]> vs = new ArrayList<double[]>();
		verts.clear();
		edges.clear();

		r = 100 + 3 * quantity;
		vR = 20 - quantity / 5;
		centerX = 50 + r;
		centerY = 50 + r;

		for (Vert v : graph.getVerts()) {
			double alpha = i * 2 * Math.PI / quantity;
			double x = Math.sin(alpha) * r + centerX;
			double y = Math.cos(alpha) * r + centerY;
			i++;
			vs.add(new double[] { x, y });
			verts.add(new VisualVert(x - vR, y - vR, 2 * vR, 2 * vR, Colors
					.getColor(1)));
		}

		for (Edge e : graph.getEdges()) {
			System.out.println("Przechodze przez krawedzie");
			edges.add(new VisualEdge(vs.get(e.getV(Edge.VERT_0))[0], vs.get(e
					.getV(Edge.VERT_0))[1], vs.get(e.getV(Edge.VERT_1))[0], vs
					.get(e.getV(Edge.VERT_1))[1]));
		}

		repaint();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		for (VisualVert v : verts) {
			v.draw(g2);
		}

		for (VisualEdge e : edges) {
			e.draw(g2);
		}

	}

}
/*
 * int i = 0;
 * 
 * 
 * for (Point2D p : verts) {
 * 
 * g2.setColor(Colors.getColor(1)); g2.fill(new Ellipse2D.Double(p.getX() - vR,
 * p.getY() - vR, vR * 2, vR * 2)); g2.setColor(Color.blue); g.drawString(i +
 * "", (int) p.getX(), (int) p.getY()); i++; }
 * 
 * for (Edge e : graph.getEdges()) { g2.draw(new
 * Line2D.Double(verts.get(e.getV(Edge.VERT_0)), verts
 * .get(e.getV(Edge.VERT_1)))); }
 */
// }
// }
