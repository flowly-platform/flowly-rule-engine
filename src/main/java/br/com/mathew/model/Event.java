package br.com.mathew.model;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

public class Event {

    private final UUID id;
    private final String type;
    private final Map<String, Object> payload;
    private final OffsetDateTime occurredAt;

    public Event(UUID id, String type, Map<String, Object> payload, OffsetDateTime occurredAt) {
        this.id = (id == null) ? UUID.randomUUID() : id;
        this.type = requireNonNull(type, "type não pode ser null");
        this.payload = requireNonNull(payload, "payload nao pode ser null");
        this.occurredAt = occurredAt;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public OffsetDateTime getOccurredAt() {
        return occurredAt;
    }
}
