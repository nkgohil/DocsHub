package thesevenitsolutions.com.docshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgetpassword extends AppCompatActivity {
    Button sendotp;
    Context ctx=this;
    EditText email;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        allocatememory();
        setevent();
    }

    private void setevent() {
        sendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(email.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Enter email address",Toast.LENGTH_SHORT).show();
                }else {
                    if (email.getText().toString().trim().matches(emailPattern)) {
                        Intent verify=new Intent(ctx,verifyotp.class);
                        startActivity(verify);
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private void allocatememory() {
        sendotp=findViewById(R.id.btnsendotp);
        email=findViewById(R.id.email);
    }


}
