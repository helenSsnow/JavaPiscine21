package edu.school21.chat.models;

import java.util.Date;
import java.util.Objects;

public class Message {
    private Long id;
    private int authorId;
    private int chatId;
    private String text;
    private Date dateTime;

    public Message(Long id, int authorId, int chatId, String text, Date dateTime) {
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthor(int authorId) {
        this.authorId = authorId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
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
