package ua.kiev.prog.chatserver.servlet.api;

import java.io.Serializable;
import java.util.Set;

public class ChatsResponseBody implements Serializable {

    private Set<Integer> chats;

    public ChatsResponseBody(Set<Integer> chats) {
        this.chats = chats;
    }

    public Set<Integer> getChats() {
        return chats;
    }
}
