package br.com.mathew.model.flows.workflows.operations;

public class StartsWithOperation implements ConditionOperation {
    @Override
    public Boolean execute(Object expected, Object actual) {
        if (expected instanceof String && actual instanceof String) {
            return ((String) expected).startsWith((String) actual);
        }
        throw new IllegalArgumentException("startsWith só é válido para strings");
    }
}