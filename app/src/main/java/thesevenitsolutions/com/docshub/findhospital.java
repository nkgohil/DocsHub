package thesevenitsolutions.com.docshub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import androidx.appcompat.app.AppCompatActivity;

public class findhospital extends AppCompatActivity{
    Spinner spn;
    Context ctx=this;
    TextView txthospitalname,txthopitaltype;
    ImageView imghospital,back;
    private ArrayList<spinner> goodModelArrayList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findhospital);
        allocatememory();
        setevent();



    }


    private void setevent(){
        SearchView.OnQueryTextListener querytext =new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newtext) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText.trim();
                return true;
            }
        };
      //  SearchView.setOnQueryTextListener(querytext);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backintent=new Intent(ctx,homescreen.class);
                startActivity(backintent);
            }
        });


    }

    private void allocatememory() {
        txthopitaltype=findViewById(R.id.txthospitaltype);
        txthospitalname=findViewById(R.id.txthospitalname);
        imghospital=findViewById(R.id.imghospital);
        spn=findViewById(R.id.spn);
        back=findViewById(R.id.back);
               // String spinnertext = spn.getSelectedItem().toString();
    }
}
