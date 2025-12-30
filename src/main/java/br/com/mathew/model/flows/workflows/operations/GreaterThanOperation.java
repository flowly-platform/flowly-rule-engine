package br.com.mathew.model.flows.workflows.operations;

public class GreaterThanOperation implements ConditionOperation {
    @Override
    public Boolean execute(Object expected, Object actual) {
        if (expected instanceof Number && actual instanceof Number) {
            return ((Number) expected).doubleValue() > ((Number) actual).doubleValue();
        }
        throw new IllegalArgumentException("Comparação > só é válida para números");
    }
}