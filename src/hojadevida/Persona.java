
package hojadevida;

import java.util.Date;
import javax.swing.JLabel;
import hojadevida.Utilitaria;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class Persona {
    
    private JLabel foto;    //  La foto de la persona se agrega como icono al JLabel
    
    private String nombre;  //  Nombre de maximo 30 caracteres
    
    private double cedula;  //  Cedula
    
    private String correo;  //  Correo validado
    
    private EnumProfesion profesion;    //  Atributo Enum de Profesion
    
    private EnumGenero genero;  //  Genero masculino o femenino
    
    private Date fechaNacimiento;

    /**
     * Constructor
     * @param foto
     * @param nombre
     * @param cedula
     * @param correo
     * @param profesion
     * @param genero 
     */
    public Persona(String nombre, double cedula, String correo, EnumProfesion profesion, EnumGenero genero, Date fechaNacimiento) {
        this.foto = foto;
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.profesion = profesion;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString(){
        String datos = "";
        datos += nombre+";";
        datos += String.valueOf(cedula)+";";
        datos += correo+";";
        datos += profesion+";";
        datos += genero+";";
        datos += Utilitaria.fechaDate(fechaNacimiento)+";*\n";
        return datos;
    }
    
    /**
     * Obtener la foto
     * @return JLabel
     */
    public JLabel getFoto() {
        return foto;
    }

    /**
     * Cambiar la foto
     * @param foto 
     */
    public void setFoto(JLabel foto) {
        this.foto = foto;
    }

    /**
     * Obtener el nombre de la persona
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambiar el nombre de la persona
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener la cedula
     * @return double
     */
    public double getCedula() {
        return cedula;
    }

    /**
     * Cambiar la cedula
     * @param cedula 
     */
    public void setCedula(double cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtener el correo
     * @return String
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Cambiar el correo
     * @param correo 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtener la profesion
     * @return EnumProfesion
     */
    public EnumProfesion getProfesion() {
        return profesion;
    }

    /**
     * Cambiar la profesion
     * @param profesion 
     */
    public void setProfesion(EnumProfesion profesion) {
        this.profesion = profesion;
    }

    /**
     * Obtener el genero
     * @return String
     */
    public EnumGenero getGenero() {
        return genero;
    }

    /**
     * Cambiar el genero
     * @param genero 
     */
    public void setGenero(EnumGenero genero) {
        this.genero = genero;
    }
    
}
