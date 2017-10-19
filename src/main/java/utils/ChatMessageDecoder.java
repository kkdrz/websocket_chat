package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import model.Message;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;

@Log4j
public class ChatMessageDecoder implements Decoder.Text<Message> {

    private ObjectMapper mapper;

    public ChatMessageDecoder() {
        mapper = new ObjectMapper();
    }

    @Override
    public Message decode(String message) throws DecodeException {
        try {
            return mapper.readValue(message, Message.class);
        } catch (IOException e) {
            throw new DecodeException(message, "Decoding message failed.", e);
        }
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
