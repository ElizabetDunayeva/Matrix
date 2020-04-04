import java.util.Random;

/**
 * класс представляющий матрицы
 */
public class Matrix {
    /**
     * вумерный массив - матрица
     */
    private int matrix[][];

    /**
     * метод для получения элемента матрицы
     * @param i номер строки
     * @param j номер столбца
     * @return
     */
    public  int getMatrix(int i, int j) {
        return matrix[i][j];
    }

    /**
     * получение всей матрицы
     * @return
     */
    public int[][]getMatr(){
        return matrix;
    }

    /**
     * задание значения для элемента матрицы
     * @param i номер строки
     * @param j номер столбца
     * @param value значение
     */
    public void setMatrix(int i, int j,int value) {
        this.matrix[i][j] = value;
    }

    /**
     * конструктор
     * @param row количество строк
     * @param column количество столбцов
     */
    public Matrix(int row, int column){
        matrix = new int[row][column];
    }

    /**
     * заполнение матрицы
     * @return
     */
    public Matrix fillMatrix() {
        Random randomizer = new Random(System.currentTimeMillis());
        for(int i=0; i < this.matrix.length; i++) {
            for(int j=0; j < this.matrix[0].length; j++) {
                this.matrix[i][j] = 1 + randomizer.nextInt(5-1);
            }
        }
        return null;
    }

    /**
     * обычное умножение матриц
     * @param obj матрица ,на которую нужно умножить
     * @return произведение
     */
    public Matrix multiplyMatrix(Matrix obj) {
        Matrix tmp = new Matrix(this.matrix.length, obj.matrix[0].length);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < obj.matrix[0].length; j++) {
                for (int k = 0; k < this.matrix[0].length; k++) {
                    tmp.matrix[i][j] += matrix[i][k] * obj.matrix[k][j];
                }
            }
        }
        return tmp;
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                build.append("[").append(this.matrix[i][j]).append("]");
            }
            build.append("\n");
        }
        return build.toString();
    }
}
