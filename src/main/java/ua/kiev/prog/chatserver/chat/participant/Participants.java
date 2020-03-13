package ua.kiev.prog.chatserver.chat.participant;

import java.util.*;

public class Participants {

    private Map<String, Participant> participants;

    public Participants() {
        this.participants = new LinkedHashMap<>();
    }

    public void add(String nickname) {
        this.participants.put(nickname, new Participant(nickname));
    }

    public Participant find(String nickname) {
        return participants.get(nickname);
    }

    public List<String> participants() {
        return Collections.unmodifiableList(new ArrayList<>(participants.keySet()));
    }
}
