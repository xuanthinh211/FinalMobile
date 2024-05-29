package eu.tutorials.fooduiapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import eu.tutorials.fooduiapp.MainActivity;
import eu.tutorials.fooduiapp.R;

public class LoginActivity extends AppCompatActivity {

    TextView txt_register_login;
    Button btn_sign_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhXa();
        xuLy();
    }

    private void xuLy() {
        txt_register_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });
        btn_sign_splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void anhXa() {
        txt_register_login = findViewById(R.id.txt_register_login);
        btn_sign_splash = findViewById(R.id.btn_sign_splash);
    }
}