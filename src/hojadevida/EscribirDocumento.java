
package hojadevida;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class EscribirDocumento {
    
    private static FileWriter documento;    //  Documento en la direccion que se especifique
    
    /**
     * Escribe en un documento
     * @param direccion
     * @param texto
     */
    public static void Escribir(String direccion, String texto){
        
        try{
            documento = new FileWriter(direccion, false);
            //  Crear un buffer entre java y el documento
           BufferedWriter comunicacion = new BufferedWriter(documento);
            
            for(int i = 0; i < texto.length(); i++){
                if(texto.charAt(i) != '\n'){
                    comunicacion.write(texto.charAt(i));
                }
                else{
                    comunicacion.newLine();
                }
            }
            //  Guardar los cambios en el archivo
            comunicacion.flush();
            
            documento.close();
            
        }catch(FileNotFoundException error){
            System.out.println("El sistema no encontro el documento");
            //System.out.println(error.getMessage());
        } catch (IOException error) {
            System.out.println("Error");
        }
    }
}
