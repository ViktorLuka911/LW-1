import java.util.Scanner;

/**
 * Головний клас програми, що містить метод main для запуску програми.
 */
public class Main {

    /**
     * Метод, з якого починається виконання програми.
     * @param args параметри командного рядка
     */
    public static void main(String[] args) {
        int N = 0;

        // Якщо параметр командного рядка переданий, спробувати зчитати його
        if (args.length > 0) {
            try {
                N = Integer.parseInt(args[0]);
                if (N <= 0) {
                    throw new IllegalArgumentException(); // Генерує помилку, якщо число не більше нуля
                }
            } catch (NumberFormatException e) {
                System.err.println("Помилка: введене значення не є дiйсним числом.");
                System.exit(1);
            } catch (IllegalArgumentException e) {
                System.err.println("Помилка: Число менше 1.");
                System.exit(1);
            }
        } else {
            // Якщо параметр не переданий, використати метод для зчитування з консолі
            N = getInput();
        }
        LucasNumber[] lucasNumbers = generateLucasNumbers(N); // Генерація чисел Люка
        printLucasNumbersMatchingCondition(lucasNumbers); // Виведення чисел Люка, що задовольняють умову
        printLucasNumbers(lucasNumbers); // Виведення всіх чисел Люка
    }

    /**
     * Зчитує кількість чисел Люка з консолі.
     * @return зчитане число N
     */
    private static int getInput() {
        int N = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведiть кiлькість чисел Люка (позитивне число): ");
        try {
            N = scanner.nextInt(); // Читання числа з консолі
            scanner.close(); // Закриття сканера
            if (N <= 0) {
                throw new IllegalArgumentException(); // Генерує помилку, якщо число не більше нуля
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: Число менше 1.");
            System.exit(1);
        }
        return N; // Повернення зчитаного числа
    }

    /**
     * Генерує масив чисел Люка до кількості N.
     * @param N кількість перших чисел Люка, які потрібно згенерувати
     * @return масив об'єктів класу LucasNumber, що містить перші N чисел Люка
     */
    private static LucasNumber[] generateLucasNumbers(int N) {
        LucasNumber[] lucasNumbers = new LucasNumber[N]; // Оголошення масиву для чисел Люка

        // Якщо потрібно одне число Люка
        if (N == 1) {
            lucasNumbers[0] = new LucasNumber(1, 2); // Перше число Люка
        }
        // Якщо потрібно два або більше чисел Люка
        else if (N >= 2) {
            int a = 2, b = 1; // Початкові значення чисел Люка
            lucasNumbers[0] = new LucasNumber(1, a); // Перше число Люка
            lucasNumbers[1] = new LucasNumber(2, b); // Друге число Люка

            // Цикл для знаходження наступних чисел Люка
            for (int i = 2; i < N; i++) {
                int sum = a + b; // Вирахування наступного числа Люка
                lucasNumbers[i] = new LucasNumber(i + 1, sum); // Додавання числа до масиву
                a = b; // Оновлення значень для наступної ітерації
                b = sum; // Оновлення значень для наступної ітерації
            }
        }

        return lucasNumbers; // Повернення масиву чисел Люка
    }

    /**
     * Виводить числа Люка, які задовольняють умову рівності (w^3 + 1).
     * @param lucasNumbers масив чисел Люка для перевірки умови
     */
    private static void printLucasNumbersMatchingCondition(LucasNumber[] lucasNumbers) {
        System.out.println("\nПершi " + lucasNumbers.length + " чисел Люка, якi можна подати у вигляді (w^3 + 1):\n");
        for (int i = 1; Math.pow(i, 3) + 1 < lucasNumbers[lucasNumbers.length - 1].getValue(); i++) {
            int numb = (int) (Math.pow(i, 3) + 1);

            for (LucasNumber number : lucasNumbers) {
                if (numb == number.getValue()) {
                    System.out.println(number.getNumber() + ": " + number.getValue() + " = " + i + "^3 + 1");
                }
            }
        }
        System.out.print("\n\n");
    }

    /**
     * Виводить всі перші згенеровані числа Люка.
     * @param lucasNumbers масив чисел Люка для виведення
     */
    private static void printLucasNumbers(LucasNumber[] lucasNumbers) {
        System.out.println("Всi першi " + lucasNumbers.length + " чисел Люка:");
        for (LucasNumber number : lucasNumbers) {
            System.out.print("|" + number.getNumber() + ": " + number.getValue() + "| ");
        }
        System.out.print("\n");
    }
}