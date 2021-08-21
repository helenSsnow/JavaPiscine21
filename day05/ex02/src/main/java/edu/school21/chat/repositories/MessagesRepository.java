package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public interface MessagesRepository{
    Optional<Message> findById(Long id) throws SQLException;
    void save(Message message) throws SQLException;

    void setConnection(HikariDataSource connection);
}
