package com.lz.d_livedata;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.lz.d_livedata.vm.NameViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test1Activity extends AppCompatActivity {

    private NameViewModel nameVM;
    private TextView tvName;
    List<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        names.add("张三丰");
        names.add("德玛西亚");
        names.add("寒冰射手");
        names.add("九尾妖狐");

        tvName = findViewById(R.id.tv_name);


        //注意这里使用了拓展包 androidx.lifecycle:lifecycle-extensions
        nameVM = new ViewModelProvider(this).get(NameViewModel.class);

        findViewById(R.id.tv_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = new Random().nextInt(names.size());
                nameVM.getCurrentName().postValue(names.get(i));
            }
        });

        nameVM.getCurrentName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvName.setText(s);
            }
        });

    }

}
