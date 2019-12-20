package kz.almat.exception;

import org.springframework.validation.BindingResult;

public class UsernameExistsException extends RuntimeException {

    public UsernameExistsException(BindingResult bindingResult, String msg) {
        super(msg);
        bindingResult.rejectValue("username", msg);
    }
}
