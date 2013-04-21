package presentation.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class VisualVert {

	private double x, y, w, h;
	private Color color;

	public VisualVert(double x, double y, double w, double h, Color color) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.color = color;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fill(new Ellipse2D.Double(x, y, w, h));
	}

}
