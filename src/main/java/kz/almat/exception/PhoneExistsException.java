package kz.almat.exception;

import org.springframework.validation.BindingResult;

public class PhoneExistsException extends RuntimeException {

    public PhoneExistsException(BindingResult bindingResult, String msg) {
        super.printStackTrace();
        bindingResult.rejectValue("phone","error.user", msg);
    }
}
