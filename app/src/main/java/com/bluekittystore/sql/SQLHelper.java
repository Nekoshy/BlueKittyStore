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

    private static final String host = MainActivity.databaseAddressIp;
    private static final String database = MainActivity.databaseName;
    private static final int port = MainActivity.databasePort;
    private static final String user = MainActivity.databaseUser;
    private static final String pass = MainActivity.databasePassword;
    private static String url = "jdbc:postgresql://%s:%d/%s";
    private boolean connectionStatus = false;
    private Context context;

    public SQLHelper(Context context) {
        this.context = context;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        new Thread(){
            @Override
            public void run() {
                SQLHelper.url = String.format(SQLHelper.url, SQLHelper.host, SQLHelper.port, SQLHelper.database);
                connect();
            }
        }.start();
    };

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, user, pass);

            connectionStatus = true;
            System.out.println("connected:" + connectionStatus);

        } catch (Exception e) {
            connectionStatus = false;
            System.out.println("connected:" + connectionStatus);
            System.out.print(e.getMessage());
            e.printStackTrace();
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
        if (connection != null && connectionStatus) {
            try {
                int SDK_INT = android.os.Build.VERSION.SDK_INT;
                if (SDK_INT > 8) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    ArrayList<String> myData = new ArrayList<>();
                    Statement connectionStatement = connection.createStatement();
                    ResultSet resultSet = connectionStatement
                            .executeQuery("SELECT * FROM TESTDATA");
                    while (resultSet.next()) {
                        myData.add(resultSet.getString(1));
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
