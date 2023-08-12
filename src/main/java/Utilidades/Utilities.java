package Utilidades;

import org.apache.commons.validator.routines.EmailValidator;

public class Utilities {
    public static boolean validarEmail(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(email);
    }
    public static boolean validarPassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$");
    }


}
