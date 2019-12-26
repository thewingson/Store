package kz.almat.exception;

import lombok.SneakyThrows;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;

import java.util.HashMap;

public class OrderDeleteException extends RuntimeException {



    @SneakyThrows
    public OrderDeleteException(BindingResult bindingResult, String msg) {
        super.printStackTrace();
        bindingResult.rejectValue("status", "error",  msg);
    }
}
