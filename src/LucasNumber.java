/**
 * Клас для представлення чисел Люка.
 */
public class LucasNumber {

    /** Приватне поле для зберігання номера числа Люка. */
    private int number;
    /** Приватне поле для зберігання значення числа Люка. */
    private int value;

    /**
     * Конструктор класу.
     * @param num номер числа Люка
     * @param val значення числа Люка
     */
    public LucasNumber(int num, int val) {
        this.number = num;
        this.value = val;
    }

    /**
     * Встановлює номер числа Люка.
     * @param num новий номер числа Люка
     */
    public void setNumber(int num) {
        this.number = num;
    }

    /**
     * Встановлює значення числа Люка.
     * @param val нове значення числа Люка
     */
    public void setValue(int val) {
        this.value = val;
    }

    /**
     * Повертає номер числа Люка.
     * @return номер числа Люка
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Повертає значення числа Люка.
     * @return значення числа Люка
     */
    public int getValue() {
        return this.value;
    }
}