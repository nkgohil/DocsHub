package thesevenitsolutions.com.docshub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;

public class finddoctor extends AppCompatActivity {
    TableLayout tabledoc;
    Context ctx=this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finddoctor);
        allocatememory();
        setevent();

    }

    private void setevent() {
        tabledoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ctx,doctorprofile.class));
            }
        });
    }

    private void allocatememory() {
        tabledoc=findViewById(R.id.tabledoc);

    }

}
