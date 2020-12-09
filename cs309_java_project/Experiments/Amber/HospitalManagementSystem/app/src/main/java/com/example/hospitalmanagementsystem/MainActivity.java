package com.example.hospitalmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button Register,Login;
    private EditText Username, Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Register = (Button)findViewById(R.id.button);
        Username = (EditText)findViewById(R.id.username);
        Password = (EditText)findViewById(R.id.password);
        Login = (Button)findViewById(R.id.button2);

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });

        Register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String name, String pword) {
        if(name.equals("Admin") && pword.equals("abc123")) {
            openInventory();
        }
        else if(name.equals("amberli@iastate.edu") && pword.equals("def987")){
            openRegister();
        }
    }

    public void openRegister() {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    public void openInventory() {
        Intent intent = new Intent(this, Inventory.class);
        startActivity(intent);
    }
}