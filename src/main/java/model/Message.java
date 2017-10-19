package model;

import lombok.Data;

import java.util.Date;

@Data
public class Message {

    private String author;
    private Date date;
    private String content;
    private Type type;

    enum Type {
        USERNAME, MESSAGE
    }
}
