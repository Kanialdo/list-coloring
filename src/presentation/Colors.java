package presentation;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Colors {

	private static ArrayList<String> colors = new ArrayList<String>();

	public static void loadColors() {

		try {

			FileInputStream fstream = new FileInputStream("colors.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			colors.clear();

			String colorCode;
			while ((colorCode = br.readLine()) != null) {
				colors.add(colorCode);
			}
			in.close();

		} catch (Exception e) {

			System.err.println("Error: "
					+ " Nie udao sie zaladowac nazw kolorow");
			System.err.println("Error: " + e.getMessage());

		}
	}

	public static Color getColor(int i) {
		return Color.decode("#" + colors.get(i));
	}
}
