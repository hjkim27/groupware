package hjkim27.dev.exception;

/**
 * <pre>
 *     잘못된 파라미터 요청 시 반환
 * </pre>
 *
 * @since 2025.08
 */
public class WrongParamException extends RuntimeException {

    public WrongParamException() {
        super();
    }

    public WrongParamException(String message) {
        super(message);
    }

    public WrongParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongParamException(Throwable cause) {
        super(cause);
    }
}
