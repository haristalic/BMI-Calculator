package link.bmicalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import link.bmicalculator.core.Helt;

public class MainActivity extends Activity {
NumberPicker height;
    NumberPicker weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
height=(NumberPicker)findViewById(R.id.heightNumberPicker);
weight=(NumberPicker)findViewById(R.id.weightNumberPicker2);
        height.setMinValue(120);
        height.setMaxValue(250);
        height.setValue(170);
        height.setWrapSelectorWheel(false);

        weight.setMinValue(20);
        weight.setMaxValue(250);
        weight.setValue(70);
        weight.setWrapSelectorWheel(false);
    }
    public void  calculateButtonClick (View view){
        double height1 = 0;
        double wieght1 = 0;
        if (height != null){
            height1=height.getValue();

        }
       if (weight != null){
           wieght1=weight.getValue();

       }
       Helt health = new Helt();
        double bmiResult = health.calculateBMI(height1,wieght1);
        TextView resultTextView = (TextView)findViewById(R.id.resultTextView);

        if (bmiResult==-1){
            resultTextView.setText(health.getErrorMessage());


        }else {
            String bmiCat = health.determineBMIcategory(bmiResult);
            resultTextView.setText("Your bmi is"+ String.format("%.2f",bmiResult)+"/nBMI category:" + bmiCat);

        }


    }
}
