package com.bluekittystore;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Toast;

import com.bluekittystore.sql.SQLHelper;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {
    public static String databaseAddressIp;
    public static String databaseName;
    public static int databasePort;
    public static String databaseUser;
    public static String databasePassword;

    public static SQLHelper sqlHelper;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getConfigValue();
        sqlHelper = new SQLHelper(this);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_shop, R.id.nav_about_us,R.id.nav_cart)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                onSettingsMenuClick();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void onSettingsMenuClick() {
        Toast.makeText(this, "Settings test", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void getConfigValue() {
        Resources resources = this.getResources();
        try {
            InputStream rawResource = resources.openRawResource(R.raw.config);
            Properties properties = new Properties();
            properties.load(rawResource);
            databaseAddressIp = properties.getProperty("dbIp");
            databasePort = Integer.parseInt(properties.getProperty("dbPort"));
            databaseName = properties.getProperty("dbName");
            databaseUser = properties.getProperty("dbUser");
            databasePassword = properties.getProperty("dbPassword");

        } catch (Resources.NotFoundException e) {
            Log.e("config", "Unable to find the config file: " + e.getMessage());
        } catch (IOException e) {
            Log.e("config", "Failed to open config file.");
        }
    }
}