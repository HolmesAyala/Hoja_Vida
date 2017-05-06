
package InterfazHojaDeVida;

import hojadevida.EnumGenero;
import hojadevida.EnumProfesion;
import hojadevida.Utilitaria;
import java.util.Date;
import hojadevida.Persona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class EjecutarInterfaz {

    public EjecutarInterfaz() {
        //VentanaPrincipal venta = new VentanaPrincipal();
        /*
        Utilitaria.Escribir("Hola\nModifique su texto", "Documento/Datos.txt");
        
        String fecha = Utilitaria.fechaDate(new Date());
        System.out.println(fecha);
        
        Date fecha2 = Utilitaria.fechaString(fecha);
        System.out.println(fecha2);
        */
        /*
        Persona persona = new Persona("Holmes", 1031173405, "holmes@gmail.com", EnumProfesion.Profesor, EnumGenero.Masculino, new Date());
        String datos = "";
        datos += persona.toString();
        persona = new Persona("Anggy", 1073525066, "anggy@gmail.com", EnumProfesion.Veterinario, EnumGenero.Femenino, new Date());
        datos += persona.toString();
        Utilitaria.Escribir(datos, "Documento/Datos.txt");
        */
        
        //  Leer Personas
        List<Persona> personas = new ArrayList<Persona>();
        
        String texto = "";
        try {
            texto = Utilitaria.leer("Documento/Datos.txt");
        } catch (IOException ex) {
            Logger.getLogger(EjecutarInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(texto);
        int contador = 0;
        for(int i = 0; i < texto.length(); i++){
            if(texto.charAt(i) == '*'){
                String linea = texto.substring(contador, i);
                String vector[] = linea.split(";");
                
                Persona persona = new Persona(vector[0], 
                                              Double.parseDouble(vector[1]), 
                                              vector[2], 
                                              EnumProfesion.valueOf(vector[3]), 
                                              EnumGenero.valueOf(vector[4]), 
                                              Utilitaria.fechaString(vector[5]));
                
                personas.add(persona);
                
                //System.out.println(persona.toString());
                contador = i + 2;
            }
        }
        
        for(int i = 0; i < personas.size(); i++){
            System.out.print(personas.get(i).toString());
        }
        
    }
    
    public static void main(String[] arg){
        EjecutarInterfaz EjecutarInterfaz = new EjecutarInterfaz();
    }
}
