package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String password;
    private List<Chat> chats;
    private List<Chat> userChat;

    public User(int id, String login, String password, List<Chat> chats, List<Chat> userChat) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.chats = chats;
        this.userChat = userChat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

    public List<Chat> getUserChat() {
        return userChat;
    }

    public void setUserChat(List<Chat> userChat) {
        this.userChat = userChat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(chats, user.chats) && Objects.equals(userChat, user.userChat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, chats, userChat);
    }
}
