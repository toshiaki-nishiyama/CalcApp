package jp.techacademy.toshiakinishiyama.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();

        float value1 = 0;
        float value2 = 0;

        // 第 1 引数受取
        try
        {
            value1 = intent.getFloatExtra("VALUE1", 0);
        }
        catch (NumberFormatException e)
        {
            textView.setText("エラー： 第 1 引数が数値ではありません。");
            return;
        }

        // 第 2 引数受取
        try
        {
            value2 = intent.getFloatExtra("VALUE2", 0);
        }
        catch (NumberFormatException e)
        {
            textView.setText("エラー： 第 2 引数が数値ではありません。");
            return;
        }

        // 第 3 引数受取
        String value3 = intent.getStringExtra("VALUE3");

        switch (value3)
        {
            case "+":
                textView.setText(String.valueOf(value1 + value2));
                break;
            case "-":
                textView.setText(String.valueOf(value1 - value2));
                break;
            case "*":
                textView.setText(String.valueOf(value1 * value2));
                break;
            case "/":
                if(value2 == 0)
                {
                    textView.setText("エラー： 0割算です。");
                }
                else
                {
                    textView.setText(String.valueOf(value1 / value2));
                }
                break;
            default:
                textView.setText("指定した演算子が異常です。");
                break;
        }
    }
}
