package arquivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import domain.*;
import interfaces.Lista;
import controllers.DocumentoController;
import interfaces.GeometricShape;

public class RandomAcessFile {
	private static RandomAccessFile raf;
	public static void escreverRAF(File file, DocumentoController doc) {
		
		try {
			 raf = new RandomAccessFile(file,"rw");
			
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo Inexistente");
			System.exit(0);
		}
		
		try {
			Lista<GeometricShape> it = doc.getIterador();
	        GeometricShape forma;
			
	        while((forma = it.proximo()) != null) {
	        String string = forma.getClass().getSimpleName() + " " + forma.toStringArq();
	        String[] parts = string.split(" ");
	        
	        if(parts[0].equals("Point")){
	        	raf.writeByte(1);
				raf.writeInt(Integer.valueOf(parts[1]));
				raf.writeInt(Integer.valueOf(parts[2]));
			}
			else if(parts[0].equals("Line")){
				raf.writeByte(2);
				raf.writeInt(Integer.valueOf(parts[1]));
				raf.writeInt(Integer.valueOf(parts[2]));
				raf.writeInt(Integer.valueOf(parts[3]));
				raf.writeInt(Integer.valueOf(parts[4]));
			}
			else if(parts[0].equals("Square")) {
				raf.writeByte(3);
				raf.writeInt(Integer.valueOf(parts[1]));
				raf.writeInt(Integer.valueOf(parts[2]));
				raf.writeInt(Integer.valueOf(parts[3]));
				raf.writeInt(Integer.valueOf(parts[4]));
			}
			else if(parts[0].equals("Rectangle")) {
				raf.writeByte(4);
				raf.writeInt(Integer.valueOf(parts[1]));
				raf.writeInt(Integer.valueOf(parts[2]));
				raf.writeInt(Integer.valueOf(parts[3]));
				raf.writeInt(Integer.valueOf(parts[4]));
			}
			else if(parts[0].equals("Circle")) {
				raf.writeByte(5);
				raf.writeInt(Integer.valueOf(parts[1]));
				raf.writeInt(Integer.valueOf(parts[2]));
				raf.writeInt(Integer.valueOf(parts[3]));
				raf.writeInt(Integer.valueOf(parts[4]));
			}
	      }
	      raf.close();
		} catch (IOException e) {
		System.out.println("Erro escrevendo no arquivo");
		}
	}
	
	public static void lerRAF(File file, DocumentoController doc) {
        
		try {
			 raf = new RandomAccessFile(file,"r");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo Inexistente");
		}
		
	 while(true) {	
		 	try {     
		      byte forma = raf.readByte();
		      if(forma == 1) {
		    	  doc.inserirFim(new Point(raf.readInt(), raf.readInt()));
		      }
		      else if(forma == 2) {
		    	  doc.inserirFim(new Line(new Point(raf.readInt(), raf.readInt()),
						  		 		   new Point(raf.readInt(), raf.readInt())));
		      }
		      else if(forma == 3) {
		    	  doc.inserirFim(new Square(new Point(raf.readInt(), raf.readInt()),
		    			  					  new Point(raf.readInt(), raf.readInt())));
		      }
		      else if(forma == 4) {
		    	  doc.inserirFim(new Rectangle(new Point(raf.readInt(), raf.readInt()), 
						  					   new Point(raf.readInt(), raf.readInt())));
		      }
		      else if(forma == 5) {
		    	  doc.inserirFim(new Circle(new Point(raf.readInt(), raf.readInt()),
		    			                     new Point(raf.readInt(), raf.readInt())));
		      }
			  } catch (EOFException e) {
				break;
			  } catch (IOException e) {
				break;
			  }
	 	}	
	 try {
	 		 raf.close();
	 	 } catch(IOException e) {
	 		 e.printStackTrace();
	 	 }
 }
}
