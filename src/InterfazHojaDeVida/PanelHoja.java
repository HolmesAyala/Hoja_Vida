
package InterfazHojaDeVida;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import javax.swing.JFileChooser;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class PanelHoja extends JPanel{
    
    private JLabel jlFoto;
            
    private JLabel jlNombre;
    
    private JLabel jlCedula;
    
    private JLabel jlCorreo;
    
    private JLabel jlProfesion;
    
    private JLabel jlGenero;
    
    private JButton btnFoto;
    
    private JTextField  txtNombre;
    
    private JTextField  txtCedula;
    
    private JTextField  txtCorreo;
    
    private JComboBox   jBoxProfesion;
    
    private JRadioButton rbMasculino;
    
    private JRadioButton rbFemenino;
    
    private ButtonGroup grupoGenero;
    
    private JButton btnAceptar;
    
    private VentanaPrincipal ventanaPrincipal;

    public PanelHoja(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        configurarPanel();
        agregarElementos();
    }
    
    public void configurarPanel(){
        setLayout(null);
        setBackground(Color.WHITE);
    }
    
    public void agregarElementos(){
        
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
        btnAceptar.setBounds(400 - (largo-30)/2, puntoY+alto*6, largo-30, alto-10);
        btnAceptar.setFont(fuente);
        add(btnAceptar);
    }
    
    class EscucharBoton implements ActionListener{

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
                          txtCorreo.getText().trim(), (EnumProfesion)jBoxProfesion.getSelectedItem(), genero, new Date());
                }
            }
        }

        boolean validarDatos(){
            jlNombre.setForeground(Color.BLACK);
            jlCedula.setForeground(Color.BLACK);
            jlCorreo.setForeground(Color.BLACK);
            jlProfesion.setForeground(Color.BLACK);
            jlGenero.setForeground(Color.BLACK);
            boolean validar = true;
            if(txtNombre.getText().trim().equals("")){
                validar = false;
                jlNombre.setForeground(Color.red);
            }
            if(txtCedula.getText().trim().equals("")){
                validar = false;
                jlCedula.setForeground(Color.red);
            }
            if(txtCorreo.getText().trim().equals("")){
                validar = false;
                jlCorreo.setForeground(Color.red);
            }
            if(jBoxProfesion.getSelectedItem().equals(EnumProfesion.Seleccione)){
                validar = false;
                jlProfesion.setForeground(Color.red);
            }
            if(!rbMasculino.isSelected() && !rbFemenino.isSelected()){
                validar = false;
                jlGenero.setForeground(Color.red);
            }
            return validar;
        }

    }
}

