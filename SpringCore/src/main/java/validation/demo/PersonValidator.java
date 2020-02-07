package validation.demo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import validation.demo.Person;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        Person p = (Person) o;
        if (p.getAge() < 0) {
            errors.rejectValue("age", "年龄为负");
        } else if (p.getAge() > 110) {
            errors.rejectValue("age", "太老");
        }
    }
}
