package com.test;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.navigation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TabbedActivity.class));
            }
        });
        findViewById(R.id.scroll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScrollingActivity.class));
            }
        });


    }


    public static class Adapter extends RecyclerView.Adapter<MainActivity.Adapter.Holder> {

        private Context context;

        public Adapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(context);
            return new Holder(layoutInflater.inflate(R.layout.text, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            holder.tv.setText(String.format("%d  milad", position));
        }

        @Override
        public int getItemCount() {
            return 100;
        }

        public static class Holder extends RecyclerView.ViewHolder {
            public TextView tv;

            public Holder(View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.textView);
            }
        }
    }
}
