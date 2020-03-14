package ua.kiev.prog.chatserver.chat;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

//Singleton
public class Chats {

    public static final Chats INSTANCE = new Chats();

    private final AtomicInteger id;
    private final Map<Integer, Chat> chats;

    private Chats() {
        this.id = new AtomicInteger(0);
        chats = new LinkedHashMap<>();
    }

    public Integer create() {
        int chatId = id.incrementAndGet();
        chats.put(chatId, new Chat());
        return chatId;
    }

    public void delete(Integer id) {
        chats.remove(id);
    }

    public Set<Integer> chats() {
        return chats.keySet();
    }

    public Chat chat(Integer id) {
        Chat chat = chats.get(id);
        if (chat == null) {
            throw new RuntimeException("Chat does not exists");
        }
        return chat;
    }
}
