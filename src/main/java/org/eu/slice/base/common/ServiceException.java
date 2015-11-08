package org.eu.slice.base.common;

/**
 * Service层的运行时异常
 * @author - shild
 */

public class ServiceException extends BaseRuntimeException {

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ServiceException(String code, String msg) {
        super(code, msg);
    }

    public ServiceException(String code, String msg, Throwable cause) {
        super(code, msg, cause);
    }
}
