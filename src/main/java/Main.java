public class Main {
    public static void main(String[] args) throws InterruptedException{
        Matrix a = new Matrix(1000,1000);
        a.fillMatrix();
        Matrix b = new Matrix(1000,1000);
        b.fillMatrix();
        Matrix oneResult;
        Matrix multiResult;

        long startTime = System.currentTimeMillis();
        oneResult = a.multiplyMatrix(b);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print(oneResult);
        System.out.println("Умножается за время: " + estimatedTime + "ms");

        MultiplyThread test = new MultiplyThread(a, b, Runtime.getRuntime().availableProcessors());
        long startTime1 = System.currentTimeMillis();
        multiResult = test.parallelMultiply();
        long estimatedTime1 = System.currentTimeMillis() - startTime1;
        System.out.print(multiResult);
        System.out.println("Умножается за время c помощью потоков: " + estimatedTime1 + "ms");


    }
}
