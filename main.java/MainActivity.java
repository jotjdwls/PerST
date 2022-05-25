package com.example.perst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Home_TodoList todo;
    Timer timer;
    Calculator calc;
    Translator trans;
    WhiteNoise noise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todo = new Home_TodoList();
        timer = new Timer();
        calc = new Calculator();
        trans = new Translator();
        noise = new WhiteNoise();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, todo).commit();
        BottomNavigationView bottom_menu = findViewById(R.id.bottom_menu);
        bottom_menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.todo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, todo).commit();
                        return true;
                    case R.id.timer:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, timer).commit();
                        return true;
                    case R.id.calculator:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, calc).commit();
                        return true;
                    case R.id.translator:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, trans).commit();
                        return true;
                    case R.id.whitenoise:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, noise).commit();
                        return true;
                }
                return false;
            }
        });
    }
}