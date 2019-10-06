package cheng.com.bai21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOutput extends AppCompatActivity {

    private Button btnResult;
    private TextView tvNumberA, tvNumberB;
    private int numberA;
    private int numberB;
    public static final String RESULT ="result";
    public static final int RESULT_PIN = 2017;
    public static final int RESULT_PIN1 = 2018;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        getWidget();
        getData();
        setEvents();
    }

    public void getData(){
        Intent intent = getIntent();
        numberA = intent.getIntExtra(ActivityInput.NUMBER_A,0);
        numberB = intent.getIntExtra(ActivityInput.NUMBER_B,0);
        tvNumberA.setText(numberA +"");
        tvNumberB.setText(numberB + "");

    }
    public void getWidget(){
        tvNumberA = (TextView) findViewById(R.id.tv_number_A);
        tvNumberB= (TextView) findViewById(R.id.tv_number_B);
        btnResult = (Button) findViewById(R.id.btn_result);
    }
    public void setEvents(){
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int result = numberA+numberB;
                Intent intent = new Intent();
                intent.putExtra(RESULT,result);
                setResult(RESULT_PIN,intent);
                finish();
            }
        });
    }
    public void setResultDemo(){
        Intent intent = new Intent();
        intent.putExtra(RESULT,2018);
        setResult(RESULT_PIN1,intent);
    }
}
