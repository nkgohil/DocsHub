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
        fetchJSON();


    }

    private void fetchJSON() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(SpinnerInterface.JSONURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        SpinnerInterface api = retrofit.create(SpinnerInterface.class);

        Call<String> call = api.getJSONString();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
               boolean a=false;
                if(a==true){
                Log.i("Responsestring", response.body().toString());
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();
                        spinJSON(jsonresponse);

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void spinJSON(String response){

        try {

            JSONObject obj = new JSONObject(response);
            if(obj.optString("status").equals("true")){

                goodModelArrayList = new ArrayList<>();
                JSONArray dataArray  = obj.getJSONArray("city");

                for (int i = 0; i < dataArray.length(); i++) {

                    spinner spinnerModel = new spinner();
                    JSONObject dataobj = dataArray.getJSONObject(i);

                    spinnerModel.setCity(dataobj.getString("city"));

                    goodModelArrayList.add(spinnerModel);
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

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
