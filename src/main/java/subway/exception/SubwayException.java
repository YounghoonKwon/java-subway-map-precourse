package subway.exception;

import static subway.constants.Constants.ERROR;

public class SubwayException extends IllegalArgumentException {

    public SubwayException(String message) {
        super(ERROR + message);
    }
}
