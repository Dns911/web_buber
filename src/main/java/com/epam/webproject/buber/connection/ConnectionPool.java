package com.epam.webproject.buber.connection;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static Logger logger = LogManager.getLogger();
    private static Lock locker = new ReentrantLock();
    private static ConnectionPool poolInstance;
    private static final int POOL_SIZE = 4;
    private BlockingQueue<ProxyConnection> queue = new LinkedBlockingQueue<>();

    static {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Registry driver exception: {}", e.getErrorCode());
        }
    }

    private ConnectionPool() {

        try  {
            String url = "jdbc:mysql://localhost:3306/buber_db";
            Properties prop = new Properties();
            prop.put("user", "root");
            prop.put("password", "Den_6394264");


            this.queue = new LinkedBlockingQueue<>();
            for (int i = 0; i < POOL_SIZE; i++) {
                try {
                    queue.offer(new ProxyConnection(DriverManager.getConnection(url, prop)));
                } catch (SQLException e) {
                    logger.log(Level.ERROR, "Get connection exception {}", e.getErrorCode());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static ConnectionPool getInstance() {
        if (poolInstance == null) {
            try {
                locker.lock();
                if (poolInstance == null) {
                    poolInstance = new ConnectionPool();
                }
            } finally {
                locker.unlock();
            }
        }
        return poolInstance;
    }

    public ProxyConnection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = this.queue.take();
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, "Get connection exception: {}", e.getMessage());
        }
        return connection;
    }

    public void returnConnection(Connection connection) {
        try {
            if (connection instanceof ProxyConnection) {
                ProxyConnection proxy = (ProxyConnection) connection;
                queue.put(proxy);
            } else {
                //
            }
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, "Return connection exception: {}", e.getMessage());
        }
    }

    public void deregisterDriver() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.log(Level.ERROR, "Deregistry driver exception: {}", e.getErrorCode());
            }
        });
    }

    public void destroyPool() {
        this.queue.forEach(connection -> {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.log(Level.ERROR, "Close connection exception: {}", e.getErrorCode());
            }
        });

    }
}
