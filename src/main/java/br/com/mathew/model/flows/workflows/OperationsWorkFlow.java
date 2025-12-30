package br.com.mathew.model.flows.workflows;

import br.com.mathew.model.flows.workflows.operations.ConditionOperation;
import br.com.mathew.model.flows.workflows.operations.GreaterThanOperation;
import br.com.mathew.model.flows.workflows.operations.LessThanOperation;
import br.com.mathew.model.flows.workflows.operations.StartsWithOperation;

import java.util.Map;
import java.util.HashMap;

public class OperationsWorkFlow {

    private final Map<String, ConditionOperation> operations;

    public OperationsWorkFlow() {
        operations = new HashMap<>();
        operations.put(">", new GreaterThanOperation());
        operations.put("<", new LessThanOperation());
        operations.put("startWith", new StartsWithOperation());
    }

    public Boolean execute(String op, Object expectedValue, Object eventValue) {
        ConditionOperation operation = operations.get(op);
        if (operation == null) {
            throw new IllegalArgumentException("Operação não suportada: " + op);
        }
        return operation.execute(expectedValue, eventValue);
    }
}