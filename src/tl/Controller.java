package tl;

import bl.Password;

public class Controller {
    String [] pass = new String [2];
    Password password;

    /**
     * Método:          generarPassword
     * Descripción      Método que permite recibir una solicitud del main para enviar a la clase Password a
     *                  crear un password en el caso que no se indique el largo del pasword.
     * @return          Objeto de tipo Array que contiene el passworod y la indicación si es fuerte o no
     */
    public String [] generarPassword () {
        password = new Password();
        password.generarPassword();
        pass[0] = password.getContrasenia();
        esFuerte();
        return pass;
    }

    /**
     * Método:          generarPassword
     * Descripción      Método que permite recibir una solicitud del main para enviar a la clase Password a
     *                  crear un password en el caso que no se indique el largo del pasword.
     * @param largo     Variable de tipo int que representa el largo de la contraseña.
     * @return          Objeto de tipo Array que contiene el passworod y la indicación si es fuerte o no
     */
    public String [] generarPassword(int largo) {
        password = new Password(largo);
        password.generarPassword();
        pass[0] = password.getContrasenia();
        esFuerte();
        return pass;
    }

    /**
     * Método:          esFuerte
     * Descripción      Método que permite solicitar a la clase Password si es fuerte (true) o débil (false),
     *                  si es fuerte retorna un String indicando que es fuerte, o de lo contrario que es débil.
     */
    public void esFuerte(){
        if (password.esFuerte(password.getContrasenia())) {
            pass[1] = "contraseña fuerte";
        } else {
            pass[1] = "contraseña débil";
        }
    }
}
