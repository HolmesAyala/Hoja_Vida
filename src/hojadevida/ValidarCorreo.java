
package hojadevida;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class ValidarCorreo {
   
    /**
     * Metodo para validar un correo electronico
     * @param correo
     * @return 
     */
    public static String validar(String correo){
        String textoErrores = "";   //Texto para saber los errores
        //  Validar que no dejen el campo vacio
        if(correo.length() == 0){
            textoErrores += "- El campo para el correo esta vacio\n";
        }
        else{
            //  Validar que no empiece por numero o caracter especial
            if(!soloLetras(correo.charAt(0))){
                textoErrores += "- No puede empezar por numero\n o caracter especial\n";
            }
            else{
                //  Buscar el indice del arroba
                int indiceCorreo = correo.indexOf("@");
                //  La funcion indexOf retorna -1 si no encuentra el caracter
                if(indiceCorreo == -1){
                    textoErrores += "- Falta el @\n";
                }
                else{
                    boolean validar = true;
                    //  Validar que entre el caracter[1] hasta el '@' no tenga
                    //  caracteres especiales
                    for(int i = 1; i < indiceCorreo; i++){
                        if((correo.charAt(i) == '_' || correo.charAt(i) == '-') && i < indiceCorreo-1){
                            //si en el nombre encuentra un '-' o un '_' no lo valida
                        }
                        else{
                            validar = soloLetrasNumeros(correo.charAt(i));
                        }
                        
                        if(validar == false){
                            textoErrores += "- El nombre del correo no puede tener \n  caracteres Especiales (nombre@...)\n";
                            break;
                        }
                    }
                    //  Validar el Dominio del correo
                    int indicePuntoDominio = correo.indexOf(".");
                    //  Si es -1 no escontro el punto del dominio
                    //  Si el indice del punto del dominio esta delante del @ es error
                    if(indicePuntoDominio == -1 || indicePuntoDominio == indiceCorreo +1){
                        textoErrores += "- Error con el dominio del correo\n";
                    }
                    else{
                        //  Validar que el dominio entre el '@' y el '.' no tenga
                        //  caracteres especiales
                        validar = true;
                        for(int i = indiceCorreo +1; i < indicePuntoDominio; i++){
                            validar = soloLetrasNumeros(correo.charAt(i));
                            if(validar == false){
                                textoErrores += "- El nombre del dominio no puede tener \n  caracteres Especiales (@dominio.com)\n";
                                break;
                            }
                        }
                        //  Si el dominio es correcto
                        if(validar == true){
                            //  Validar que despues del '.' este la extencion "com"
                            if(indicePuntoDominio + 3 < correo.length()){
                                //  Si no se encuentra la extencion "com" despues del punto
                                if(!correo.substring(indicePuntoDominio + 1, indicePuntoDominio + 4).equals("com")){
                                    textoErrores += "- Despues del dominio\n  debe ir .com (@dominio.com)\n";
                                }
                                else{
                                    //  Si se encuentra la extencion "com" despues del punto
                                    //  Validar si tiene un indicador como @dominio.com.co
                                    if(indicePuntoDominio + 4 < correo.length()){
                                        if(correo.charAt(indicePuntoDominio + 4)!= '.' || indicePuntoDominio + 5 == correo.length()){
                                            textoErrores += "- Error al final del correo";
                                        }
                                        else{
                                            //  Validar que el dominio de nivel superior no sea menor de 2 caracteres
                                            if(correo.length() - (indicePuntoDominio + 4) < 3){
                                                textoErrores += "- Debe tener al menos dos caracteres\n  el dominio de nivel superior";
                                            }
                                            //   validar que el dominio de nivel superior no sea mayor de 4 caracteres
                                            else if(correo.length() - (indicePuntoDominio + 4) > 5){
                                                textoErrores += "- No debe pasar de 4 caracteres\n  el dominio de nivel superior";
                                            }
                                            else {
                                                //  Validar que el dominio de nivel superior no tenga caracteres especiales
                                                for (int i =  indicePuntoDominio + 5; i < correo.length(); i++){
                                                    if(!soloLetras(correo.charAt(i))){
                                                        textoErrores += "- El dominio de nivel superior no puede tener\n  caracteres especiales";
                                                        break ;
                                                    }
                                                }  
                                            }
                                        }
                                    } 
                                }
                            }
                            else{
                                textoErrores += "- Despues del dominio\n  debe ir .com (@dominio.com)\n";
                            }
                        }
                    }
                }
            }
        }
        
       //   Si no se detectaron errores el correro es "correcto"
        if(textoErrores.length() == 0){
            textoErrores = "correcto";
        }
        return textoErrores;
    }
    
    /**
     * Metodo que valida que un caracter este en el rango de A-Z || a-z
     * @param caracter
     * @return 
     */
    public static boolean soloLetras(char caracter){
        if(caracter < 65 || caracter > 122 || (caracter > 90 && caracter < 97)){
            return false;
        }
        else{
            return true;
        }
    }
    
    /**
     * Metodo que valida que un caracter este en el rango de A-Z || a-z || 0-9
     * @param caracter
     * @return 
     */
    public static boolean soloLetrasNumeros(char caracter){
        if(caracter < 48 || caracter > 122 || (caracter > 90 && caracter < 97) || (caracter > 57 && caracter < 65)){
            return false;
        }
        else{
            return true;
        }
    }
    
}
