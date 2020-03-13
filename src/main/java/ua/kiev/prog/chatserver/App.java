package ua.kiev.prog.chatserver;

import ua.kiev.prog.chatserver.chat.Chat;

public class App {

    public static void main(String[] args) {
        Chat chat = new Chat();
        chat.add("vasya");
        chat.add("petya");
        chat.add("sergey");
        chat.add("vasya", "Hello!");
        chat.add("petya", "Hello!");
        chat.add("sergey", "vasya", "Hello vasya!");

        System.out.println(chat.messages("vasya"));
        System.out.println();
        System.out.println();
        System.out.println(chat.messages("petya"));
        System.out.println();
        System.out.println();
        System.out.println(chat.messages("sergey"));

        System.out.println();
        System.out.println();
        System.out.println(chat.participants());
        System.out.println(chat.messages("petro"));
    }
}
