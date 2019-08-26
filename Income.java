package com.thebe_smith.betterbudget;
import com.example.thebe_smith.betterbudget.R;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Income extends AppCompatActivity {

    private String username = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        final EditText etIncome = (EditText) findViewById(R.id.etIncome);
        final Button IncomeAdd = (Button) findViewById(R.id.IncomeAdd);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        final Integer userId = prefs.getInt("user_Id", -1);
        IncomeAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText etIncome = (EditText) findViewById(R.id.etIncome);
                if (  ( etIncome.getText().toString().equals("")))
                {
                    Toast.makeText(Income.this, "Please add income", Toast.LENGTH_LONG).show();
                }
                else
            {
                final String income = etIncome.getText().toString();
                int incomeInt = Integer.parseInt(income);
                DBHelper helper = new DBHelper(getBaseContext());
                SQLiteDatabase db = helper.getReadableDatabase();
                ContentValues updateValues = new ContentValues();
                updateValues.put("Income", incomeInt);
                db.update("Users", updateValues, "User_id=?", new String[]{userId.toString()});
                Intent intent = new Intent(Income.this, UserAreaActivity.class);
                Income.this.startActivity(intent);
            }
            }
        });
    }
}