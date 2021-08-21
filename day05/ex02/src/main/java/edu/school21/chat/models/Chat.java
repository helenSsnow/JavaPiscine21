package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chat {
    private long id;
    private String name;
    private long ownerId;
    private List<Message> messages;

    public Chat(int id, String name,  long ownerId, List<Message> messages) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.messages = messages;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getChatOwnerId() {
        return ownerId;
    }

    public void setChatOwner(int ownerId) {
        this.ownerId = ownerId;
    }

    public List<Message> getMassages() {
        return messages;
    }

    public void setMassages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return id == chat.id && Objects.equals(name, chat.name) && Objects.equals(ownerId, chat.ownerId) && Objects.equals(messages, chat.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ownerId, messages);
    }
}
