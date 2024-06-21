import java.util.LinkedList;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }

    static class Buffer {
        private LinkedList<Integer> data;
        private int maxSize;

        public Buffer(int maxSize) {
            this.data = new LinkedList<>();
            this.maxSize = maxSize;
        }

        public synchronized void produce(int value) throws InterruptedException {
            while (data.size() == maxSize) {
                wait(); // Attente si le tampon est plein
            }
            data.add(value);
            notify(); // Réveille un consommateur
        }

        public synchronized int consume() throws InterruptedException {
            while (data.isEmpty()) {
                wait(); // Attente si le tampon est vide
            }
            int value = data.poll();
            notify(); // Réveille un producteur
            return value;
        }
    }

    static class Producer implements Runnable {
        private Buffer buffer;

        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    buffer.produce(i);
                    Thread.sleep(100); // Simule la production
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private Buffer buffer;

        public Consumer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    int value = buffer.consume();
                    System.out.println("Consumed: " + value);
                    Thread.sleep(100); // Simule la consommation
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



















import java.util.LinkedList;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }

    static class Buffer {
        private LinkedList<Integer> data;
        private int maxSize;

        public Buffer(int maxSize) {
            this.data = new LinkedList<>();
            this.maxSize = maxSize;
        }

        public synchronized void produce(int value) throws InterruptedException {
            while (data.size() == maxSize) {
                wait(); // Attente si le tampon est plein
            }
            data.add(value);
            notify(); // Réveille un consommateur
        }

        public synchronized int consume() throws InterruptedException {
            while (data.isEmpty()) {
                wait(); // Attente si le tampon est vide
            }
            int value = data.poll();
            notify(); // Réveille un producteur
            return value;
        }
    }

    static class Producer implements Runnable {
        private Buffer buffer;

        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    buffer.produce(i);
                    Thread.sleep(100); // Simule la production
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private Buffer buffer;

        public Consumer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    int value = buffer.consume();
                    System.out.println("Consumed: " + value);
                    Thread.sleep(100); // Simule la consommation
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

