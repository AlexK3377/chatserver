package ua.kiev.prog.chatserver.chat.message;

import ua.kiev.prog.chatserver.chat.participant.Participant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Messages {

    private List<Message> messages;

    public Messages() {
        this.messages = new ArrayList<>();
    }

    public void add(Message message) {
        this.messages.add(message);
    }

    public List<Map<String, String>> messages(Participant participant) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Message message : this.messages) {
            Map<String, String> body = message.message(participant);
            if (!body.isEmpty()) {
                result.add(body);
            }
        }
        return Collections.unmodifiableList(result);
    }
}
