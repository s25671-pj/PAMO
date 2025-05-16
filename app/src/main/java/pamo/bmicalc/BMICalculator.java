package pamo.bmicalc;

/**
 * Klasa BMICalculator służy do obliczania wskaźnika BMI (Body Mass Index)
 * na podstawie podanej masy ciała (w kg) i wzrostu (w cm).
 * <p>
 * Po przeliczeniu wartości zwraca informację tekstową zawierającą wynik BMI
 * oraz opisową kategorię, np. "Prawidłowa masa" czy "Otyłość I stopnia".
 * <p>
 */
public class BMICalculator {

    /**
     * Oblicza BMI i zwraca tekst z wynikiem oraz kategorią wagową.
     *
     * @param weight    masa ciała w kilogramach (musi być większa od 0)
     * @param heightCm  wzrost w centymetrach (musi być większy od 0)
     * @return wiadomość z obliczonym BMI i przypisaną kategorią,
     *         lub komunikat o błędnych danych wejściowych
     */
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