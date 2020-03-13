package ua.kiev.prog.chatserver.chat.message;

import ua.kiev.prog.chatserver.chat.participant.Participant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Messages {

    private List<Message> messages;

    public Messages() {
        this.messages = new ArrayList();
    }

    public void add(Message message) {
        this.messages.add(message);
    }

    public List<String> messages(Participant participant) {
        List<String> result = new ArrayList<>();
        for (Message message : this.messages) {
            String body = message.message(participant);
            if (!"".equals(body)) {
                result.add(body);
            }
        }
        return Collections.unmodifiableList(result);
    }
}
