
package InterfazHojaDeVida;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import hojadevida.EnumProfesion;
import hojadevida.EnumGenero;
import hojadevida.Persona;
import hojadevida.Utilitaria;
import hojadevida.ValidarCorreo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *  Clase PanelHoja
 * @author Anggy Arguello - Holmes Ayala
 */
public class PanelHoja extends JPanel{
    
    private JLabel jlFoto;  //  Etiqueta para foto
            
    private JLabel jlNombre;    //  Etiqueta para nombre
    
    private JLabel jlCedula;    //  Etiqueta para cedula
    
    private JLabel jlCorreo;    //  Etiqueta para correo
    
    private JLabel jlProfesion; //  Etiqueta para profesion
    
    private JLabel jlGenero;    //  Etiqueta para genero
    
    private JLabel jlNacimiento;    //  Etiqueta para nacimiento
    
    private JButton btnFoto;    //  Boton para buscar foto
    
    private JTextField  txtNombre;  //  Caja texto para el nombre
    
    private JTextField  txtCedula;  //  Caja texto para la cedula
    
    private JTextField  txtCorreo;  //  Caja texto para el correo
    
    private JComboBox   jBoxProfesion;  //  Seleccion de la profesion
    
    private JRadioButton rbMasculino;   //  boton de radio para masculino
    
    private JRadioButton rbFemenino;    //  boton de radio para femenino
    
    private ButtonGroup grupoGenero;    //  Gestion de botones de genero
    
    private JButton btnAceptar; //  Boton de aceptar hoja de vida
    
    private JDateChooser calendario;    // Calendario para agregar nacimiento
    
    private VentanaPrincipal ventanaPrincipal;  //  Objeto de la ventana principal
    
    private List<Persona> personas; //  Lista de personas/hojas de vida

    /**
     * Constructor
     * @param ventanaPrincipal 
     */
    public PanelHoja(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        configurarPanel();
        agregarElementos();
    }
    
    /**
     * Configurar el panel
     */
    public void configurarPanel(){
        setLayout(null);
        setBackground(Color.WHITE);
    }
    
    /**
     * Agregar a el panel los elementos
     */
    public void agregarElementos(){
        
        obtenerPersonas();
        
         Font fuente = new Font("Calibri", Font.PLAIN, 30);
        
         int largo = 250;
         int alto = 70;
         int puntoX = 20;
         int puntoY = 178;
         
        jlFoto = new JLabel(new ImageIcon("Icono/Foto.png"));
        jlFoto.setBounds(400, 20, 128, 128);
        jlFoto.setFont(fuente);
        add(jlFoto);
        
        jlNombre = new JLabel("Nombre:");
        jlNombre.setBounds(puntoX, puntoY, largo, alto);
        jlNombre.setFont(fuente);
        add(jlNombre);
        
        jlCedula = new JLabel("Cedula:");
        jlCedula.setBounds(puntoX, puntoY + alto, largo+100, alto);
        jlCedula.setFont(fuente);
        add(jlCedula);
        
        jlCorreo = new JLabel("Correo:");
        jlCorreo.setBounds(puntoX, puntoY + alto*2, largo+largo, alto);
        jlCorreo.setFont(fuente);
        add(jlCorreo);
        
        jlProfesion = new JLabel("Profesion:");
        jlProfesion.setBounds(puntoX, puntoY + alto*3, largo+largo, alto);
        jlProfesion.setFont(fuente);
        add(jlProfesion);
        
        jlGenero = new JLabel("Genero:");
        jlGenero.setBounds(puntoX, puntoY + alto*4, largo+largo, alto);
        jlGenero.setFont(fuente);
        add(jlGenero);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(puntoX+largo-50, puntoY, largo+largo, alto-10);
        txtNombre.setFont(fuente);
        add(txtNombre);
        
        txtCedula = new JTextField();
        txtCedula.setBounds(puntoX+largo-50, puntoY+alto, largo+largo, alto-10);
        txtCedula.setFont(fuente);
        add(txtCedula);
        
        txtCorreo = new JTextField();
        txtCorreo.setBounds(puntoX+largo-50, puntoY+alto*2, largo+largo, alto-10);
        txtCorreo.setFont(fuente);
        add(txtCorreo);
        
        jBoxProfesion = new JComboBox(EnumProfesion.values());
        jBoxProfesion.setBounds(puntoX+largo-50, puntoY+alto*3, largo+largo, alto-10);
        jBoxProfesion.setFont(fuente);
        add(jBoxProfesion);
        
        rbMasculino = new JRadioButton("Masculino");
        rbMasculino.setBounds(puntoX+largo-50, puntoY+alto*4, largo-30, alto-10);
        rbMasculino.setFont(fuente);
        
        rbFemenino = new JRadioButton("Femenino");
        rbFemenino.setBounds(puntoX+largo+largo-50, puntoY+alto*4, largo-30, alto-10);
        rbFemenino.setFont(fuente);
        
        grupoGenero = new ButtonGroup();
        grupoGenero.add(rbMasculino);
        grupoGenero.add(rbFemenino);
        add(rbMasculino);
        add(rbFemenino);
        
        btnFoto = new JButton("Agregar Foto");
        btnFoto.addActionListener(new EscucharBoton());
        btnFoto.setBounds(100, 64, 200, alto-20);
        btnFoto.setFont(fuente);
        add(btnFoto);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new EscucharBoton());
        btnAceptar.setBounds(400 - (largo-30)/2, puntoY+alto*6+20, largo-30, alto-10);
        btnAceptar.setFont(fuente);
        add(btnAceptar);
        
