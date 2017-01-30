package com.hyugnmin.android.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class WidgetActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    //1. 컴파운드 계열 버튼 작성
    ToggleButton tb;
    CheckBox cbApple;
    CheckBox cbBanana;
    CheckBox CbCherry;

    RadioGroup radioGroup;
    Spinner spinner;
    SeekBar seekBar;
    TextView seekTv;
    ArrayList<String> months = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        tb = (ToggleButton) findViewById(R.id.togPower);
        //토글버튼용 리스너를 달아준다.
        tb.setOnCheckedChangeListener(this);

        cbApple = (CheckBox) findViewById(R.id.cbApple);
        cbBanana = (CheckBox) findViewById(R.id.cbBanana);
        CbCherry = (CheckBox) findViewById(R.id.CbCherry);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        //
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int button_id) {
                switch (button_id) {
                    case R.id.RbAnaconda:
                        Toast.makeText(WidgetActivity.this, "Anaconda 라디오 버튼", Toast.LENGTH_SHORT).show();

                    case R.id.RbBear:
                        Toast.makeText(WidgetActivity.this, "Bear 라디오 버튼", Toast.LENGTH_SHORT).show();

                    case R.id.RbCat:
                        Toast.makeText(WidgetActivity.this, "Cat 라디오 버튼", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //-3. 스피너에 들어갈 데이터를 동적으로 정의하세요. 데이터 = 올해부터 100년전까지.
        //month [0] = "1917"; ArrayList<String> year = new ArrayList<>();
        for(int i = 1; i <=100; i++) {
            months.add(i-1, 2018-i + "");}

        //3. 스피너
    spinner = (Spinner) findViewById(R.id.spinner);

        //3.1 스피너 데이터 등록
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, months);
                                                                //컨텍스트 , 스피너에서 사용할 레이아웃, 배열데이터
        //3.2 스피너에 아답터 등록
        spinner.setAdapter(adapter);
        //3.3 스피너 리스너에 등록
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(WidgetActivity.this, "선택된 아이템" + months.get(position), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(WidgetActivity.this, "아무것도 선택안됨", Toast.LENGTH_SHORT).show();
            }
        });



        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekTv = (TextView) findViewById(R.id.seekValue);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean FromUser) {
                    seekTv.setText(progress+""); //setText에 숫자값만 던져주면 에러가 안나고 그냥 앱이 죽는다.
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void onCheckedChanged(CompoundButton cb, boolean flag) {

        switch(cb.getId()) {

            case R.id.togPower:
            Toast.makeText(this, "토글=" + flag, Toast.LENGTH_SHORT).show();
                break;
        }


    }
}

