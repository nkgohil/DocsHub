package thesevenitsolutions.com.docshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class otp extends AppCompatActivity {
    TextView resend;
    Button submit;
    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        allocatememory();
        setevent();
    }

    private void setevent() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otpintentt = new Intent(ctx,findhospital.class);
                startActivity(otpintentt);
            }
        });

    }

    private void allocatememory() {
        submit=findViewById(R.id.submit);
        resend=findViewById(R.id.resend);

    }
}
