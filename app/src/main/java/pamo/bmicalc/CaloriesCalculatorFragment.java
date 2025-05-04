package pamo.bmicalc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;

public class CaloriesCalculatorFragment extends Fragment {

    EditText weightInput, heightInput, ageInput;
    Spinner activitySpinner;
    RadioGroup genderGroup;
    Button calculateButton;
    TextView resultText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calories_calculator, container, false);

        weightInput = view.findViewById(R.id.enterWeight2);
        heightInput = view.findViewById(R.id.enterHeight2);
        ageInput = view.findViewById(R.id.enterAge);
        activitySpinner = view.findViewById(R.id.spinnerActivity);
        genderGroup = view.findViewById(R.id.radioGroupGender);
        calculateButton = view.findViewById(R.id.calculate2);
        resultText = view.findViewById(R.id.result2);
        resultText.setVisibility(View.GONE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.activity_levels,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitySpinner.setAdapter(adapter);

        weightInput.setOnClickListener(a -> weightInput.setText(""));
        heightInput.setOnClickListener(a -> heightInput.setText(""));
        ageInput.setOnClickListener(a -> ageInput.setText(""));

        calculateButton.setOnClickListener(v -> {
            try {
                String weightStr = weightInput.getText().toString().trim();
                String heightStr = heightInput.getText().toString().trim();
                String ageStr = ageInput.getText().toString().trim();

                if (weightStr.isEmpty() || heightStr.isEmpty() || ageStr.isEmpty()) {
                    showToast("Uzupełnij wszystkie pola.");
                    return;
                }

                double weight = Double.parseDouble(weightStr.replace(",", "."));
                double height = Double.parseDouble(heightStr.replace(",", "."));
                int age = Integer.parseInt(ageStr);

                if (weight < 30 || weight > 300) {
                    showToast("Waga musi być w zakresie 30–300 kg.");
                    return;
                }

                if (height < 100 || height > 250) {
                    showToast("Wzrost musi być w zakresie 100–250 cm.");
                    return;
                }

                if (age < 10 || age > 120) {
                    showToast("Wiek musi być w zakresie 10–120 lat.");
                    return;
                }

                int selectedGender = genderGroup.getCheckedRadioButtonId();
                if (selectedGender == -1) {
                    showToast("Wybierz płeć.");
                    return;
                }

                double bmr;
                if (selectedGender == R.id.radioMale) {
                    bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
                } else {
                    bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
                }

                String activity = activitySpinner.getSelectedItem().toString();

                double multiplier;
                if (activity.equals("Brak aktywności")) {
                    multiplier = 1.2;
                } else if (activity.equals("Lekka aktywność (1–3 dni/tydz.)")) {
                    multiplier = 1.375;
                } else if (activity.equals("Umiarkowana aktywność (3–5 dni/tydz.)")) {
                    multiplier = 1.55;
                } else if (activity.equals("Duża aktywność (6–7 dni/tydz.)")) {
                    multiplier = 1.725;
                } else if (activity.equals("Bardzo duża aktywność (dwa treningi dziennie)")) {
                    multiplier = 1.9;
                } else {
                    showToast("Nie wybrano poprawnego poziomu aktywności.");
                    return;
                }


                double calories = bmr * multiplier;
                SharedPreferences prefs = requireContext().getSharedPreferences("CaloriesPrefs", Context.MODE_PRIVATE);
                prefs.edit().putInt("calories", (int) calories).apply();

                resultText.setVisibility(View.VISIBLE);
                resultText.setText("Dzienne zapotrzebowanie: " + (int) calories + " kcal");


            } catch (NumberFormatException e) {
                showToast("Wprowadź poprawne liczby (bez liter i znaków specjalnych).");
            } catch (Exception e) {
                showToast("Wystąpił błąd: " + e.getMessage());
            }
        });

        return view;
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}