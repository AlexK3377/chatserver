package ua.kiev.prog.chatserver.servlet;

import com.google.gson.Gson;
import ua.kiev.prog.chatserver.chat.Chats;
import ua.kiev.prog.chatserver.servlet.api.ChatsResponseBody;
import ua.kiev.prog.chatserver.servlet.api.CreateChatResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChatsServlet extends HttpServlet {

    private static final Gson GSON = new Gson();
    private Chats chats = Chats.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = chats.create();
        CreateChatResponseBody createChatResponseBody = new CreateChatResponseBody(id);
        resp.getWriter().println(GSON.toJson(createChatResponseBody));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChatsResponseBody chatsResponseBody = new ChatsResponseBody(chats.chats());
        resp.getWriter().println(GSON.toJson(chatsResponseBody));
    }
}
