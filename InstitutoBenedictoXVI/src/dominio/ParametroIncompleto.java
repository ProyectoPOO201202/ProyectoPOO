package dominio;

@SuppressWarnings("serial")
public class ParametroIncompleto extends Exception {
	ParametroIncompleto(String nombre) {
        super("No es posible continuar sin " + nombre);
	}
}

