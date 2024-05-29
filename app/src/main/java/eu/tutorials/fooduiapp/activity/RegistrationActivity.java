package eu.tutorials.fooduiapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import eu.tutorials.fooduiapp.R;
import eu.tutorials.fooduiapp.activity.LoginActivity;

public class RegistrationActivity extends AppCompatActivity {

    TextView txt_sign_in_regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        anhXa();
        xuLy();
    }

    private void xuLy() {
        txt_sign_in_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void anhXa() {
        txt_sign_in_regis = findViewById(R.id.txt_sign_in_regis);

    }
}