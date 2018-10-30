package kr.co.woobi.imyeon.tryexplicitbundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle bundle=getIntent().getExtras();
        TextView textViewResult=(TextView)findViewById(R.id.textViewResult);
        textViewResult.setText(bundle.getString("keySecond","No data"));

       Button buttonGotoMain=(Button)findViewById(R.id.buttonGotoFirst);
       buttonGotoMain.setOnClickListener(this);

    }

  @Override
   public void onClick(View v) {
      EditText editTextThird=(EditText)findViewById(R.id.editTextThird);
      String text=editTextThird.getText().toString();
       Bundle bundle=new Bundle();
       bundle.putString("keyThird", text);
       Intent intent=new Intent(this, FirstActivity.class);
       intent.putExtras(bundle);
       startActivity(intent);
    }
}
