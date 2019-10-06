package cheng.com.bai21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityInput extends AppCompatActivity {

    private EditText edtNumberA, edtNumberB;
    private Button btnStartActivity;

    public static final String NUMBER_A = "NUMBER_A";
    public static final String NUMBER_B = "NUMBER_B";

    public static final int REQUEST_CODE = 2016;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        getWidget();
        setEvent();


    }

    public void getWidget() {
        edtNumberA = (EditText) findViewById(R.id.edt_number_a);
        edtNumberB = (EditText) findViewById(R.id.edt_number_b);
        btnStartActivity = (Button) findViewById(R.id.btn_start_activty);
    }

    public void setEvent() {
        btnStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(edtNumberA.getText().toString()) && !TextUtils.isEmpty(edtNumberB.getText().toString())) {
                    int numberA = Integer.parseInt(edtNumberA.getText().toString());
                    int numberB = Integer.parseInt(edtNumberB.getText().toString());

                    Intent intent = new Intent(ActivityInput.this, ActivityOutput.class);
                    intent.putExtra(NUMBER_A, numberA);
                    intent.putExtra(NUMBER_B, numberB);
                    startActivityForResult(intent, REQUEST_CODE);

                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            switch (resultCode) {
                case ActivityOutput.RESULT_PIN:
                    int result = data.getIntExtra(ActivityOutput.RESULT, 0);
                    Toast.makeText(this, result +"", Toast.LENGTH_SHORT).show();
                    break;
                case ActivityOutput.RESULT_PIN1:
                    int result1 = data.getIntExtra(ActivityOutput.RESULT, 0);
                    Toast.makeText(this, result1 +"", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }
}
