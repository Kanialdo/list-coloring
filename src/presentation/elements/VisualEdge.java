package presentation.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class VisualEdge {

	double x1, y1, x2, y2;

	public VisualEdge(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.draw(new Line2D.Double(x1, y1, x2, y2));
	}
}
