package ua.kiev.prog.chatserver.chat;

import ua.kiev.prog.chatserver.chat.message.Messages;
import ua.kiev.prog.chatserver.chat.message.PrivateMessage;
import ua.kiev.prog.chatserver.chat.message.PublicMessage;
import ua.kiev.prog.chatserver.chat.participant.Participant;
import ua.kiev.prog.chatserver.chat.participant.Participants;

import java.util.List;
import java.util.Map;

public class Chat {

    private Participants participants;
    private Messages messages;

    public Chat() {
        this.participants = new Participants();
        this.messages = new Messages();
    }

    public List<String> participants() {
        return participants.participants();
    }

    public List<String> add(String nickname) {
        this.participants.add(nickname);
        return this.participants.participants();
    }

    public void write(String fromNickname, String toNickname, String message) {
        Participant fromParticipant = participants.find(fromNickname);
        if (toNickname == null) {
            this.messages.add(new PublicMessage(fromParticipant, message));
        } else {
            Participant toParticipant = participants.find(toNickname);
            this.messages.add(new PrivateMessage(fromParticipant, toParticipant, message));
        }
    }

    public List<Map<String, String>> messages(String nickName) {
        Participant participant = participants.find(nickName);
        if (participant != null) {
            return messages.messages(participant);
        }
        throw new RuntimeException("Participant not found");
    }
}
