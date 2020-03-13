package ua.kiev.prog.chatserver.chat.message;

import ua.kiev.prog.chatserver.chat.participant.Participant;

public interface Message {

    String message(Participant toNickname);
}
