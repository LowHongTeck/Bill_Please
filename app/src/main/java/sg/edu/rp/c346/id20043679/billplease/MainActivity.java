package sg.edu.rp.c346.id20043679.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText amount;
    EditText pax;
    EditText discount;
    RadioGroup rgPayment;
    Button split;
    Button reset;
    TextView bill;
    TextView pays;
    ToggleButton svs;
    ToggleButton gst;

    double totalAmount = 0.0;
    double tax = 0.0;
    double taxAmount = 0.0;
    double totalDiscount = 0;

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
        rgPayment = findViewById(R.id.payment);
        svs = findViewById(R.id.toggleSVS);
        gst = findViewById(R.id.toggleGST);

        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strAmount = amount.getText().toString();
                double dbAmount = Double.parseDouble(strAmount);

                String strPax = pax.getText().toString();
                int intPax = Integer.parseInt(strPax);

                String strDiscount = discount.getText().toString();
                double dbDiscount = Double.parseDouble(strDiscount);


                if (svs.isChecked()){
                    tax += 0.1;
                }
                if (gst.isChecked()){
                    tax += 0.07;
                }

                taxAmount = 1+tax;

                boolean haveDiscount = false;
                if (dbDiscount >=0 && dbDiscount <=100.0) {
                    haveDiscount = true;
                }
                if (haveDiscount = true){
                    totalDiscount = totalAmount*(dbDiscount/100);
                }
                totalAmount = (dbAmount - totalDiscount)*taxAmount;

                String billMsg = "Total Bill: $" + totalAmount;
                bill.setText(billMsg);

                String strPayment = pays.getText().toString();

                int checkedRadioId = rgPayment.getCheckedRadioButtonId();
                if (checkedRadioId == R.id.cash){
                    strPayment = "Each Pays: $" + totalAmount/intPax + " in cash";
                }
                else {
                    strPayment = "Each Pays: $" + totalAmount/intPax + " via PayNow to 98297971";
                }

                pays.setText(strPayment);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount.setText("");
                totalAmount = 0;
                pax.setText("");
                discount.setText("");
                tax = 0;

                svs.setChecked(false);
                gst.setChecked(false);

            }
        });


    }
}