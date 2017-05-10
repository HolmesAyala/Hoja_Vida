
package InterfazHojaDeVida;

import hojadevida.Utilitaria;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class DialogoAyuda extends JDialog{
    
    private JTextArea ayuda;    //  Area de texto de ayuda

    /**
     * Constructor
     */
    public DialogoAyuda() {
        configurarDialogo();
    }
    
    /**
     * Configurar
     */
    public void configurarDialogo(){
        setTitle("Ayuda");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        
        agregarElementos();
    }
    
    /**
     * Agregar elementos al Dialogo
     */
    public void agregarElementos(){
        ayuda = new JTextArea();
        ayuda.setEditable(false);
        ayuda.setLineWrap(true);
        ayuda.setWrapStyleWord(true);
        
        Font fuente = new Font("Calibri", Font.PLAIN, 30);
        ayuda.setFont(fuente);
        
        JScrollPane scrollAyuda = new JScrollPane(ayuda);
        scrollAyuda.setBounds(10, 10, 580, 540);
        add(scrollAyuda);
        agregarTexto();
    }
    
    /**
     * Agrega el texto al area de ayuda
     */
    public void agregarTexto(){
        String texto = "";
        try{
            texto = Utilitaria.leer("Documento/Ayuda.txt");
        }catch(Exception error){
            error.printStackTrace();
        }
        ayuda.setText(texto);
    }
}
