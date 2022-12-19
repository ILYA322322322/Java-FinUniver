public class respown {
    static String info = " is g";
    public static void main(String[] args) {
        Thread thread = new Thread(new Prod());
        Thread run = new Thread(new Prod());
        thread.start();
        run.start();
    }
}

class Prod extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (respown.info) {  // Lock info
                System.out.println(this.getName() + respown.info);
            }
            try {
                Thread.sleep(10); //sleep 10mm
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}