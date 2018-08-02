package com.ikarosu.mypaintapp;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
    private final int FP = ViewGroup.LayoutParams.FILL_PARENT;
//    RadioGroup radioGroup;
//    StateManager stateManager;
//    Mediator mediator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Canvas canvas;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        // 指定したIDのラジオボタンをチェック
        radioGroup.check(R.id.SelectButton);
        // チェックされているラジオボタンのIDを取得
        RadioButton radiobutton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        // ラジオグループのチェック状態が変更された時に呼び出されるコールバックリスナーを登録
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) findViewById(i);
                Toast.makeText(MainActivity.this,"onCheckedChanged():"+radioButton.getText(),Toast.LENGTH_SHORT).show();
//                if(radioButton.getText()=="Rect"){
//                    MyRect rect = new MyRect(canvas);
//                    rect.paint();
//
//                }
            }
        });



//        myView.setLayoutParams(new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT));
//        linearLayout.addView(myView);

//        TableLayout tableLayout = new TableLayout(this);
//        setContentView(tableLayout);
//        radioGroup = new RadioGroup(this);
//        MyView myView = new MyView(this);
//
//        RadioButton selectButton = new RadioButton(this);
//
//        selectButton.setText("Select");
//
//        RadioButton ovalButton = new RadioButton(this);
//        ovalButton.setText("Oval");
////        linearLayout.addView(ovalButton,
////                new LinearLayout.LayoutParams(
////                        LinearLayout.LayoutParams.WRAP_CONTENT,
////                        LinearLayout.LayoutParams.WRAP_CONTENT));
//
//
//
//        RadioButton rectButton = new RadioButton(this);
//        rectButton.setText("Rect");
////        linearLayout.addView(rectButton,
////                new LinearLayout.LayoutParams(
////                        LinearLayout.LayoutParams.WRAP_CONTENT,
////                        LinearLayout.LayoutParams.WRAP_CONTENT));

//        radioGroup.addView(selectButton);
//        radioGroup.addView(ovalButton);
//        radioGroup.addView(rectButton);
//
//        Button deleteButton = new Button(this);
//        deleteButton.setText("Select");
//
//        Button shadowButton = new Button(this);
//        shadowButton.setText("Shadow");
//
//        TableRow tableRow1 = new TableRow(this);
//        tableRow1.addView(radioGroup);
//        tableRow1.addView(deleteButton);
//        tableRow1.addView(shadowButton);
////        tableRow1.addView(ovalButton);
////        tableRow1.addView(rectButton);
//
//        TableRow tableRow2 = new TableRow(this);
//        tableRow2.addView(myView);
//
//        tableLayout.addView(tableRow1, createParam(FP, WC));
//        tableLayout.addView(tableRow2, createParam(FP, WC));
    }

//    public void onRadioButtonClicked(View view){
//        // ラジオボタンの選択状態を取得
//        RadioButton radioButton = (RadioButton) view;
//        // getId()でラジオボタンを識別，ラジオボタンごとの処理を行う
//        boolean checked = radioButton.isChecked();
//        switch (radioButton.getId()){
//            case R.id.SelectButton:
//                if(checked){
//                    Toast.makeText(getApplicationContext(),"Selectモードになりました。",Toast.LENGTH_SHORT).show();
//                }
//                break;
//            case R.id.OvalButton:
//                if(checked){
//                    Toast.makeText(getApplicationContext(),"Ovalモードになりました。",Toast.LENGTH_SHORT).show();
//                }
//                break;
//            case R.id.RectButton:
//                if(checked){
//                    Toast.makeText(getApplicationContext(),"Rectモードになりました。",Toast.LENGTH_SHORT).show();
//                }
//                break;
//            default:
//                break;
//        }
//    }
//    radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//
//    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
//        @Override
//        public void onCheckedChengeed()
//        if(checkedId != -1){
//            // 選択されているラジオボタンの取得
//            RadioButton radioButton = (RadioButton) findViewById(checkedId);
//
//            // ラジオボタンのテキストを取得
//            String text = radioButton.getText().toString();
//
//            Log.v("checked",text);
//        }
//    });

    private TableLayout.LayoutParams createParam(int w, int h){
        return new TableLayout.LayoutParams(w,h);
    }
}
