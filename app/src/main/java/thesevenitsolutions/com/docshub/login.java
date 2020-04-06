package thesevenitsolutions.com.docshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.astritveliu.boom.Boom;


public class login extends AppCompatActivity {
    Button button,forgetpassword;
    Context ctx=this;
    String name;
    TextView txtsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        allocatememory();
        setevent();
    }

    private void setevent() {
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent passwordintent=new Intent(ctx,forgetpassword.class);
                startActivity(passwordintent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiInterface apiService = apIclient.getClient().create(apiInterface.class);
                Intent loginintent=new Intent(ctx,otp.class);
                startActivity(loginintent);
                finish();
            }
        });
        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinintent=new Intent(ctx,signup.class);
                startActivity(signinintent);

            }
        });
    }

    private void allocatememory() {
        button=findViewById(R.id.login);
        new Boom(button);
        txtsignup=findViewById(R.id.txtsignup);
        forgetpassword=findViewById(R.id.forgetpassword);
    }
}
