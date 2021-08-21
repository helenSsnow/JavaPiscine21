package edu.school21.chat.app;

import edu.school21.chat.models.Chat;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.settings.ExecDataBase;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        ExecDataBase connectDb =
           new ExecDataBase("jdbc:postgresql://localhost:5432/postgres", "postgres", "7V3ydasi120495/");
        Statement statement = connectDb.execDataBase();

        User creator = new User(1, "katya", "111", new ArrayList(), new ArrayList());
        User author = creator;
        Chat chat = new Chat(1, "aaa", creator.getId(), new ArrayList());
        Message message = new Message(6L, author.getId(), chat.getId(), "hello!", new Timestamp(System.currentTimeMillis()));

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(statement);
        messagesRepository.setConnection(connectDb.getDataSource());
        messagesRepository.save(message);
        Optional<Message> optMessage = messagesRepository.findById(message.getId());
        if(optMessage != null) {
            optMessage.get().printMessage();
        }
    }

}
