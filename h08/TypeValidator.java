package com.huawei.classroom.student.h08;

public class TypeValidator {

    public void validate(Object a){
        if (!(a instanceof String)) {
            throw new RuntimeException();
        }
    }

}