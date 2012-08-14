package dominio;

@SuppressWarnings("serial")
public class ParametroIncompleto extends Exception {
	public ParametroIncompleto(String codgrupo) {
        super("No es posible continuar sin " + codgrupo);
	}
}

