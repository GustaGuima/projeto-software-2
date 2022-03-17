package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import domain.*;
import interfaces.GeometricShape;
import interfaces.Lista;


public class FileController {

	public static void leitor(File file, DocumentoController doc) {
		String string;
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader(file));
			while ((string = buffRead.readLine()) != null) {
				String[] parts = string.split(" ");
				// if Point
				if (parts[0].equals("Point")) {
					doc.inserirFim(new Point(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])));
				} else if (parts[0].equals("Line")) {
					doc.inserirFim(new Line(new Point(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])),
							new Point(Integer.valueOf(parts[3]), Integer.valueOf(parts[4]))));
				} else if (parts[0].equals("Square")) {
					doc.inserirFim(new Square(new Point(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])),
							new Point(Integer.valueOf(parts[3]), Integer.valueOf(parts[4]))));
				} else if (parts[0].equals("Rectangle")) {
					doc.inserirFim(new Rectangle(new Point(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])),
							new Point(Integer.valueOf(parts[3]), Integer.valueOf(parts[4]))));
				} else if (parts[0].equals("Circle")) {
					doc.inserirFim(new Circle(new Point(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])),
							new Point(Integer.valueOf(parts[3]), Integer.valueOf(parts[4]))));
				}
			}
			buffRead.close();
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public static void escritor(File file, DocumentoController doc) {
		try {
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(file, true));
			String string;
			Lista<GeometricShape> it = doc.getIterador();
			GeometricShape forma;
			while ((forma = it.proximo()) != null) {
				string = String.format(forma.getClass().getSimpleName() + " " + forma.toStringArq() + "\r\n");
				System.out.println(forma.getClass().getSimpleName());
				buffWrite.append(string);
			}
			buffWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
