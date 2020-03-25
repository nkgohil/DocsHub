package thesevenitsolutions.com.docshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import thesevenitsolutions.com.docshub.prefrence;
public class splashscreen extends AppCompatActivity {

     Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        final boolean b = new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                if (prefrence.getInstance(ctx).isLoggedIn()) {
                    final Intent i = new Intent(ctx, homescreen.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    startActivity(new Intent(ctx,signup.class));
                    finish();
                }
            }
        }, 1000);
    }
}
