package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.settings.ExecDataBase;

import javax.swing.text.html.Option;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private Statement statement;
    private Long id;
    private Long authorId;
    private Long chatId;
    private String text;
    private Timestamp dateTime;
    private HikariDataSource hikSourse;

    public MessagesRepositoryJdbcImpl(Statement statement) {
        this.statement = statement;
    }

    public int getResultSetRowCount() throws SQLException {
        ResultSet rs = statement.executeQuery("select count(*) from messages where id >= 1");
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
                    System.err.println("Incorrect id, message id need to be  " + (size + 1));
                    return null;
                }
                this.authorId = rs.getLong("authorId");
                this.chatId = rs.getLong("chatId");
                this.text = rs.getString("text");
                this.dateTime = rs.getTimestamp("date");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.of(new Message(id, authorId, chatId, text, dateTime));
    }

    @Override
    public void save(Message message) throws SQLException {

        PreparedStatement preparedStatement;
        Connection connection = hikSourse.getConnection();
        id = message.getId();
        authorId = message.getAuthorId();
        chatId = message.getChatId();
        text = message.getText();
        dateTime = message.getDateTime();
        String sql = "INSERT INTO messages (id, authorId, chatId, text, date) VALUES (" + id + ", " + authorId + ", " + chatId + ", \'" + text + "\', \'" + dateTime + "\');";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void setConnection(HikariDataSource connection) {
        this.hikSourse = connection;
    }


}
