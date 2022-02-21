public class Main {
    public static void main(String[] args) {

        Fighter f1 = new Fighter("Zidane", 10,100, 80, 10);
        Fighter f2 = new Fighter("Materazzi",8, 100, 75, 20);

        Match match = new Match(f1,f2,70,100);
        match.run();
    }
}
