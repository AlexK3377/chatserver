package ua.kiev.prog.chatserver.chat;

import com.google.gson.Gson;
import ua.kiev.prog.chatserver.chat.message.Messages;
import ua.kiev.prog.chatserver.chat.message.PrivateMessage;
import ua.kiev.prog.chatserver.chat.message.PublicMessage;
import ua.kiev.prog.chatserver.chat.participant.Participant;
import ua.kiev.prog.chatserver.chat.participant.Participants;

import java.util.List;

public class Chat {

    private static final Gson GSON = new Gson();
    private Participants participants;
    private Messages messages;

    public Chat() {
        this.participants = new Participants();
        this.messages = new Messages();
    }

    public String participants() {
        return GSON.toJson(participants.participants());
    }

    public List<String> add(String nickname) {
        this.participants.add(nickname);
        return this.participants.participants();
    }

    public void add(String fromNickname, String message) {
        Participant participant = participants.find(fromNickname);
        if (participant != null) {
            this.messages.add(new PublicMessage(participant, message));
        }
    }

    public void add(String fromNickname, String toNickname, String message) {
        Participant fromParticipant = participants.find(fromNickname);
        Participant toParticipant = participants.find(toNickname);
        if (fromParticipant != null && toNickname != null) {
            this.messages.add(new PrivateMessage(fromParticipant, toParticipant, message));
        }
    }

    public List<String> messages(String nickName) {
        Participant participant = participants.find(nickName);
        if (participant != null) {
            return messages.messages(participant);
        }
        throw new RuntimeException("Participant not found");
    }
}
