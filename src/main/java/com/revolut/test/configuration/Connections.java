package com.revolut.test.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

public class Connections {

    private static final Logger log = LoggerFactory.getLogger(Connections.class);

    private static ThreadLocal<Connection> currentConnection = new ThreadLocal<>();

    private static BasicConnectionPool connectionPool;

    static {
        try {
            connectionPool = BasicConnectionPool
                    .create();
        } catch (SQLException e) {
            log.error(Arrays.toString(e.getStackTrace()));
        }

    }

    public static Connection getConnection() throws SQLException {
        Connection conn = currentConnection.get();
        if (conn == null) {
            conn = connectionPool.getConnection();
            currentConnection.set(conn);
            System.out.println(Thread.currentThread().getId() + " get conn " + conn);
        }

        return conn;
    }

    public static void closeConnection() {
        Connection conn = currentConnection.get();
        if (conn != null) {

            try {
                conn.commit();
                System.out.println(Thread.currentThread().getId() + " rel conn " + conn);
                connectionPool.releaseConnection(conn);
                currentConnection.set(null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
