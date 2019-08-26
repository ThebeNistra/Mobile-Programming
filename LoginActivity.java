package com.thebe_smith.betterbudget;
import com.example.thebe_smith.betterbudget.Profile;
import com.example.thebe_smith.betterbudget.R;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final TextView tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        final SharedPreferences prefs = getDefaultSharedPreferences(this);
   
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              EditText etUsername = (EditText) findViewById(R.id.etUsername);
              final String username = etUsername.getText().toString();
              final String password = etPassword.getText().toString();
             
		      DBHelper helper = new DBHelper(getBaseContext());
              SQLiteDatabase db = helper.getReadableDatabase();
              Cursor cursor=db.query("Users", null, " UserName=?", new String[]{username}, null, null, null);
              if(cursor.getCount()<1) // UserName Not Exist
                {
                    Toast.makeText(LoginActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                    cursor.close();
                }else {
                    cursor.moveToFirst();
                    String storedPassword = cursor.getString(cursor.getColumnIndex("Password"));
                    int userId = cursor.getInt(cursor.getColumnIndex("User_id"));
                    cursor.close();
                    // check if the Stored password matches with  Password entered by user
                    if (password.equals(storedPassword)) {
                        Toast.makeText(LoginActivity.this, "Congrats: Login Successful", Toast.LENGTH_LONG).show();

                        prefs.edit().putInt("user_Id", userId).commit();
                        Intent intent = new Intent(LoginActivity.this, UserAreaActivity.class);
                        LoginActivity.this.startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                    }
                }
            Intent i=new Intent(LoginActivity.this,Profile.class);
            i.putExtra("username",username);
            }
        });
        tvRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
    }
}