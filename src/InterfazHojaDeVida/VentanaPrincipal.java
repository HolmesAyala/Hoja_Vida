
package InterfazHojaDeVida;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class VentanaPrincipal extends JFrame{
    
    private JMenuBar barraMenu;
    
    private JMenu menuPrincipal;
    
    private JMenuItem itemTabla;
    
    private JMenuItem itemAyuda;

    private JMenuItem itemSalir;
    
    private PanelHoja panelHoja;
    
    private DialogoTabla dialogoTabla;
    
    private DialogoAyuda dialogoAyuda;
    
    /**
     * Constructor
     */
    public VentanaPrincipal() {
        dialogoAyuda = new DialogoAyuda();
        configurarVentana();
    }
    
    /**
     * Configura la ventana principal
     */
    public void configurarVentana(){
        setTitle("Gestion de hojas de vida");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));
        
        agregarElementos();
        
        setVisible(true);
        
    }
    
    /**
     * Agrega los elementos a la ventana
     */
    public void agregarElementos(){
        
        agregarBarraMenu();
        
        panelHoja = new PanelHoja(this);
        dialogoTabla = new DialogoTabla(this);
        add(panelHoja);
    }
    
    /**
     * Agregar la barra de menu
     */
    public void agregarBarraMenu(){
        
        Font fuente = new Font("Calibri", Font.PLAIN, 25);
        //  Item para el dialogo de la tabla
        itemTabla = new JMenuItem("Tabla");
        itemTabla.setFont(fuente);
        itemTabla.addActionListener(new EscucharMenu());
        //  Item para el dialogo de ayuda
        itemAyuda = new JMenuItem("Ayuda");
        itemAyuda.setFont(fuente);
        itemAyuda.addActionListener(new EscucharMenu());
        //  Item para salir del programa
        itemSalir = new JMenuItem("Salir");
        itemSalir.setFont(fuente);
        itemSalir.addActionListener(new EscucharMenu());
        //  Agregar items al menu
        menuPrincipal = new JMenu("Menu");
        menuPrincipal.setFont(fuente);
        menuPrincipal.add(itemTabla);
        menuPrincipal.add(itemAyuda);
        menuPrincipal.add(itemSalir);
        //  Agregar menu a la barra
        barraMenu = new JMenuBar();
        barraMenu.add(menuPrincipal);
        //  Agregar barra a la ventana
        add(barraMenu, BorderLayout.NORTH);
    }
    
    /**
     * Clase que escucha la barra de menu
     */
    class EscucharMenu implements ActionListener{
        /**
         * Metodo de escucha
         * @param evento 
         */
        @Override
        public void actionPerformed(ActionEvent evento) {
            if(evento.getActionCommand().equals("Tabla")){
                dialogoTabla.setVisible(true);
                System.out.println("Quiere ver la tabla");
            }
            if(evento.getActionCommand().equals("Ayuda")){
                dialogoAyuda.setVisible(true);
                System.out.println("Quiere ver la ayuda");
            }
            if(evento.getActionCommand().equals("Salir")){
                System.exit(0);
            }
        }
    }

    /**
     * Obtener el panel de la hoja
     * @return 
     */
    public PanelHoja getPanelHoja() {
        return panelHoja;
    }

    /**
     * Cambiar el panel de la hoja
     * @param panelHoja 
     */
    public void setPanelHoja(PanelHoja panelHoja) {
        this.panelHoja = panelHoja;
    }

    /**
     * Obtener el dialogo de la tabla
     * @return 
     */
    public DialogoTabla getDialogoTabla() {
        return dialogoTabla;
    }

    /**
     * Cambiar el dialogo de la tabla
     * @param dialogoTabla 
     */
    public void setDialogoTabla(DialogoTabla dialogoTabla) {
        this.dialogoTabla = dialogoTabla;
    }
    
}
