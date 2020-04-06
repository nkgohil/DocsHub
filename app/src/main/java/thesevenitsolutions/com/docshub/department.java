package thesevenitsolutions.com.docshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class department extends AppCompatActivity {
    Context ctx=this;
    ImageView backbu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        allocatememory();
        setevents();

    }

    private void setevents() {
        backbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ctx,homescreen.class));
            }
        });
    }

    private void allocatememory() {
        backbu=findViewById(R.id.backbu);

    }
}
