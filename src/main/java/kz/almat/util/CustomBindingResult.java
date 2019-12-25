package kz.almat.util;

import org.springframework.validation.AbstractBindingResult;

public class CustomBindingResult extends AbstractBindingResult {
    protected CustomBindingResult(String objectName) {
        super(objectName);
    }

    @Override
    public Object getTarget() {
        return null;
    }

    @Override
    protected Object getActualFieldValue(String s) {
        return null;
    }
}
