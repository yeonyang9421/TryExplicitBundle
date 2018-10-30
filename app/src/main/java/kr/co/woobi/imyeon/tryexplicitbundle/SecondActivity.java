package kr.co.woobi.imyeon.tryexplicitbundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bundle=getIntent().getExtras();
        TextView textViewResult=(TextView)findViewById(R.id.textViewResult);
        textViewResult.setText(bundle.getString("keyFirst","NO DATA"));

        Button buttonGoToThird=(Button)findViewById(R.id.buttonGotoThird);
        buttonGoToThird.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editTextSecond=(EditText)findViewById(R.id.editTextSecond);
        String text=editTextSecond.getText().toString();
        bundle.putString("keySecond",text);
        Intent intent=new Intent(this, ThirdActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);


    }
}
