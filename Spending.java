package com.thebe_smith.betterbudget;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.thebe_smith.betterbudget.R;

public class Spending extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending);

        final EditText ItemAmount = (EditText) findViewById(R.id.ItemAmount);
        final Button AddSpending = (Button) findViewById(R.id.AddSpending);
        final Spinner dropdown = (Spinner) findViewById(R.id.spinner);
     
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(Spending.this,android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.items));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        final Integer userId = prefs.getInt("user_Id", -1);

        AddSpending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String item = ItemAmount.getText().toString();

                if ((ItemAmount.getText().toString().equals("")))
                {
                    Toast.makeText(Spending.this, "Please add amount", Toast.LENGTH_LONG).show();
                }
                else
                {
                    int itemInt = Integer.parseInt(item);
                    DBHelper helper = new DBHelper(getBaseContext());
                    SQLiteDatabase db = helper.getReadableDatabase();
                    ContentValues updateValues = new ContentValues();
                    String selectedType = dropdown.getSelectedItem().toString();

                    if (selectedType.equals("Food")) {
                        updateValues.put("Food", itemInt);
                        db.update("Users", updateValues, "User_id=?", new String[]{userId.toString()});
                    } else if (selectedType.equals("Travel")) {
                        updateValues.put("Travel", itemInt);
                        db.update("Users", updateValues, "User_id=?", new String[]{userId.toString()});
                    } else if (selectedType.equals("Entertainment")) {
                    } else if (selectedType.equals("Entertainment")) {
                        updateValues.put("Entertainment", itemInt);
                        db.update("Users", updateValues, "User_id=?", new String[]{userId.toString()});
                    }
                    Intent spendingIntent = new Intent(Spending.this, UserAreaActivity.class);
                    Spending.this.startActivity(spendingIntent);
                }
            }
        });
    }
}