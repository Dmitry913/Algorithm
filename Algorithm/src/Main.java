import java.util.List;

public class Main {
    public static void main(String[] args) {
        Finder finder = new Finder();
        if (GeneratorTest.shouldReturnFalseResult(finder) || !GeneratorTest.shouldReturnTrueResult(finder)) {
            System.out.println("FAILED TESTS");
            return;
        }
        int n = 2 * 54012;
        // выполнение 100 вычислений
        for (int i = 0; i < 100; i++) {
            n = Generator.generateN();
            System.out.println("n = " + n);
            finder.findPrimeNumbersNonOptimize(n);
            System.out.println("Non-optimize - count of basic operation: " + finder.getCountOperation());
            finder.findPrimeNumbers(n);
            System.out.println("Optimize - count of basic operation: " + finder.getCountOperation());
            System.out.println("Theoretical estimation: " + n * Math.log(Math.log(n)));
        }
    }
}

class GeneratorTest {
    public static boolean shouldReturnFalseResult(Finder finder) {
        List<Integer> trueResult = List.of(2, 3, 5);
        return trueResult.containsAll(finder.findPrimeNumbers(10));
    }

    public static boolean shouldReturnTrueResult(Finder finder) {
        List<Integer> trueResult = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
        return trueResult.containsAll(finder.findPrimeNumbers(50));
    }
}