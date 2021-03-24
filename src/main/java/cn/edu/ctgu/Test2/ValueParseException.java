package cn.edu.ctgu.Test2;

import java.util.Date;

/**
 * @author xzh
 * @date 2021.3.24
 *
 */
public class ValueParseException extends RuntimeException {
    /**
     * 
    */
    private static final long serialVersionUID = 1L;

    public ValueParseException() {
    }

    public ValueParseException(String message) {
        super(message);
    }

    public ValueParseException(Throwable cause) {
        super(cause);
    }

    public ValueParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValueParseException(Boolean message){super(String.valueOf(message));}

    public ValueParseException(Integer message){super(String.valueOf(message));}

    public ValueParseException(Date message){super(String.valueOf(message));}

}