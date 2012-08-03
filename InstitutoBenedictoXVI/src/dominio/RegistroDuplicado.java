package dominio;

public class RegistroDuplicado extends Exception {
	private static final long serialVersionUID = 1L;

	public RegistroDuplicado(String message) {
        super(message);
    }

}
