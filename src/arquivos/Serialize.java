package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import controllers.DocumentoController;
import interfaces.Lista;
import interfaces.GeometricShape;

public class Serialize
{	
	public static void serialize(File file, DocumentoController doc) {
      try
      {
         FileOutputStream fileOut = new FileOutputStream(file);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
      
 		 Lista<GeometricShape> it = doc.getIterador();
 		 GeometricShape forma;
         
 		 while((forma = it.proximo()) != null) {
         out.writeObject(forma.getClass().getSimpleName() + " " + forma.toStringArq());
         
 		 }
 		 
         out.close();
         fileOut.close();
      } catch(IOException i) {
          i.printStackTrace();
      }
	}
}