package kz.almat.exception;

import lombok.SneakyThrows;
import org.springframework.validation.BindingResult;

public class OrderDeleteException extends RuntimeException {
    @SneakyThrows
    public OrderDeleteException(BindingResult bindingResult, String msg) {
        super.printStackTrace();
        bindingResult.rejectValue("status", "error.order",  msg);
    }
}
