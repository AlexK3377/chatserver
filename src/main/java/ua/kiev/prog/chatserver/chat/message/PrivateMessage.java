package ua.kiev.prog.chatserver.chat.message;

import ua.kiev.prog.chatserver.chat.participant.Participant;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PrivateMessage implements Message {

    private Participant from;
    private Participant to;
    private ZonedDateTime date;
    private String body;

    public PrivateMessage(Participant from, Participant to, String body) {
        this.from = from;
        this.to = to;
        this.body = body;
        this.date = ZonedDateTime.now(ZoneOffset.UTC);
    }

    @Override
    public Map<String, String> message(Participant participant) {
        if (this.to.equals(participant) || this.from.equals(participant)) {
            return this.toMap();
        }
        return Collections.emptyMap();
    }

    private Map<String, String> toMap() {
        Map<String, String> result = new HashMap<>();
        result.put("date", date.toString());
        result.put("from", from.toString());
        result.put("to", to.toString());
        result.put("body", body);
        return result;
    }
}