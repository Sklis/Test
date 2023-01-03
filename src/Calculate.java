import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {
    public static void main(String[] args) {
        int num1 = 0, num2 = 0, result = 0;
        String[] arr = new String[10];
        String[] numbers = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII",
                "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV",
                "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
                "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII",
                "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV",
                "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
                "XCVII", "XCVIII", "XCIX", "C"};

//        Ввод выражения в строчном режиме
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение для вычисления: ");
        String express = scanner.nextLine();
        express = express.toUpperCase(Locale.ROOT);

//       Разбиваем текст на массив и удаляем лишние пробелы
        arr = express.trim().split("[+/\\*\\-]");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
        }

//       Проверка на правильность написания выражения
        // Проверка на длинну
        if (arr.length > 2) {
            System.out.println(new Error("Не допустимое выражение"));
            System.exit(0);
        }

        // Проверка, что цифры написаны в одинаковом формате
        try {
            num1 = Integer.parseInt(arr[0]);
            num2 = Integer.parseInt(arr[1]);
        } catch (NumberFormatException e) {
            if (arr[0].matches("[a-zA-Z]") && arr[1].matches("[0-9]")) {
                System.out.println(new Error("Не допустимое выражение"));
                System.exit(0);
            } else if (arr[0].matches("[0-9]") && arr[1].matches("[IVX]")) {
                System.out.println(new Error("Не допустимое выражение"));
                System.exit(0);
            } else {
                for (int i = 0; i < numbers.length; i++) {
                    if (arr[0].equals(numbers[i])) {
                        num1 = i;
                    }
                }

                for (int i = 0; i < numbers.length; i++) {
                    if (arr[1].equals(numbers[i])) {
                        num2 = i;
                    }
                }

                if (num1 < num2) {
                    System.out.println(new Error("В римской системе нет отрицательных чисел"));
                    System.exit(0);
                }
            }
        }


        //Проверка арифметического знака и выполнение действия
        if (express.contains("*")) {
            result = num1 * num2;
        } else if (express.contains("-")) {
            result = num1 - num2;
        } else if (express.contains("/")) {
            result = num1 / num2;
        } else if (express.contains("+")) {
            result = num1 + num2;
        }

        // Выводим результат
        if (arr[0].matches("[a-zA-Z]")) {
            String str = numbers[result];
            System.out.println("Результат равен: " + str);
        } else {
            System.out.println("Результат равен: " + result);
        }
    }
}

