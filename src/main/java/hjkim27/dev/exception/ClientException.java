package hjkim27.dev.exception;


/**
 * <pre>
 *      기본 사용자 요청 exception
 * </pre>
 *
 * @since 2025.08
 */
public class ClientException extends RuntimeException {

    public ClientException() {
        super();
    }

    public ClientException(String message) {
        super(message);
    }

    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientException(Throwable cause) {
        super(cause);
    }
}
