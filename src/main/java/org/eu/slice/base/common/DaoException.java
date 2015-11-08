package org.eu.slice.base.common;

/**
 * DAO层的运行时异常
 *
 * @author - shild
 */
public class DaoException extends BaseRuntimeException{

    public DaoException(String msg) {
        super(msg);
    }

    public DaoException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DaoException(String code, String msg) {
        super(code, msg);
    }

    public DaoException(String code, String msg, Throwable cause) {
        super(code, msg, cause);
    }
}

