package ua.kiev.prog.chatserver.servlet.api.participant;

import java.io.Serializable;
import java.util.List;

public class ParticipantsResponseBody implements Serializable {

    private List<String> participants;

    public ParticipantsResponseBody(List<String> participants) {
        this.participants = participants;
    }

    public List<String> getParticipants() {
        return participants;
    }

}
