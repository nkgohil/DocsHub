package thesevenitsolutions.com.docshub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import thesevenitsolutions.com.docshub.R;
import thesevenitsolutions.com.docshub.pojo.hospital;

public class hospitalAdapter extends RecyclerView.Adapter {
    private Context ctx;
    private ArrayList<hospital> hospitalArrayList;

    public hospitalAdapter(Context ctx, ArrayList<hospital> hospitalArrayList) {
        this.ctx = ctx;
        this.hospitalArrayList = hospitalArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyWidgetContainer(LayoutInflater.from(ctx).inflate(R.layout.row_findhospital, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyWidgetContainer container = (MyWidgetContainer) holder;
        hospital c = hospitalArrayList.get(position);
        container.txthospitalname.setText(c.getName());
        container.txthospitaltype.setText(c.getDepartment());

    }

    @Override
    public int getItemCount() {
        if (hospitalArrayList!=null)
            return hospitalArrayList.size();
        return 0;
    }

    private class MyWidgetContainer extends RecyclerView.ViewHolder {
        TextView txthospitalname,txthospitaltype;

        public MyWidgetContainer(@NonNull View itemView) {
            super(itemView);
            txthospitalname=itemView.findViewById(R.id.txthospitalname);
            txthospitaltype=itemView.findViewById(R.id.txthospitaltype);
        }
    }
}
