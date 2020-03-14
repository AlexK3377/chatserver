package ua.kiev.prog.chatserver.chat.message;

import ua.kiev.prog.chatserver.chat.participant.Participant;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class PublicMessage implements Message {

    private Participant from;
    private ZonedDateTime date;
    private String body;

    public PublicMessage(Participant from, String body) {
        this.from = from;
        this.body = body;
        this.date = ZonedDateTime.now(ZoneOffset.UTC);
    }

    @Override
    public Map<String, String> message(Participant participant) {
        return this.toMap();
    }

    private Map<String, String> toMap() {
        Map<String, String> result = new HashMap<>();
        result.put("date", date.toString());
        result.put("from", from.toString());
        result.put("body", body);
        return result;
    }
}
