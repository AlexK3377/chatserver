package ua.kiev.prog.chatserver.servlet.api;

import java.io.Serializable;

public class CreateChatResponseBody implements Serializable {

    private Integer chatId;

    public CreateChatResponseBody(Integer chatId) {
        this.chatId = chatId;
    }

    public Integer getChatId() {
        return chatId;
    }
}
