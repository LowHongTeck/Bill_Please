package sg.edu.rp.c346.id20043679.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText amount;
    EditText pax;
    EditText discount;
    RadioGroup tax;
    Button split;
    Button reset;
    TextView bill;
    TextView pays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.editAmount);
        pax = findViewById(R.id.editNumPax);
        discount = findViewById(R.id.editDiscount);
        split = findViewById(R.id.split);
        reset = findViewById(R.id.reset);
        bill = findViewById(R.id.totalBillText);
        pays = findViewById(R.id.eachPaysText);
        tax = findViewById(R.id.tax);
        double totalAmount = 0.0;

        String strAmount = amount.getText().toString();
        double dbAmount = Double.parseDouble(strAmount);

        String strPax = pax.getText().toString();
        int intPax = Integer.parseInt(strPax);

        String strDiscount = discount.getText().toString();
        int intDiscount = Integer.parseInt(strDiscount);

        String strBill = bill.getText().toString();
        String strPays = pays.getText().toString();






    }
}