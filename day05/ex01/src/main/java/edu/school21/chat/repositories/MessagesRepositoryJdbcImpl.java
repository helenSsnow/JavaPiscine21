package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;

import javax.swing.text.html.Option;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private Statement statement;
    private Long id;
    private int authorId;
    private int chatId;
    private String text;
    private Date dateTime;

    public MessagesRepositoryJdbcImpl(Statement statement) {
        this.statement = statement;
    }

    public int getResultSetRowCount() throws SQLException {
        ResultSet rs = statement.executeQuery("select count(*) from messages where id > 1");
        int size = 0;
        while (rs.next()) {
            size = rs.getInt("count");
        }
        return size;
    }

    @Override
    public Optional<Message> findById(Long id) {

        try {
            int size = getResultSetRowCount();
            ResultSet rs = statement.executeQuery("SELECT * FROM messages");
            while (rs.next()) {
                this.id = rs.getLong("id");
                if(id > size) {
                    System.err.println("Incorrect id");
                    return null;
                }
                this.authorId = rs.getInt("authorId");
                this.chatId = rs.getInt("chatId");
                this.text = rs.getString("text");
                this.dateTime = rs.getTime("date");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.of(new Message(id, authorId, chatId, text, dateTime));
    }
}
