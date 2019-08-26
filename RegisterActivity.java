package com.thebe_smith.betterbudget;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.thebe_smith.betterbudget.Profile;
import com.example.thebe_smith.betterbudget.R;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etPhone = (EditText) findViewById(R.id.etPhone);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final TextView cancel = (TextView) findViewById(R.id.cancel);
        final Button bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (  ( etName.getText().toString().equals(""))
                        || ( etUsername.getText().toString().equals(""))
                        || ( etPassword.getText().toString().equals("") )
                        || ( etPhone.getText().toString().equals(""))
                        || ( etEmail.getText().toString().equals("") ))
                {
                    Toast.makeText(RegisterActivity.this, "Please fill all fields", Toast.LENGTH_LONG).show();
                }
                else {
                    EditText etName = (EditText) findViewById(R.id.etName);
                    final String name = etName.getText().toString();
                    final String username = etUsername.getText().toString();
                    final String password = etPassword.getText().toString();
                    final String phone = etPhone.getText().toString();
                    final String email = etEmail.getText().toString();

                    Intent i = new Intent(RegisterActivity.this, Profile.class);
                    i.putExtra("name", name);
                    i.putExtra("username", username);
                    i.putExtra("phone", phone);
                    i.putExtra("email", email);
                    startActivity(i);
                    DBHelper helper = new DBHelper(getBaseContext());
                    SQLiteDatabase db = helper.getReadableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("Name", name);
                    values.put("UserName", username);
                    values.put("Password", password);
                    values.put("Phone", phone);
                    values.put("Email", email);
                    db.insert("Users", null, values);
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    RegisterActivity.this.startActivity(intent);
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                RegisterActivity.this.startActivity(registerIntent);
            }
        });
    }
}