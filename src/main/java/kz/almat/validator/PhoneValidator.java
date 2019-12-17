package kz.almat.validator;

import kz.almat.anootation.ValidEmail;
import kz.almat.anootation.ValidPhone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    private Pattern pattern;
    private Matcher matcher;
    private static final String PHONE_PATTERN = "^[0-9]{11}$";

    public void initialize(ValidEmail constraintAnnotation) {

    }

    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        return (validatePhone(phone));
    }

    private boolean validatePhone(String email) {
        pattern = Pattern.compile(PHONE_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
