package server;

import lombok.extern.log4j.Log4j;
import utils.ChatMessageDecoder;
import utils.ChatMessageEncoder;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Log4j
@ServerEndpoint(value = "/chat/{room}", encoders = ChatMessageEncoder.class, decoders = ChatMessageDecoder.class)
public class ChatSession {

    private static final Set<ChatSession> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String,String> users = new HashMap<>();

    private String username;

    @OnOpen
    public void onOpen(Session session, @PathParam("room") String room) {
        log.info("Session: " + session.getId() + "connected to room: " + room);

        chatEndpoints.add(this);
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        log.info("onMessage: " + message);
    }

    @OnClose
    public void onClose( CloseReason reason) {
        log.info("onClose");

    }

    @OnError
    public void onError(Throwable e) {
        log.info("onError");

    }

}
