package kz.almat.exception;

import lombok.SneakyThrows;
import org.springframework.validation.BindingResult;

public class EmailExistsException extends RuntimeException{

    @SneakyThrows
    public EmailExistsException(BindingResult bindingResult, String msg) {
        super.printStackTrace();
        bindingResult.rejectValue("email", "error.user",  msg);
    }
}
