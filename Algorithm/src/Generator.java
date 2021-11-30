public class Generator {
    public static int generateN() {
        return (int) Math.round(Math.random() * (100000000 - 2)) + 2;
    }
}
