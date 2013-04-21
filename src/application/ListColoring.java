package application;

import graph.Graph;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import presentation.Colors;
import presentation.VisualGraph;

public class ListColoring {

	MenuBar menu = new MenuBar();
	Graph graph = new Graph();
	VisualGraph vGraph = new VisualGraph();
	SideBar console = new SideBar();

	public static void main(String[] args) {

		// Wczytanie kolorów z pliku - metoda statyczna
		Colors.loadColors();

		JFrame frame = new JFrame("List Coloring");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ListColoring gp = new ListColoring();

		frame.getContentPane().add(gp.menu, BorderLayout.NORTH);
		frame.getContentPane().add(gp.vGraph, BorderLayout.CENTER);
		frame.getContentPane().add(gp.console, BorderLayout.WEST);
		frame.pack();
		frame.setVisible(true);

	}

	private class SideBar extends JPanel {

		private static final long serialVersionUID = 8510673792807772450L;
		TextArea textArea;

		public SideBar() {
			textArea = new TextArea(40, 30);
			this.add(textArea);
		}

		public void addData(String s) {
			textArea.setText(s);
		}

	}

	private class MenuBar extends JToolBar implements ActionListener {

		private static final long serialVersionUID = 1775052957458572936L;

		private JPopupMenu popup = new JPopupMenu();

		private JTextField jtfEdges = new JTextField(8);
		private JTextField jtfVerts = new JTextField(8);
		private JLabel jEdges = new JLabel("edges:");
		private JLabel jVerts = new JLabel("verts:");

		public MenuBar() {
			this.setLayout(new FlowLayout(FlowLayout.LEFT));

			jtfEdges = new JTextField(8);
			jtfVerts = new JTextField(8);
			jEdges = new JLabel("edges:");
			jVerts = new JLabel("verts:");

			JButton jbGenerate = new JButton("Generuj");
			jbGenerate.addActionListener(this);

			popup.add(new JMenuItem("Dupa"));
			this.add(popup);

			this.add(jVerts);
			this.add(jtfVerts);
			this.addSeparator();
			this.add(jEdges);
			this.add(jtfEdges);
			this.addSeparator();
			this.add(jbGenerate);
			this.addSeparator();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			graph.generate(Integer.parseInt(jtfVerts.getText()),
					Integer.parseInt(jtfEdges.getText()));
			console.addData(graph.getLog());
			vGraph.setNewGraph(graph);
		}
	}

}
