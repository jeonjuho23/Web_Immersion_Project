package com.example.spring.mvc.validator.ex;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {
    @Override
    public boolean supports(Class<?> arg0) {
        return Student.class.isAssignableFrom(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {
        System.out.println("validator()");
        Student student = (Student) object;

//        String studentName = student.getName();
//        if (studentName == null || studentName.isEmpty()) {
//            System.out.println("studentName is null or empty");
//            errors.rejectValue("name", "trouble");
//        }
//        String studentId = student.getId();
//        if(studentId.equals("0")) {
//            System.out.println("studentId is 0");
//            errors.rejectValue("id", "trouble");
//        }

        // 위 기능을 이처럼 스태틱 메서드를 사용해서 구현 가능
        ValidationUtils.rejectIfEmptyOrWhitespace
                (errors, "name", "trouble");





    }
}
