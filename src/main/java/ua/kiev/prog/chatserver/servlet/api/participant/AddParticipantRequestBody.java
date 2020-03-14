package ua.kiev.prog.chatserver.servlet.api.participant;

import java.io.Serializable;

public class AddParticipantRequestBody implements Serializable {

    private Integer chatId;
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }
}
