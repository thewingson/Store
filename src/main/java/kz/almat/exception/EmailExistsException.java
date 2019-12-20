package kz.almat.exception;

import org.springframework.validation.BindingResult;

public class EmailExistsException extends RuntimeException{

    public EmailExistsException(BindingResult bindingResult, String msg) {
        super(msg);
        bindingResult.rejectValue("email", msg);
    }
}
