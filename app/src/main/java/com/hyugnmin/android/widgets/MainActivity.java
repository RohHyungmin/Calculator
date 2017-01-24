package com.hyugnmin.android.widgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //1.위젯을 정의, 사용할 위젯의 변수를 선언한다.
    Button btn;
    Button tv;
    Button btn_cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //레이아웃 정의하는 함수
        //2. 정의된 위젯변수에 xml의 위젯 id를 가져와서 담아준다.
        //3. 변수(위젯)을 리스너에 달아준다.
        btn = (Button) findViewById(R.id.btnGrid);
        tv = (Button) findViewById(R.id.btnPractice);
        btn_cal = (Button) findViewById(R.id.btn_calculator);
        btn.setOnClickListener(this);
        tv.setOnClickListener(this);
        btn_cal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGrid:
                //안드로이드 메이저 컴포넌트를 로드하기 위해서는 intent를 통해서 로드할 컴포넌트를 지정해야 한다.
                Intent intent = new Intent(getApplicationContext(), GridActivity.class);
                //대상이 되는 컴포넌트
                startActivity(intent);

                break;

            case R.id.btnPractice:
                //
                intent = new Intent(getApplicationContext(), PracticeActivity.class);

                startActivity(intent);

                break;

            case R.id.btn_calculator:

                intent = new Intent(getApplicationContext(), widget.class);

                startActivity(intent);

                break;
        }
    }


}

