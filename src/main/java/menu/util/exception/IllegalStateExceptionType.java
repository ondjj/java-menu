package menu.util.exception;

import static menu.util.constants.ErrorConstants.ERROR;

public enum IllegalStateExceptionType implements ExceptionType<IllegalStateException>{
    INVALID_COACH_SIZE(ERROR + "유효하지 않은 코치입니다. 다시 입력해주세요.");

    private final String message;

    IllegalStateExceptionType(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public IllegalStateException getException() {
        return new IllegalStateException();
    }
}
