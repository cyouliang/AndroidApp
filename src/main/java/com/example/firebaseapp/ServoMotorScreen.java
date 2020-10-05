package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ServoMotorScreen extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    final DatabaseReference ServoMotor = myRef.child("ServoMotor").child("input2");
    final DatabaseReference motorstatus = myRef.child("ServoMotor").child("status");

    private Button smBtn, settimeBtn;
    private TextView smTextView, smstatusTextView, smresultTextView;
    private AlarmManager alarmMgr;
    private EditText hrEditText, minTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servo_motor_screen);

        smBtn = (Button) findViewById(R.id.smBtn);
        smTextView = (TextView) findViewById(R.id.smTextView);
        smstatusTextView = (TextView) findViewById(R.id.smstatusTextView);
        smresultTextView = (TextView) findViewById(R.id.smresultTextView);
        hrEditText = (EditText) findViewById(R.id.hrEditText);
        settimeBtn = (Button) findViewById(R.id.settimeBtn);
        final EditText minEditText = (EditText) findViewById(R.id.minEditText);
        //alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        smBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServoMotor.setValue(1);
            }
        });

        motorstatus.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String status = dataSnapshot.getValue(String.class);
                Log.d("file", "Value is: " + status);
                smresultTextView.setText(status);
                if (status.equals("OFF"))
                    ServoMotor.setValue(0);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("file", "Failed to read value.", error.toException());
            }
        });

        settimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valueHr = hrEditText.getText().toString();
                String valueMin = minEditText.getText().toString();

            }
        });
    }
}