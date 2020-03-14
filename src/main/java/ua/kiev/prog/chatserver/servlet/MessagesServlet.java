package ua.kiev.prog.chatserver.servlet;

import com.google.gson.Gson;
import ua.kiev.prog.chatserver.chat.Chat;
import ua.kiev.prog.chatserver.chat.Chats;
import ua.kiev.prog.chatserver.servlet.api.ChatResponseBody;
import ua.kiev.prog.chatserver.servlet.api.message.AddMessageRequestBody;
import ua.kiev.prog.chatserver.servlet.api.message.MessagesResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MessagesServlet extends HttpServlet {

    private static final Gson GSON = new Gson();
    private Chats chats = Chats.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer chatId = Integer.valueOf(req.getParameter("chatId"));
        String nickname = req.getParameter("nickname");
        Chat chat = chats.chat(chatId);
        List<Map<String, String>> messages = chat.messages(nickname);
        MessagesResponseBody messagesResponseBody = new MessagesResponseBody(messages);
        resp.getWriter().println(GSON.toJson(messagesResponseBody));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AddMessageRequestBody requestBody = GSON.fromJson(req.getReader(), AddMessageRequestBody.class);
        Integer chatId = requestBody.getChatId();
        Chat chat = chats.chat(chatId);
        chat.write(requestBody.getFrom(), requestBody.getTo(), requestBody.getText());
        List<String> participants = chat.participants();
        List<Map<String, String>> messages = chat.messages(requestBody.getFrom());
        ChatResponseBody chatResponseBody = new ChatResponseBody(participants, messages);
        resp.getWriter().println(GSON.toJson(chatResponseBody));
    }
}
