
package hojadevida;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class LeerDocumento {
     
    private static FileReader documento;    //  Documento en la direccion que se especifique
    
    private static String linea;    //  Lee linea por linea del texto
    
    private static String texto;    //  Texto que retorna
    
    /**
     * Retorna el Texto que se encontro en el documento
     * @param direccion
     * @return texto
     */
    public static String leer(String direccion){
        
        try{
            documento = new FileReader(direccion);
            //  Crear un buffer entre java y el documento
            BufferedReader comunicacion = new BufferedReader(documento);

            texto = "";
            linea = "";
            
            //  Mientras la linea no sea nula
            while(linea != null){
                // Leer linea del documento
                linea = comunicacion.readLine();
                if(linea != null){
                    texto += linea + "\n";
                }
            }
            
            documento.close();

        }catch(FileNotFoundException error){
            System.out.println("El sistema no encontro el documento");
            //System.out.println(error.getMessage());
        } catch (IOException error) {
            System.out.println("Error");
        }finally{
            return texto;
        }
    }
}
