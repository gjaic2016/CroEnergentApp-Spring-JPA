package hr.apisit.energent.exception;

import org.springframework.dao.DataAccessException;

public class EntityNotFoundException extends DataAccessException {
    public EntityNotFoundException(String msg) {
        super(msg);
    }

    public EntityNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
