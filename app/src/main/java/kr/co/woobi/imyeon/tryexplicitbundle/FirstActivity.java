package kr.co.woobi.imyeon.tryexplicitbundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Intent intent=getIntent();
       if(intent.hasExtra("keyThird")){
           bundle=getIntent().getExtras();
           String keyThirdString=bundle.getString("keyThird", "No data");
          TextView textViewResult=(TextView)findViewById(R.id.textViewResult);
           textViewResult.setText(keyThirdString);
     }

        Button buttonGotoFirst=(Button)findViewById(R.id.buttonGotoSecond);
        buttonGotoFirst.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editTextFirst=(EditText)findViewById(R.id.editTextFirst);
        String text=editTextFirst.getText().toString();
        bundle=new Bundle();
        bundle.putString("keyFirst",text);
       ;
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
