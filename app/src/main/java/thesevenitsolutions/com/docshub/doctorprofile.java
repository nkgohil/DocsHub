package thesevenitsolutions.com.docshub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import ru.slybeaver.slycalendarview.SlyCalendarDialog;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import com.astritveliu.boom.Boom;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class doctorprofile extends AppCompatActivity implements SlyCalendarDialog.Callback {
    Button bookappointment;
    ImageView docpersonalinfo,docworkingaddress;
    RatingBar ratingBar;
    Context ctx=this;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorprofile);
        allocatememory();
        setevent();



    }

    private void setevent() {
        docpersonalinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ctx,doctorpersonalinfo.class);
                startActivity(intent);

            }
        });
        ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = "Rating is :" + ratingBar.getRating();
                Toast.makeText(doctorprofile.this, rating, Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.bookappointment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SlyCalendarDialog()

                        .setSingle(true)
                        .setFirstMonday(false)
                        .setCallback(doctorprofile.this)
                        .setHeaderColor(getColor(R.color.splashscreenbackground))
                        .show(getSupportFragmentManager(), "TAG_SLYCALENDAR");
            }
        });
    }

    private void allocatememory() {
        bookappointment=findViewById(R.id.bookappointment);
        new Boom(bookappointment);
        docpersonalinfo=findViewById(R.id.docpersonalinfo);
        new Boom(docpersonalinfo);
        docworkingaddress=findViewById(R.id.docworkingaddress);
        new Boom(docworkingaddress);
       textview= findViewById(R.id.textview);
        ratingBar = findViewById(R.id.ratingbar1);
    }


    @Override
    public void onCancelled() {
    }

    @Override
    public void onDataSelected(Calendar firstDate, Calendar secondDate, int hours, int minutes) {
        if (firstDate != null) {
            if (secondDate == null) {
                firstDate.set(Calendar.HOUR_OF_DAY, hours);
                firstDate.set(Calendar.MINUTE, minutes);
                textview.setText(new SimpleDateFormat(getString(R.string.timeFormat), Locale.getDefault()).format(firstDate.getTime()));

            } else {
                Toast.makeText(
                        this,
                        getString(
                                R.string.period,
                                new SimpleDateFormat(getString(R.string.dateFormat), Locale.getDefault()).format(firstDate.getTime()),
                                new SimpleDateFormat(getString(R.string.timeFormat), Locale.getDefault()).format(secondDate.getTime())
                        ),
                        Toast.LENGTH_LONG

                ).show();
            }
        }
    }

}
