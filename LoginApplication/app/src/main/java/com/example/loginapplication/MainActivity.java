package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText email=findViewById(R.id.EmailAddress);
        EditText password=findViewById(R.id.Password);
        TextView erroremail=findViewById(R.id.erroremail);
        TextView errorpassword=findViewById(R.id.errorpassword);
        TextView signup=findViewById(R.id.signup);
        Button login=findViewById(R.id.login);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Sign_up.class);
                startActivity(intent);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("Humoyun") && password.getText().toString().equals("1504")) {
                    Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                    startActivity(intent);
                    finish();
                }else if (email.getText().toString().equals("") && password.getText().toString().equals("")) {
                    erroremail.setText("*Email field empty !!!");
                    errorpassword.setText("*Password field empty !!!");
                }else if(email.getText().toString().equals("") && !password.getText().toString().equals("")){
                    erroremail.setText("*Email field empty !!!");
                    errorpassword.setText("");
                }else if(!email.getText().toString().equals("") && password.getText().toString().equals("")){
                    erroremail.setText("");
                    errorpassword.setText("*Password field empty !!!");
                }else{
                    erroremail.setText("*Error email !!!");
                    errorpassword.setText("* Error password !!!");
                }

            }
        });
    }
    @Override
    public void onBackPressed() {
        Dialog dialog = new Dialog(this);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations= android.R.style.Animation_Dialog;
            dialog.setContentView(R.layout.exit_dialog);
        dialog.show();
        ImageButton yes_btn=dialog.findViewById(R.id.btn_yes);
        ImageButton no_btn=dialog.findViewById(R.id.btn_no);

        yes_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
        no_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }
}