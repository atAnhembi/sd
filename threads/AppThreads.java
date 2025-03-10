public class AppThreads {
    public static void main(String[] args) {
        MinhaThread t1 = new MinhaThread("t1");
        MinhaThread t2 = new MinhaThread("t2");
        MinhaThread t3 = new MinhaThread("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
