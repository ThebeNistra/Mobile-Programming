package com.thebe_smith.betterbudget;
import com.example.thebe_smith.betterbudget.PieChartActivity;
import com.example.thebe_smith.betterbudget.Profile;
import com.example.thebe_smith.betterbudget.R;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class UserAreaActivity extends AppCompatActivity {
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_user_area);

                final Button Incomebutton = (Button) findViewById(R.id.Incomebutton);
                final Button Spendingbutton = (Button) findViewById(R.id.Spendingbutton);
                final Button Profilebutton = (Button) findViewById(R.id.Profilebutton);
                final Button PieChartbutton = (Button) findViewById(R.id.PieChartButton);
                final Button logout = (Button) findViewById(R.id.logout);

                Incomebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent incomeIntent = new Intent(UserAreaActivity.this, Income.class);
                        UserAreaActivity.this.startActivity(incomeIntent);
                    }
                });
                Spendingbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent spendingIntent = new Intent(UserAreaActivity.this, Spending.class);
                        UserAreaActivity.this.startActivity(spendingIntent);
                    }
                });
                Profilebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent profileIntent = new Intent(UserAreaActivity.this, Profile.class);
                        UserAreaActivity.this.startActivity(profileIntent);
                    }
                });
                PieChartbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent PieChartIntent = new Intent(UserAreaActivity.this, PieChartActivity.class);
                        UserAreaActivity.this.startActivity(PieChartIntent);
                    }
                });
                logout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent logoutIntent = new Intent(UserAreaActivity.this, LoginActivity.class);
                        UserAreaActivity.this.startActivity(logoutIntent);
                    }
                });

            }
        }
