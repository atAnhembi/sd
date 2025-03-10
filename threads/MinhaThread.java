public class MinhaThread extends Thread {
    public MinhaThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Thread " + super.getName() + " executando.");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + super.getName() + " terminada.");

    }
}