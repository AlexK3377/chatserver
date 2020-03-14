package ua.kiev.prog.chatserver.chat.message;

import ua.kiev.prog.chatserver.chat.participant.Participant;

import java.util.Map;

public interface Message {

    Map<String, String> message(Participant toNickname);
}
