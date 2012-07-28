package controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funcion {

    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String CARACTERES_EXTRANOS = "[_a-zA-Z0-9]+"; 
  

	public boolean valCorreo(String correo) {
		// TODO Auto-generated method stub
		pattern = Pattern.compile(EMAIL_PATTERN);
    	matcher = pattern.matcher(correo);
        return matcher.matches();
		
	}


	public static String getCaracteresExtranos() {
		return CARACTERES_EXTRANOS;
	}
	

}