        jlNacimiento =  new JLabel("Fecha nacimiento:");
        jlNacimiento.setBounds(puntoX, puntoY + alto*5, largo+largo, alto);
        jlNacimiento.setFont(fuente);
        add(jlNacimiento);
        
        Font fuenteCal = new Font("Calibri", Font.PLAIN, 20);
        calendario = new JDateChooser("dd/MM/yyyy", "##/##/####", '-');
        Calendar auxiliarMinimo = new GregorianCalendar(1970, Calendar.JANUARY, 1);
        Calendar auxiliarMaximo = new GregorianCalendar(2017, Calendar.MAY, 1);
        calendario.setMinSelectableDate(auxiliarMinimo.getTime());
        calendario.setMaxSelectableDate(auxiliarMaximo.getTime());
        calendario.setFont(fuenteCal);
         
        calendario.setBounds(400 - (largo-30)/2, puntoY+alto*5+20, largo-30, alto-20);
        add(calendario);
    }
    
    /**
     * Buscar documento con las hojas de vida ya registradas
     */
    public void obtenerPersonas(){
        personas = new ArrayList<Persona>();
        
        String texto = "";
        try {
            texto = Utilitaria.leer("Documento/Datos.txt");
        } catch (IOException error) {
            error.getMessage();
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
    
    /**
     * Escuchar boton de aceptar
     */
    class EscucharBoton implements ActionListener{

        /**
         * Metodo de escucha
         * @param evento 
         */
        @Override
        public void actionPerformed(ActionEvent evento) {
            if(evento.getActionCommand().equals("Agregar Foto")){
                JFileChooser selec = new JFileChooser();
                selec.showOpenDialog(null);
                //jlFoto.setIcon(new ImageIcon(selec.getCurrentDirectory()));
                //System.out.println(selec.getCurrentDirectory());
            }
            else if(evento.getActionCommand().equals("Aceptar")){
                if(validarDatos()){
                    EnumGenero genero;
                    if(rbMasculino.isSelected()){
                        genero = EnumGenero.Masculino;
                    }
                    else{
                        genero = EnumGenero.Femenino;
                    }
                    Persona persona = new Persona(txtNombre.getText().trim(), Double.parseDouble(txtCedula.getText().trim()), 
                          txtCorreo.getText().trim(), (EnumProfesion)jBoxProfesion.getSelectedItem(), genero, calendario.getDate());
                    Utilitaria.Escribir(persona.toString(), "Documento/Datos.txt");
                    ventanaPrincipal.getDialogoTabla().agregarUnaPersona(persona);
                    //System.out.println(persona.toString());
                    //  Vaciar Todo
                    txtNombre.setText("");
                    txtCedula.setText("");
                    txtCorreo.setText("");
                    jBoxProfesion.setSelectedIndex(0);
                    rbMasculino.setSelected(false);
                    rbFemenino.setSelected(false);
                    calendario.setDate(null);
                    JOptionPane.showMessageDialog(null, "Su hoja de vida ha sido agregada", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        /**
         * Validar que los datos sean validos
         * @return 
         */
        public boolean validarDatos(){
            jlNombre.setForeground(Color.BLACK);
            jlCedula.setForeground(Color.BLACK);
            jlCorreo.setForeground(Color.BLACK);
            jlProfesion.setForeground(Color.BLACK);
            jlGenero.setForeground(Color.BLACK);
            jlNacimiento.setForeground(Color.BLACK);
            boolean validar = true;
            if(txtNombre.getText().trim().equals("") || !sinSeparador(txtNombre.getText().trim()) || txtNombre.getText().trim().length() < 3){
                validar = false;
                jlNombre.setForeground(Color.red);
            }
            if(txtCedula.getText().trim().equals("")){
                validar = false;
                jlCedula.setForeground(Color.red);
            }
            else{
                try{
                    double prueba = Double.parseDouble(txtCedula.getText().trim());
                    for(int i = 0; i < personas.size(); i++){
                        if(personas.get(i).getCedula() == Double.parseDouble(txtCedula.getText().trim())){
                            validar = false;
                            JOptionPane.showMessageDialog(null, "Una persona ya se ha registrado con ese documento.", "Error Registro", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                    }
                }catch(NumberFormatException error){
                    validar = false;
                    jlCedula.setForeground(Color.red);
                }
            }
            if(txtCorreo.getText().trim().equals("")){
                validar = false;
                jlCorreo.setForeground(Color.red);
            }
            else{
                String auxiliar = ValidarCorreo.validar(txtCorreo.getText().trim());
                if(!auxiliar.equals("correcto")){
                    validar = false;
                    jlCorreo.setForeground(Color.red);
                    JOptionPane.showMessageDialog(null, ""+auxiliar, "Error Correo", JOptionPane.WARNING_MESSAGE);
                }
            }
            if(jBoxProfesion.getSelectedItem().equals(EnumProfesion.Seleccione)){
                validar = false;
                jlProfesion.setForeground(Color.red);
            }
            if(!rbMasculino.isSelected() && !rbFemenino.isSelected()){
                validar = false;
                jlGenero.setForeground(Color.red);
            }
            if(calendario.getDate() == null){
                validar = false;
                jlNacimiento.setForeground(Color.red);
            }
            return validar;
        }

    }

    /**
     * Metodo que valida que no contenga el punto y coma
     * @param texto
     * @return 
     */
    public boolean sinSeparador(String texto){
        for(int i = 0; i < texto.length(); i++){
            if(texto.charAt(i) == ';'){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Obtener lista de perosonas
     * @return 
     */
    public List<Persona> getPersonas() {
        return personas;
    }

    /**
     * Cambiar lista de personas
     * @param personas 
     */
    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
}

