package pamo.bmicalc;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText enterWeight, enterHeight;
    private Button calculate;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        enterWeight = findViewById(R.id.enterWeight);
        enterHeight = findViewById(R.id.enterHeight);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.result);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        enterWeight.setOnClickListener(a -> {
            enterWeight.setText("");
        });
        enterHeight.setOnClickListener(a -> {
            enterHeight.setText("");
        });

        calculate.setOnClickListener(v -> calculateBMI());
    }

    private void calculateBMI() {
        String weightText = enterWeight.getText().toString();
        String heightText = enterHeight.getText().toString();

        if (!weightText.isEmpty() && !heightText.isEmpty()) {
            try {

                float weight = Float.parseFloat(weightText);
                float height = Float.parseFloat(heightText) / 100;

                if (height > 0) {

                    float bmi = weight / (height * height);
                    String bmiStatus = (bmi < 30 ?
                            (bmi < 25 ? (bmi < 18.5 ? "Niedowaga" : "Prawidłowa masa") : "Nadwaga")
                            : (bmi < 35 ? "Otyłość I stopnia" : (bmi < 40 ? "Otyłość II stopnia" : "Otyłość III stopnia")));
                    result.setText("Twoje BMI: " + bmi + "\nto: " + bmiStatus);
                } else {
                    result.setText("Wzrost musi być większy od zera!");
                }
            } catch (NumberFormatException e) {
                result.setText("Podaj poprawne wartości!");
            }
        } else {
            result.setText("Wypełnij oba pola!");
        }
    }
}
