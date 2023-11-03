public class App {
    public static void main(String[] args) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();
        final StringBuilder stringBuilder = new StringBuilder();

        Runnable appendTask = () -> {
            for (int i = 0; i < 1000; i++) {
                stringBuffer.append("A");
                stringBuilder.append("B");
            }
        };

        Thread thread1 = new Thread(appendTask);
        thread1.start();

        Thread thread2 = new Thread(appendTask);
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("StringBuffer length = " + stringBuffer.length());
        System.out.println("StringBuilder length = " + stringBuilder.length());
    }
}
