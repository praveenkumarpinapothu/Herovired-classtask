public class multiplethreads {
    public static void main(final String[] args) {
        System.out.println("Thread main started");
        final Thread thread1 = new Thread(new WorkerThread());
        thread1.setName("WorkerThread 1");
        final Thread thread2 = new Thread(new WorkerThread());
        thread1.setName("WorkerThread 2");
        thread1.start();
        thread2.start();
        System.out.println("Thread main ended");
    }
}

class WorkerThread implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(1000);
                for(int j=1;j<=5;j++){
                    System.out.println(i+"*"+j+"="+i*j);

                }
                System.out.println("[" + Thread.currentThread().getName() + "] Message " + i);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}