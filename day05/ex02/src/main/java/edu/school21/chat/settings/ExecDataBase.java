package edu.school21.chat.settings;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecDataBase {
    private final String url;
    private final String user;
    private final String password;
    private HikariDataSource dataSource;
    private Connection connection;

    public ExecDataBase(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }
    private void makeHikari() {
        // Создаем экземпляр класса
        HikariConfig hikariConfig = new HikariConfig();
        // Устанавливаем url
        hikariConfig.setJdbcUrl(url);
        // Учетная запись базы данных
        hikariConfig.setUsername(user);
        // Пароль базы данных
        hikariConfig.setPassword(password);
        dataSource = new HikariDataSource(hikariConfig);

    }

    public Statement execDataBase() throws SQLException {
        makeHikari();
        connection = dataSource.getConnection();
        String data = null;
        String schema = null;
        try {
            data = new String(Files.readAllBytes(Paths.get("./src/main/resources/data.sql")));
            schema = new String(Files.readAllBytes(Paths.get("./src/main/resources/schema.sql")));
        } catch ( IOException e) {
            e.printStackTrace();
        }

        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(schema);
//            statement.executeUpdate(data);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return statement;
    }
    public HikariDataSource getDataSource() {
        return dataSource;
    }
}
