package menu.util.exception;

import static menu.util.constants.ErrorConstants.*;

public enum IllegalArgumentExceptionType implements ExceptionType<IllegalArgumentException>{
    INVALID_NAME_LENGTH(ERROR + "유효하지 않은 이름 길이입니다. 다시 입력해주세요.");

    private final String message;

    IllegalArgumentExceptionType(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
