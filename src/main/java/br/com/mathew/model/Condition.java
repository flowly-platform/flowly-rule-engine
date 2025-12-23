package br.com.mathew.model;

import java.util.Objects;

public class Condition {

    private final String field;
    private final String op;
    private final Object value;

    public String getField() {
        return field;
    }

    public String getOp() {
        return op;
    }

    public Object getValue() {
        return value;
    }

    public Condition(String field, String op, Object value){
        this.field =  requireNotBlank(field, "field não pode ser nulo/estar em branco");
        this.op = requireNotBlank(op, "value não pode ser nulo/estar em branco");
        this.value = Objects.requireNonNull(value, "value não pode ser nulo");
    }

    private String requireNotBlank(String value, String message) {
        if (value == null || value.isBlank()){
            throw new IllegalArgumentException(message);
        }

        return value;
    }

}
