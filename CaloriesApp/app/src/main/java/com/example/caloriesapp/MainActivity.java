package com.example.caloriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userId, password, name;
    Button register, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(userId.getText().toString());
                userEntity.setPassword(password.getText().toString());
                userEntity.setName(name.getText().toString());
                if(validateInput(userEntity)){
                    Database database = Database.getAppDatabase(getApplicationContext());
                    UserDao userDao = database.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User Registered!", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });
    }

    private Boolean validateInput(UserEntity userEntity){
        if(userEntity.getName().isEmpty() || userEntity.getPassword().isEmpty()){
            return false;
        }
        return true;
    }
}