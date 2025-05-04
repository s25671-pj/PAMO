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
    private Button calculate;
    private TextView result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bmi_calculator, container, false);

        enterWeight = view.findViewById(R.id.enterWeight);
        enterHeight = view.findViewById(R.id.enterHeight);
        calculate = view.findViewById(R.id.calculate);
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
                float height = Float.parseFloat(heightText) / 100f;

                if (weight > 0 && height > 0) {
                    float bmi = weight / (height * height);
                    String bmiStatus;

                    if (bmi < 18.5) {
                        bmiStatus = "Niedowaga";
                    } else if (bmi < 25) {
                        bmiStatus = "Prawidłowa masa";
                    } else if (bmi < 30) {
                        bmiStatus = "Nadwaga";
                    } else if (bmi < 35) {
                        bmiStatus = "Otyłość I stopnia";
                    } else if (bmi < 40) {
                        bmiStatus = "Otyłość II stopnia";
                    } else {
                        bmiStatus = "Otyłość III stopnia";
                    }

                    result.setText("Twoje BMI: " + String.format("%.2f", bmi) + "\nKategoria: " + bmiStatus);
                } else {
                    result.setText("Waga i wzrost muszą być większe od zera!");
                }
            } catch (NumberFormatException e) {
                result.setText("Podaj poprawne wartości liczbowe!");
            }
        } else {
            result.setText("Uzupełnij wszystkie pola!");
        }
    }
}
