package br.com.mathew.model;

import br.com.mathew.model.enums.MatchType;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Rule {

    private final UUID id;
    private final String trigger;
    private final MatchType match;
    private final List<Condition> conditions;
    private final List<Action> actions;
    private final boolean enabled;

    public Rule(UUID id, String trigger, MatchType match, List<Condition> conditions, List<Action> actions, boolean enabled) {
        this.id = (id == null) ? UUID.randomUUID() : id;
        this.trigger = requireNotBlank(trigger, "trigger não pode ser vazio");
        this.match = Objects.requireNonNull(match, "match não pode ser null");
        this.conditions = List.copyOf(Objects.requireNonNull(conditions, "conditions não pode ser null"));
        this.actions = List.copyOf(Objects.requireNonNull(actions, "actions não pode ser null"));
        this.enabled = enabled;
    }

    private String requireNotBlank(String value, String message) {
        if (value == null || value.isBlank()){
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public UUID getId() {
        return id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<Action> getActions() {
        return actions;
    }

    public MatchType getMatch() {
        return match;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public String getTrigger() {
        return trigger;
    }
}
