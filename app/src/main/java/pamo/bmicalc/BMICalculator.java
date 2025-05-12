package pamo.bmicalc;

public class BMICalculator {
    public static String calculate(float weight, float heightCm) {
        if (weight <= 0 || heightCm <= 0) {
            return "Waga i wzrost muszą być większe od zera!";
        }

        float heightM = heightCm / 100f;
        float bmi = weight / (heightM * heightM);

        String bmiStatus;
        if (bmi < 18.5) bmiStatus = "Niedowaga";
        else if (bmi < 25) bmiStatus = "Prawidłowa masa";
        else if (bmi < 30) bmiStatus = "Nadwaga";
        else if (bmi < 35) bmiStatus = "Otyłość I stopnia";
        else if (bmi < 40) bmiStatus = "Otyłość II stopnia";
        else bmiStatus = "Otyłość III stopnia";

        return "Twoje BMI: " + String.format("%.2f", bmi) + "\nKategoria: " + bmiStatus;
    }
}