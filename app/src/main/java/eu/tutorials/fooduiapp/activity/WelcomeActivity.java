package eu.tutorials.fooduiapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import eu.tutorials.fooduiapp.R;
import eu.tutorials.fooduiapp.activity.LoginActivity;
import eu.tutorials.fooduiapp.activity.RegistrationActivity;

public class WelcomeActivity extends AppCompatActivity {
    Button btn_regis_splash;
    TextView txt_sign_in_splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        anhXa();
        xuLy();
    }

    private void xuLy() {
        btn_regis_splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });
        txt_sign_in_splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void anhXa() {
        btn_regis_splash = findViewById(R.id.btn_regis_splash);
        txt_sign_in_splash = findViewById(R.id.txt_sign_in_splash);
    }
}