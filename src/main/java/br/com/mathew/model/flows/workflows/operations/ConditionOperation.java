package br.com.mathew.model.flows.workflows.operations;

public interface ConditionOperation {
    Boolean execute (Object expectedValue, Object eventValue);
}
