package ua.kiev.prog.chatserver.servlet;

import com.google.gson.Gson;
import ua.kiev.prog.chatserver.chat.Chat;
import ua.kiev.prog.chatserver.chat.Chats;
import ua.kiev.prog.chatserver.servlet.api.participant.AddParticipantRequestBody;
import ua.kiev.prog.chatserver.servlet.api.ChatResponseBody;
import ua.kiev.prog.chatserver.servlet.api.participant.ParticipantsResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ParticipantServlet extends HttpServlet {

    private static final Gson GSON = new Gson();
    private Chats chats = Chats.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer chatId = Integer.valueOf(req.getParameter("chatId"));
        Chat chat = chats.chat(chatId);
        List<String> participants = chat.participants();
        ParticipantsResponseBody participantsResponseBody = new ParticipantsResponseBody(participants);
        resp.getWriter().println(GSON.toJson(participantsResponseBody));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AddParticipantRequestBody requestBody = GSON.fromJson(req.getReader(), AddParticipantRequestBody.class);
        Integer chatId = requestBody.getChatId();
        Chat chat = chats.chat(chatId);
        String nickname = requestBody.getNickname();
        List<String> participants = chat.add(nickname);
        List<Map<String, String>> messages = chat.messages(nickname);
        ChatResponseBody chatResponseBody = new ChatResponseBody(participants, messages);
        resp.getWriter().println(GSON.toJson(chatResponseBody));
    }
}
