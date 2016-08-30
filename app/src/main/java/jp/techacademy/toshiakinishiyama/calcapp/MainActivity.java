package jp.techacademy.toshiakinishiyama.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 加算用ボタン
        Button btnPlus = (Button) findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(this);
        // 引算用ボタン
        Button btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);
        // 乗算用ボタン
        Button btnMult = (Button) findViewById(R.id.btnMult);
        btnMult.setOnClickListener(this);
        // 除算用ボタン
        Button btnDivs = (Button) findViewById(R.id.btnDiv);
        btnDivs.setOnClickListener(this);

        // ユーザ入力用テキスト
        mEditText1 = (EditText)findViewById(R.id.editText1);
        mEditText2 = (EditText)findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v)
    {
        // ユーザ入力数値（文字列）取得
        String str1 = mEditText1.getText().toString();
        String str2 = mEditText2.getText().toString();

        float val1 = 0;
        float val2 = 0;

        // エラーメッセージ用テキスト
        TextView textViewErr = (TextView) findViewById(R.id.textViewErr);
        textViewErr.setText("");        // クリア
        boolean numFlg1 = true;      // 第 1 引数チェック用フラグ
        boolean numFlg2 = true;      // 第 2 引数チェック用フラグ

        // 第 1 引数チェック
        try
        {
            val1 = Float.parseFloat(str1);
        }
        catch (NumberFormatException e)
        {
            // エラーフラグ
            numFlg1 = false;
        }

        // 第 2 引数チェック
        try
        {
            val2 = Float.parseFloat(str2);
        }
        catch (NumberFormatException e)
        {
            // エラーフラグ
            numFlg2 = false;
        }

        // 数値チェック
        if((numFlg1 == false) && (numFlg2 == false))
        {
            textViewErr.setText("第 1, 2 引数が数値ではありません。");
            return;
        }
        else if(numFlg1 == false)
        {
            textViewErr.setText("第 1 引数が数値ではありません。");
            return;
        }
        else if(numFlg2 == false)
        {
            textViewErr.setText("第 2 引数が数値ではありません。");
            return;
        }
        else
        {
            // 正常（第 1, 2 引数ともに数値）
        }

        // 数値を渡す
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1", val1);
        intent.putExtra("VALUE2", val2);

        // 演算子を渡す
        if(v.getId() == R.id.btnPlus)
        {
            intent.putExtra("VALUE3", "+");
        }
        else if(v.getId() == R.id.btnMinus)
        {
            intent.putExtra("VALUE3", "-");
        }
        else if(v.getId() == R.id.btnMult)
        {
            intent.putExtra("VALUE3", "*");
        }
        else if(v.getId() == R.id.btnDiv)
        {
            intent.putExtra("VALUE3", "/");
        }

        // 画面遷移
        startActivity(intent);
    }
}
