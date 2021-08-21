package edu.school21.chat.app;

import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.settings.ExecDataBase;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        ExecDataBase connectDb =
           new ExecDataBase("jdbc:postgresql://localhost:5432/postgres", "postgres", "7V3ydasi120495/");
        Statement statement = connectDb.execDataBase();

        while (true)
        {
            long id = scan.nextLong();
            if(id < 1){
                System.err.println("incorrect id");
            }
            if (id == 42)
                break;
            MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(statement);
            Optional<Message> optMessage = messagesRepository.findById(id);
            if(optMessage != null) {
                optMessage.get().printMessage();
            }


        }
    }

}
