package ua.kiev.prog.chatserver.chat.participant;

import java.util.*;

public class Participants {

    private Map<String, Participant> participants;

    public Participants() {
        this.participants = new LinkedHashMap<>();
    }

    public void add(String nickname) {
        if (this.participants.containsKey(nickname)) {
            throw new RuntimeException("Participant already exists");
        }
        this.participants.put(nickname, new Participant(nickname));
    }

    public Participant find(String nickname) {
        Participant participant = participants.get(nickname);
        if (participant == null) {
            throw new RuntimeException("Participant not found");
        }
        return participant;
    }

    public List<String> participants() {
        return Collections.unmodifiableList(new ArrayList<>(participants.keySet()));
    }
}
