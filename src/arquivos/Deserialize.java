package arquivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import domain.*;
import controllers.DocumentoController;

public class Deserialize
{
	public static void deserialize(File file, DocumentoController doc) {
      try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file)))
      {
    	 String string;
         while((string = (String) in.readObject()) != null) {
        	 
        	 String[] parts = string.split(" ");
        	 
        	 if(parts[0].equals("Point")){
					doc.inserirFim(new Point(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])));
				}
				else if(parts[0].equals("Line")){
					doc.inserirFim(new Line(new Point(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])), 
																  new Point(Integer.valueOf(parts[3]), Integer.valueOf(parts[4]))));
				}
				else if(parts[0].equals("Square")) {
					doc.inserirFim(new Square(new Point(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])),
												 new Point(Integer.valueOf(parts[3]), Integer.valueOf(parts[4]))));
				}
				else if(parts[0].equals("Rectangle")) {
					doc.inserirFim(new Rectangle(new Point(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])), 
												 new Point(Integer.valueOf(parts[3]), Integer.valueOf(parts[4]))));
				}
				else if(parts[0].equals("Circle")) {
					doc.inserirFim(new Circle(new Point(Integer.valueOf(parts[1]) , Integer.valueOf(parts[2])), 
											   new Point(Integer.valueOf(parts[3]), Integer.valueOf(parts[4]))));
				}
         }
         in.close();
      }  catch (EOFException ex){
    	    //fim da leitura aqui
      } catch (Exception ex) {
          ex.printStackTrace();
      }

}
}