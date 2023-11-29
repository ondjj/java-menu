package menu.util.exception;

public interface ExceptionType<T> {
    String getMessage();
    T getException();
}
