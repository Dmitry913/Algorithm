import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Finder {
    long counter = 0;

    public long getCountOperation() {
        return counter;
    }

    public List<Integer> findPrimeNumbers(int n) {
        counter = 0;
        boolean[] isPrimeNumbers = new boolean[n + 1];
        Arrays.fill(isPrimeNumbers, true);
        int p = 2;
        // исключаем все числа кратные 2
        for (int i = p * p; i < n + 1; i += p) {
            counter++;
            isPrimeNumbers[i] = false;
        }
        p = 3;
        // теперь можем делать шаг длины 2p
        while (p * p < n) {
            for (int i = p * p; i < n + 1 && i > 0; i += 2 * p) {
                counter++;
                isPrimeNumbers[i] = false;
            }
            do {
                p++;
            } while (p * p < n && !isPrimeNumbers[p]);
        }
        List<Integer> result = new LinkedList<>();
        // записываем простые числа
        for (int i = 2; i < n + 1; i++) {
            if (isPrimeNumbers[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findPrimeNumbersNonOptimize(int n) {
        counter = 0;
        boolean[] isPrimeNumbers = new boolean[n + 1];
        Arrays.fill(isPrimeNumbers, true);
        int p = 2;
        while (p < n) {
            for (int i = 2 * p; i < n + 1 && i > 0; i += p) {
                counter++;
                isPrimeNumbers[i] = false;
            }
            do {
                p++;
            } while (p < n && !isPrimeNumbers[p]);
        }
        List<Integer> result = new ArrayList<>(isPrimeNumbers.length);
        // записываем простые числа
        for (int i = 2; i < n + 1; i++) {
            if (isPrimeNumbers[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
