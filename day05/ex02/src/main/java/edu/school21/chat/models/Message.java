package edu.school21.chat.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Message {
    private Long id;
    private long authorId;
    private Long chatId;
    private String text;
    private Timestamp dateTime;

    public Message(Long id, Long authorId, Long chatId, String text, Timestamp dateTime) {
        this.id = id;
        this.authorId = authorId;
        this.chatId = chatId;
        this.text = text;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAuthorId() {
        return authorId;
    }

    public long getChatId() {
        return chatId;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public void printMessage() {
        System.out.println("Message : {");
        System.out.println("            id="+ id);
        System.out.println("            authorId="+ authorId);
        System.out.println("            chatId="+ chatId);
        System.out.println("            text="+ text);
        System.out.println("            dateTime="+ dateTime);
        System.out.println("}");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id && chatId == message.chatId && Objects.equals(authorId, message.authorId) && Objects.equals(text, message.text) && Objects.equals(dateTime, message.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorId, chatId, text, dateTime);
    }
}
