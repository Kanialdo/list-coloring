package graph.elements;

import java.util.ArrayList;

public class Vert {

	private int id;
	private ArrayList<Integer> colors;
	private int color;

	public Vert(int id) {
		this.setId(id);
	}

	public Vert(int id, ArrayList<Integer> colors) {
		this.setId(id);
		this.colors = colors;
	}

	public Vert(int id, int[] colors) {
		this.setId(id);
		for (int c : colors) {
			this.colors.add(c);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Integer> getColors() {
		return colors;
	}

	public void setColors(ArrayList<Integer> colors) {
		this.colors = colors;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

}
