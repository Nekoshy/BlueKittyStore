package com.bluekittystore.sql;

import android.content.Context;
import android.widget.Toast;

import com.bluekittystore.MainActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLHelper {
    private Connection connection;

    private final String host = MainActivity.databaseAdressIp;
    private final String database = "postgres";
    private final int port = 5432;
    private final String user = "postgres";
    private final String pass = "1234";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

    public SQLHelper(Context context) {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
        Toast.makeText(context,"connection status:" + status,Toast.LENGTH_SHORT).show();
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

    public Connection getExtraConnection(){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }

    public ArrayList<String> getAllFromDB(){
        if(connection != null){
            try {
                ArrayList<String> myData = new ArrayList<>();
                Statement connectionStatement = connection.createStatement();
                ResultSet resultSet = connectionStatement.executeQuery("SELECT * FROM SIELUSTESTTABLE");
                while (resultSet.next()){
                    myData.add(resultSet.getString(1));
                }
                return myData;
            }catch (Exception e){
                e.getMessage();
            }
        }else {
            return null;
        }
        return null;
    }
}
