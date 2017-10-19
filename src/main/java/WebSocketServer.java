import lombok.extern.log4j.Log4j;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@Log4j
@ServerEndpoint("/chat")
public class WebSocketServer {

    @OnOpen
    public void onOpen(Session session) {
        log.info("onOpen");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("onMessage");

    }

    @OnClose
    public void onClose(CloseReason reason, Session session) {
        log.info("onClose");

    }

    @OnError
    public void onError(Throwable e) {
        log.info("onError");

    }

}
