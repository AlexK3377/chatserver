package ua.kiev.prog.chatserver.chat.participant;

import java.util.Objects;

public class Participant {

    private String nickname;
    private boolean online;

    public Participant(String nickname) {
        this.nickname = nickname;
        this.online = true;
    }

    @Override
    public String toString() {
        return nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(nickname, that.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }
}
