package br.com.mathew;

import br.com.mathew.model.Condition;
import br.com.mathew.model.Event;
import br.com.mathew.model.flows.EvaluatorFlow;
import br.com.mathew.model.flows.workflows.OperationsWorkFlow;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Map<String, Object> payload = new HashMap<>();
        payload.put("age", 20);

        Event event = new Event(
                null,                     // id (engine gera)
                "USER_CREATED",           // type
                payload,                  // payload
                OffsetDateTime.now()       // occurredAt
        );

        Condition condition = new Condition(
                "age",    // field
                ">",      // operador
                18        // valor esperado
        );

        OperationsWorkFlow operationsWorkFlow = new OperationsWorkFlow();
        EvaluatorFlow evaluatorFlow = new EvaluatorFlow(operationsWorkFlow);


        Boolean result = evaluatorFlow.execute(event, condition);

        System.out.println("Resultado da condição: " + result);

    }
}