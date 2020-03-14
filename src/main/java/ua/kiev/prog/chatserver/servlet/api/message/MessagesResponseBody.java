package ua.kiev.prog.chatserver.servlet.api.message;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class MessagesResponseBody implements Serializable {

    private List<Map<String, String>> messages;

    public MessagesResponseBody(List<Map<String, String>> messages) {
        this.messages = messages;
    }

    public List<Map<String, String>> getMessages() {
        return messages;
    }
}
