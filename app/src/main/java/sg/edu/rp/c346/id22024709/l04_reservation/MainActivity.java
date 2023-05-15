package sg.edu.rp.c346.id22024709.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tvName;
    EditText tvPhone;
    EditText tvSize;
    DatePicker dp;
    TimePicker tp;
    RadioGroup rgArea;
    RadioButton radioSmoke;
    RadioButton radioNoSmoke;
    Button btnReserve;
    Button btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
        tvSize =  findViewById(R.id.tvSize);
        dp =  findViewById(R.id.dp);
        tp = findViewById(R.id.tp);
        rgArea = findViewById(R.id.rgArea);
        radioSmoke =  findViewById(R.id.radioSmoke);
        radioNoSmoke =  findViewById(R.id.radioNoSmoke);
        btnReserve = findViewById(R.id.btnReserve);
        btnReset =  findViewById(R.id.btnReset);

        dp.updateDate(2020,5,1);
        tp.setHour(19);
        tp.setMinute(30);
        radioNoSmoke.setChecked(true);
        radioSmoke.setChecked(false);
        tvName.findFocus();
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2020,5,1);
                tp.setHour(19);
                tp.setMinute(30);
                radioNoSmoke.setChecked(true);
                radioSmoke.setChecked(false);
                tvName.getText().clear();
                tvPhone.getText().clear();
                tvSize.getText().clear();
            }
        });
        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String area = "";
                if (radioNoSmoke.isChecked()){
                    area += "Non-smoking area";
                } else {
                    area +="Smoking area";
                }

                Toast.makeText(MainActivity.this, "Reserved under: "+tvName.getText()+'\n'
                 +"Phone Number: "+tvPhone.getText()+"\n"+"Group size: "+tvSize.getText()+"\n"
                 +"Reservation date: " + dp.getDayOfMonth()+"/"+(dp.getMonth()+1)+"/"+dp.getYear()+"\n"
                  + "Time reserved: "+tp.getHour()+":"+tp.getMinute()+"\n"
                  + "Area Type: "+area+"\n \n"+"RESERVATION CONFIRMED", Toast.LENGTH_LONG).show();
            }
        });

    }
}