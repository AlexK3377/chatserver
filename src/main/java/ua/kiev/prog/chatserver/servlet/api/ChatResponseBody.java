package ua.kiev.prog.chatserver.servlet.api;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ChatResponseBody implements Serializable {

    private List<String> participants;
    private List<Map<String, String>> messages;

    public ChatResponseBody(List<String> participants, List<Map<String, String>> messages) {
        this.participants = participants;
        this.messages = messages;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public List<Map<String, String>> getMessages() {
        return messages;
    }
}
