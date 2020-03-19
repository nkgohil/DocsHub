package thesevenitsolutions.com.docshub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import com.astritveliu.boom.Boom;

public class doctorprofile extends AppCompatActivity {
    ImageButton bookappointment;
    ImageView docpersonalinfo,docworkingaddress;

    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorprofile);
        bookappointment=findViewById(R.id.bookappointment);
        new Boom(bookappointment);
        docpersonalinfo=findViewById(R.id.docpersonalinfo);
        new Boom(docpersonalinfo);
        docworkingaddress=findViewById(R.id.docworkingaddress);
        new Boom(docworkingaddress);


       ratingBar = findViewById(R.id.ratingbar1);
        ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = "Rating is :" + ratingBar.getRating();
                Toast.makeText(doctorprofile.this, rating, Toast.LENGTH_LONG).show();
            }
        });

    }
}
