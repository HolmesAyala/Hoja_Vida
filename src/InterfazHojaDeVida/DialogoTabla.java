
package InterfazHojaDeVida;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import hojadevida.EnumProfesion;
import hojadevida.EnumGenero;
import hojadevida.Utilitaria;
import hojadevida.Persona;
import java.util.Date;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class DialogoTabla extends JDialog{
    
    private JTable tablaCorreo; //  Tabla de Hojas de vida
    
    private DefaultTableModel modelo;   //  Modelo para la tabla
    
    private VentanaPrincipal ventanaPrincipal;

    /**
     * Constructor de la clase DialogoTabla
     */
    public DialogoTabla(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        configurarDialogo();
    }
    
    /**
     * Configurar la ventana de dialogo
     */
    public void configurarDialogo(){
        setTitle("Hojas de vida");
        setSize(1000, 700);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("Iconos/TablaCorreo.png");
        setIconImage(icono);
        agregarElementos();
    }
    
    /**
     * Agregar los elementos a la tabla de dialogo
     */
    public void agregarElementos(){
        
        modelo = new DefaultTableModel();
        
        //modelo.addColumn("Imagen");
        
        modelo.addColumn("Nombre");
        
        modelo.addColumn("Cedula");
        
        modelo.addColumn("Edad");
        
        modelo.addColumn("Correo");
        
        modelo.addColumn("Profesion");
        
        modelo.addColumn("Genero");
        
        tablaCorreo = new JTable(modelo);
        
        tablaCorreo.setFont(new Font("Calibri", Font.PLAIN, 20));
        
        tablaCorreo.setRowHeight(40);
        
        tablaCorreo.setEnabled(false);
        
        JScrollPane scrollTablaCorreo = new JScrollPane(tablaCorreo);
        
        scrollTablaCorreo.setBounds(20, 20, 960, 640);
        add(scrollTablaCorreo);
        
        agregarPersonas();
    }

    /**
     * Agregar las hojas de vida que esten en el archivo
     */
    public void agregarPersonas(){
        for(int i = 0; i < ventanaPrincipal.getPanelHoja().getPersonas().size(); i++){
            //  Calcular Años
            Date nacimiento = ventanaPrincipal.getPanelHoja().getPersonas().get(i).getFechaNacimiento();
            Date hoy = new Date();
            long años = hoy.getTime() - nacimiento.getTime();
            años = años/1000/60/60/24/365;
            //  Agregar una hoja de vida a la tabla
            Object persona[] = {ventanaPrincipal.getPanelHoja().getPersonas().get(i).getNombre(), 
                                            ventanaPrincipal.getPanelHoja().getPersonas().get(i).getCedula(),
                                            años,
                                            ventanaPrincipal.getPanelHoja().getPersonas().get(i).getCorreo(), 
                                            ventanaPrincipal.getPanelHoja().getPersonas().get(i).getProfesion(), 
                                            ventanaPrincipal.getPanelHoja().getPersonas().get(i).getGenero()};
            modelo.addRow(persona);
        }
    }
    
    /**
     * Agregar una hoja de vida a la tabla
     * @param hojaNueva 
     */
    public void agregarUnaPersona(Persona hojaNueva){
        //  Calcular Años
            Date nacimiento = hojaNueva.getFechaNacimiento();
            Date hoy = new Date();
            long años = hoy.getTime() - nacimiento.getTime();
            años = años/1000/60/60/24/365;
            //  Agregar una hoja de vida a la tabla
            Object persona[] = {hojaNueva.getNombre(), 
                                            hojaNueva.getCedula(),
                                            años,
                                            hojaNueva.getCorreo(), 
                                            hojaNueva.getProfesion(), 
                                            hojaNueva.getGenero()};
            modelo.addRow(persona);
    }
    
    /**
     * Obtener el modelo de la tabla
     * @return 
     */
    public DefaultTableModel getModelo() {
        return modelo;
    }

    /**
     * Cambiar el modelo de la tabla
     * @param modelo 
     */
    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
}
