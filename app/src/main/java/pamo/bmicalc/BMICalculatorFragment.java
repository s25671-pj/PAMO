package pamo.bmicalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class BMICalculatorFragment extends Fragment {

    private EditText enterWeight, enterHeight;
    private TextView result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bmi_calculator, container, false);

        enterWeight = view.findViewById(R.id.enterWeight);
        enterHeight = view.findViewById(R.id.enterHeight);
        Button calculate = view.findViewById(R.id.calculate);
        result = view.findViewById(R.id.result);

        enterWeight.setOnClickListener(a -> enterWeight.setText(""));
        enterHeight.setOnClickListener(a -> enterHeight.setText(""));

        calculate.setOnClickListener(v -> calculateBMI());

        return view;
    }

    private void calculateBMI() {
        String weightText = enterWeight.getText().toString();
        String heightText = enterHeight.getText().toString();

        if (!weightText.isEmpty() && !heightText.isEmpty()) {
            try {
                float weight = Float.parseFloat(weightText);
                float height = Float.parseFloat(heightText);

                String resultMsg = BMICalculator.calculate(weight, height);
                result.setText(resultMsg);
            } catch (NumberFormatException e) {
                result.setText("Podaj poprawne wartości liczbowe!");
            }
        } else {
            result.setText("Uzupełnij wszystkie pola!");
        }
    }

}
