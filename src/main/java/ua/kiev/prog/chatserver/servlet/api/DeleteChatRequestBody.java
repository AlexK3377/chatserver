package ua.kiev.prog.chatserver.servlet.api;

import java.io.Serializable;

public class DeleteChatRequestBody implements Serializable {

    private Integer chatId;

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }
}
