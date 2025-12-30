package br.com.mathew.model.flows;

import br.com.mathew.model.Condition;
import br.com.mathew.model.Event;
import br.com.mathew.model.flows.workflows.OperationsWorkFlow;


public class EvaluatorFlow {

    private final OperationsWorkFlow operationsWorkFlow;

    public EvaluatorFlow(OperationsWorkFlow operationsWorkFlow) {
        this.operationsWorkFlow = operationsWorkFlow;
    }

    public Boolean execute(Event event, Condition condition) {
        String field = condition.getField();
        String op = condition.getOp();
        Object expectedValue = condition.getValue();

        Object eventValue = event.getPayload().get(field);

        return operationsWorkFlow.execute(op, expectedValue, eventValue);
    }
}