import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class MultiplyThread {
    /**
     *
     */
    private int number_of_threads;
    /**
     * 1 множитель - матрицы
     */
    private Matrix a;
    /**
     *2 множитель - матрицы
     */
    private Matrix b;
    /**
     * произведение
     */
    private Matrix rez;

    /**
     * определение потоков реализацией интерфейса Runnable
     */
    private class MyThread implements Runnable{
        private int stringIndex;

        public MyThread(int index) {
            this.stringIndex = index;
        }
        @Override
        public void run(){
            int value = 0;
            for (int j = 0; j < b.getMatr()[0].length; j++) {
                for (int k = 0; k < a.getMatr()[0].length; k++) {
                    value +=  a.getMatrix(this.stringIndex,k)*b.getMatrix(k,j);
                    rez.setMatrix(this.stringIndex,j,value);

                }
                value = 0;

            }

        }
    }

    /**
     * конструктор
     * @param a
     * @param b
     * @param number_of_threads
     */
    MultiplyThread(Matrix a, Matrix b, int number_of_threads){
        this.a = a;
        this.b = b;
        this.number_of_threads = number_of_threads;
        this.rez = new Matrix(a.getMatr().length, b.getMatr()[0].length);
    }

    /**
     *
     * @return произведение
     * @throws InterruptedException
     */
    public Matrix parallelMultiply() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(this.number_of_threads);
        for(int i = 0; i < a.getMatr().length; i++)
            executorService.execute(new MyThread(i));
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        return this.rez;
    }
}
