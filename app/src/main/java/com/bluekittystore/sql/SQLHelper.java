package com.bluekittystore.sql;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;
import com.bluekittystore.MainActivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLHelper {
    private Connection connection;

    private final String host = MainActivity.databaseAddressIp;
    private final String database =  MainActivity.databaseName;
    private final int port =  MainActivity.databasePort;
    private final String user = MainActivity.databaseUser;
    private final String pass = MainActivity.databasePassword;
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

    public SQLHelper(Context context) {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
        Toast.makeText(context, "connection status:" + status, Toast.LENGTH_SHORT).show();
    }

    private void connect() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    System.out.println("connected:" + status);
                } catch (Exception e) {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }
    }

    public Connection getExtraConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ArrayList<String> getAllFromDB() { //TODO test function by sielus
        if (connection != null) {
            try {
                int SDK_INT = android.os.Build.VERSION.SDK_INT;
                if (SDK_INT > 8) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    ArrayList<String> myData = new ArrayList<>();
                    Statement connectionStatement = connection.createStatement();
                    ResultSet resultSet = connectionStatement
                            .executeQuery("SELECT * FROM SIELUSTESTTABLE");
                    while (resultSet.next()) {
                        myData.add(resultSet.getString(2));
                    }
                    return myData;
                }
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
                return null;
            }
        } else {
            return null;
        }
        return null;
    }
}
