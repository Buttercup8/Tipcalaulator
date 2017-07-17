package cs2301.AlenaWhitlock_Assignment3;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class TipCalculator extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        CalculateButtonListener cbl = new CalculateButtonListener();
        Button CalculateBTN = (Button) findViewById(R.id.CalculateBTN);
        CalculateBTN.setOnClickListener(cbl);


    }

    private class CalculateButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            EditText amountET = (EditText) findViewById(R.id.AmountET);
            Editable amountEDTBL = amountET.getText();
            String amountSTR = amountEDTBL.toString();
            double amount = Double.parseDouble(amountSTR);

            EditText taxET = (EditText) findViewById(R.id.TaxET);
            Editable taxEDTBL = taxET.getText();
            String taxSTR = taxEDTBL.toString();
            double tax = Double.parseDouble(taxSTR);

            double subtotal = amount + (tax * amount);

            RadioGroup percentRG = (RadioGroup) findViewById(R.id.pftRG);
            int checkedID = percentRG.getCheckedRadioButtonId();
            double percent;

            if (checkedID == R.id.tenRB) {
                percent = .1;
            } else if (checkedID == R.id.fifteenRB) {
                percent = .15;
            } else if (checkedID == R.id.twentyRB) {
                percent = .2;
            } else {
                percent = -123456789.09876543;
            }

            double tip = percent * subtotal;
            double grandtotal = tip + subtotal;

            EditText TipET = (EditText) findViewById(R.id.TipET);
            TipET.setText(String.format("%1$,.2f" ,tip));
            EditText TotalET = (EditText) findViewById(R.id.TotalET);
            TotalET.setText(String.format("%1$,.2f" ,grandtotal));


        }
    }
}