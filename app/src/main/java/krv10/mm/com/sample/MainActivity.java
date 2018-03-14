package krv10.mm.com.sample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    OkHttpClient okHttpClient;
    Request request;
    FormBody formBody;

    List<Model> models;
    List<Datum> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=findViewById(R.id.recyclerview);

        okHttpClient=new OkHttpClient();

        formBody =new FormBody.Builder()
                .add("UserName","KL/180045")
                .add("BatchCode","DL/KL01/NWK/SFM/F-TECSD/18/B/3651")
                .build();

        request=new Request.Builder()
                .url("http://f-tec.skilllms.com/app/ws_lmslogin.asmx/ExternalMarks")
                .post(formBody)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                try {
                    String res=response.body().string();


                    Gson gson=new Gson();

                    final Table1 table1= gson.fromJson(res,Table1.class);



                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            rv.setAdapter(new Adapter(MainActivity.this,table1.getModel()));
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public class Adapter extends ExpandableRecyclerAdapter<Model,Datum,PViewHolder,CViewHolder> {

        private LayoutInflater mInflater;

        public Adapter(Context context,@NonNull List<Model> parentList) {
            super(parentList);

            mInflater=LayoutInflater.from(context);
        }

        @Override
        protected void parentExpandedFromViewHolder(int flatParentPosition) {
            super.parentExpandedFromViewHolder(flatParentPosition);
        }

        @Override
        protected void parentCollapsedFromViewHolder(int flatParentPosition) {
          //  super.parentCollapsedFromViewHolder(flatParentPosition);
        }

        @NonNull
        @Override
        public PViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
            View view = mInflater.inflate(R.layout.inflater2, parentViewGroup, false);
            return new PViewHolder(view);
        }

        @NonNull
        @Override
        public CViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
            View view2 = mInflater.inflate(R.layout.inflater, childViewGroup, false);
            return new CViewHolder(view2);
        }

        @Override
        public void onBindParentViewHolder(@NonNull PViewHolder parentViewHolder, int parentPosition, @NonNull Model parent) {

            parentViewHolder.modulename.setText(parent.getModuleName());
        }

        @Override
        public void onBindChildViewHolder(@NonNull CViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull Datum child) {

            childViewHolder.tv.setText(child.getPassingMarks());
        }
    }
}
