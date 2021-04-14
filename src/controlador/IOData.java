/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;

/**
 *
 * @author daw-B
 */
public class IOData {
    
    
    //leer fichero binario
    public static ArrayList<Cliente> cargarClientes(){
        ArrayList<Cliente> vCliente = new ArrayList();
        String ruta = "Clientes.dat";
        File f = new File(ruta);
        
        
        //crear fichero si no existe
        if (!f.exists()) {
            
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(IOData.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        //leer fichero
        try (FileInputStream fi = new FileInputStream(f);
        ObjectInputStream leer = new ObjectInputStream(fi);){
            
            vCliente = (ArrayList<Cliente>) leer.readObject();
            
        } catch (IOException ex) {
            System.out.println("Error1");
        } catch (ClassNotFoundException ex) {
           System.out.println("Error2");
        }
        
      //devuelve el vector  
      return vCliente;
    }
    
    public static void escribirClientes(ArrayList<Cliente> vClientes){
        String ruta = "Clientes.dat";
        File f = new File(ruta);
        
        //crear fichero si no existe
        if (!f.exists()) {
            
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(IOData.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        try ( FileOutputStream fo = new FileOutputStream(f);
        ObjectOutputStream escribir = new ObjectOutputStream(fo);){
            
            escribir.writeObject(vClientes); 
            
        } catch (IOException ex) {
           System.out.println("Error3");
        }
    }
    
}
