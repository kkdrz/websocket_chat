import lombok.extern.log4j.Log4j;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@Log4j
@ServerEndpoint("/chat")
public class WebSocketServer {

    @OnOpen
    public void onOpen() {
        log.info("onOpen");
    }

    @OnMessage
    public void onMessage() {
        log.info("onMessage");

    }

    @OnClose
    public void onClose() {
        log.info("onClose");

    }

    @OnError
    public void onError() {
        log.info("onError");

    }

}
