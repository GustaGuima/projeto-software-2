package controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import interfaces.GeometricShape;
import interfaces.Lista;
import interfaces.Panel;

import arquivos.*;

public class DocumentoController {
	
	private ListaController<GeometricShape> lista;
	
	private ListaController<Panel> listaOuvintes;
	
	File file;
	
	
	public DocumentoController(){
		this.lista = new ListaController<GeometricShape>();
		this.listaOuvintes = new ListaController<Panel>();
	}
	
	public void inserirFim(GeometricShape forma) {
		this.lista.inserirFim(forma);
		atualizaOuvinte();
	}
	
	public Lista<GeometricShape> getIterador() {
		return this.lista.getInicio();	
	}
	
	public Integer getTamanho() {
		return this.lista.getTamanho();
	}
	
	public ListaController<GeometricShape> getListaFormas() {
        return lista;
    }
    public void setListaFormas(ListaController<GeometricShape> lista) {
        this.lista = lista;
    }
	

		public void adicionaOuvinte(Panel view) {
			listaOuvintes.inserirFim(view);
			atualizaOuvinte();
		}

		public void removeOuvinte(Panel view) {
			listaOuvintes.removerOuvinte(view);
			atualizaOuvinte();
		}
	
	public void atualizaOuvinte() {
		Lista<Panel> i = listaOuvintes.getInicio();
		Panel view;
		while ((view = (Panel) i.proximo()) != null) {
			view.reload();
		}
	}
 
	   
	   public void salvarFormas(){
		   int option = tipoArquivo();
		    if(option == 0) {
				try {
					   if(this.file == null) {
			    		String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto?", JOptionPane.INFORMATION_MESSAGE);
			    		this.file = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
			    		this.file.createNewFile();
			    		FileController.escritor(this.file, this);
			    	} else {
			    		FileController.escritor(this.file, this);
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			  }
		    
		    if(option == 1) {
		    	try {
		    	if(this.file == null) {
		    	String path = JOptionPane.showInputDialog(null,"Nome do Arquivo Serializado que deseja salvar?", JOptionPane.INFORMATION_MESSAGE);
				this.file = new File(System.getProperty("user.dir") + "/" +  path + ".ser");
				this.file.createNewFile();
				Serialize.serialize(this.file, this);
				} else {
					Serialize.serialize(file, this);
				}
				} catch(Exception e) {
					e.printStackTrace();
				}
		    }
		    
		    if(option == 2) {
		    	try {
			    if(this.file == null) {
		    	String path = JOptionPane.showInputDialog(null,"Nome do Arquivo Binario que deseja salvar?", JOptionPane.INFORMATION_MESSAGE);
				this.file = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
				this.file.createNewFile();
				RandomAcessFile.escreverRAF(this.file, this);
				} else {
					RandomAcessFile.escreverRAF(this.file, this);
				}
			    } catch(Exception e) {
					e.printStackTrace();
				}
		    }
		    
		    if(option == -1 || option == 3) {
		    	JOptionPane.showMessageDialog(null, "Não foi possivel SALVAR! o arquivo");
		    }
	   }
	   
	   public void lerFormas(){
		   int option = tipoArquivo();
			    if(option == 0) {
				String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto que deseja abrir?", JOptionPane.INFORMATION_MESSAGE);
				this.file = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
				if(!this.file.exists()) {
					JOptionPane.showMessageDialog(null, "Arquivo nao existe!");
					this.file = null;
				} else {
				lista.limparLista();
				FileController.leitor(this.file, this);
				}		
		    }
		
		    if(option == 1) {
		    	String path = JOptionPane.showInputDialog(null,"Nome do Arquivo Serializado que deseja abrir?", JOptionPane.INFORMATION_MESSAGE);
				this.file = new File(System.getProperty("user.dir") + "/" +  path + ".ser");
				if(!this.file.exists()) {
					JOptionPane.showMessageDialog(null, "Arquivo nao existe!");
					this.file = null;
				} else if(this.file.exists()) {
					lista.limparLista();
					Deserialize.deserialize(this.file, this);
				}
		    }
		
		    if(option == 2) {
		    	String path = JOptionPane.showInputDialog(null,"Nome do Arquivo Binario que deseja abrir?", JOptionPane.INFORMATION_MESSAGE);
				this.file = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
					if(!this.file.exists()) {
						JOptionPane.showMessageDialog(null, "Arquivo nao existe!");
						this.file = null;
					} else {
					lista.limparLista();
					RandomAcessFile.lerRAF(this.file, this);
					
					}		
		    }
		    
		    if(option == -1 || option == 3) {
		    	JOptionPane.showMessageDialog(null, "Nao foi possivel ABRIR! um novo Arquivo");
		    }
	   }
	   
	   public void novoArquivo(){
		   int option = tipoArquivo();
			//Arquivo Texto
		    if(option == 0) {
			try {
				String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto que deseja criar?", JOptionPane.INFORMATION_MESSAGE);
				this.file = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
				this.file.createNewFile();
				lista.limparLista();
				FileController.leitor(this.file, this);
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
		   }
			
			 //Arquivo Serializable
		    if(option == 1) {
		    	try {
					String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto que deseja criar?", JOptionPane.INFORMATION_MESSAGE);
					File newFile = new File(System.getProperty("user.dir") + "/" +  path + ".ser");
					newFile.createNewFile();
					lista.limparLista();
					Serialize.serialize(newFile, this);
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
					
		    }
		    
		    //Arquivo Bin�rio
		    if(option == 2) {
		    	try {
					String path = JOptionPane.showInputDialog(null,"Nome do Arquivo Binario que deseja criar?", JOptionPane.INFORMATION_MESSAGE);
					File newFile = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
					newFile.createNewFile();
					lista.limparLista();
					RandomAcessFile.escreverRAF(newFile, this);
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
		    }
		    
		    //Exit
		    if(option == -1 || option == 3) {
		    	JOptionPane.showMessageDialog(null, "Nao foi possivel CRIAR! um novo Arquivo");
		    }
	   }
	   
	   public void crtlZ(){
		   lista.removerFim();
	   }
	   
	   public static int tipoArquivo() {
			
			String[] options = new String[] {"Texto", "Serialize", "Binario"};
			
		    int response = JOptionPane.showOptionDialog(null, "Tipo de Arquivo?", "Options",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, options[0]);
		    
		    return response;
		}
	
}
