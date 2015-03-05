package org.lsh.util.validator;

import org.lsh.util.model.LoginUser;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.springframework.validation.ValidationUtils.*;

/**
 * Created by lsh on 15/3/3.
 */
public class LoginUserValidator implements Validator {

    public static final String[] roleFields = new String[]{"Student", "Instructor", "Officer"};

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginUser.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginUser user = (LoginUser) target;
        rejectIfEmptyOrWhitespace(errors, "userId", "LoginUser.userId.invalid", "Please enter valid userId");
        rejectIfEmpty(errors, "password", "LoginUser.password.empty", "Please enter valid password");
        for (String role : roleFields) {
            if (role.equals(user.getRole())) {
                return;
            }
        }
        errors.rejectValue("role", "LoginUser.role.invalid", "Wrong parameters, please contact us for help");
    }
}
