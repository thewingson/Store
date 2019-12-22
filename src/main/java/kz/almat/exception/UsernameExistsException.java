package kz.almat.exception;

import org.springframework.validation.BindingResult;

public class UsernameExistsException extends RuntimeException {

    public UsernameExistsException(BindingResult bindingResult, String msg) {
        super.printStackTrace();
        bindingResult.rejectValue("username","error.user", msg);
    }
}
