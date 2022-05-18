package bl;

public class Password {
    private int longitud;
    private String contrasenia;

    public Password() {
    }

    public Password(int longitud) {
        this.longitud = longitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Método:          esFuerte
     * Descripción      Método que valida si el password es fuerte, para esto verifica si al menos 2 caracteres son
     *                  mayúscula, al menos 1 caracter es minúscula y al menos 5 caracteres son números; si al menos
     *                  se cumple lo anterior retorna un true, de lo contrario retorna un false
     * @param password  Variable de tipo String que contiene el password
     * @return          Variable de tipo boolean que indica si es fuerte (true) o débil (false)
     */
    public boolean esFuerte(String password) {
        int uppercaseCounter = 0;
        int lowercaseCounter = 0;
        int digitCounter = 0;
        int min_uppercase = 2;
        int min_lowercase = 1;
        int min_digits = 5;
        for (int i=0; i < password.length(); i++ ) {
            char c = password.charAt(i);
            if(Character.isUpperCase(c)) {
                uppercaseCounter ++;
            } else if(Character.isLowerCase(c)) {
                lowercaseCounter ++;
            } else if(Character.isDigit(c)) {
                digitCounter ++;
            }
        }
        if (uppercaseCounter >= min_uppercase && lowercaseCounter >= min_lowercase && digitCounter >= min_digits) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método:          generarPassword
     * Descripción      Método que construye el password, para lo cual considera el largo definido (default 8) o
     *                  el indicado por el usuario, el que se puede ubicar entre 8 y 30 caracteres, ambos
     *                  inclusive
     */
    public void generarPassword() {
        String password = "";
        int count = 0;
        int tipo_valor = -1;
        if(getLongitud() == 0) {
            setLongitud(8);
        }
        do {
            tipo_valor = generarNumRandom(3);
            if (tipo_valor == 0) { // letra mayúscula
                password += String.valueOf(Character.toUpperCase(generarLetra()));
            } else if (tipo_valor == 1) { // letra minúscula
                password += String.valueOf(generarLetra());
            } else { // número
                password += String.valueOf(generarNumRandom(9));
            }
            count += 1;
        } while (count < getLongitud());
        setContrasenia(password);
    }

    /**
     * Método:          generarNumRandom
     * Descripción      Método que genera un número random entre cero y el valor pasado por parámetro
     * @param num       Variable de tipo int, que representa el límite del valor random que se generará.
     * @return          Variable de tipo int que representa el valor random que se genera.
     */
    private int generarNumRandom(int num) {
        return (int) (Math.random() * num);
    }

    /**
     * Método:          generarLetra
     * Descripción      Método que permite generar un letra del abecedario
     * @return          Variable de tipo char que representa una letra del alfabeto.
     */
    private char generarLetra() {
        char [] letra = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z'};
        int ubicacion = generarNumRandom(26);
        return letra [ubicacion];
    }
}
