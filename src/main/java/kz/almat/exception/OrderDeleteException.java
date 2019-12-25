package kz.almat.exception;

import lombok.SneakyThrows;
import org.springframework.validation.MapBindingResult;

import java.util.HashMap;

public class OrderDeleteException extends RuntimeException {



    @SneakyThrows
    public OrderDeleteException(String msg) {
        super.printStackTrace();
        new MapBindingResult(new HashMap<String, Object>(), "order").rejectValue("status", "error.order",  msg);
    }
}
