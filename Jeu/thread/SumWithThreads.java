package thread;

public class SumWithThreads {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numThreads = 4; // Nombre de threads

        // Créez un tableau pour stocker les threads
        Thread[] threads = new Thread[numThreads];

        // Créez un tableau pour stocker les résultats partiels
        int[] partialSums = new int[numThreads];

        int chunkSize = arr.length / numThreads;

        for (int i = 0; i < numThreads; i++) {
            final int start = i * chunkSize;
            final int end = (i == numThreads - 1) ? arr.length : (i + 1) * chunkSize;

            threads[i] = new Thread(() -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += arr[j];
                }
                partialSums[i] = sum;
            });

            threads[i].start();
        }

        // Attendre que tous les threads se terminent
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Additionnez les résultats partiels pour obtenir la somme finale
        int totalSum = 0;
        for (int sum : partialSums) {
            totalSum += sum;
        }

        System.out.println("Somme totale : " + totalSum);
    }
}
