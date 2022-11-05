//Сложение двух матриц
public class MatrixAddition {
    public static void main(String[] args) {
        int One[][] = new int[2][3];
        int Two[][] = new int[2][3];
        int RESULT[][] = new int[2][3];
        One = C_M(One);
        Two = C_M(Two);
        c_m(One);
        System.out.println("    +    ");
        c_m(Two);
        for (int i = 0; i < RESULT.length; i++) {
            for (int j = 0; j < RESULT[i].length; j++) {
                RESULT[i][j] = One[i][j] + Two[i][j];
            }
        }
        System.out.println("    =    ");
        c_m(RESULT);
    }
    static int[][] C_M(int Vremenay_M[][]) {
        for (int i = 0; i < Vremenay_M.length; i++) {
            for (int j = 0; j < Vremenay_M[i].length; j++) {
                Vremenay_M[i][j] = (int) (Math.random() * 10);
            }
        }
        return Vremenay_M;
    }
    static void c_m(int Vremenay_M[][]) {
        for (int i = 0; i < Vremenay_M.length; i++) {
            for (int j = 0; j < Vremenay_M[i].length; j++) {
                System.out.print(Vremenay_M[i][j]+"\t");
            }
            System.out.println();
        }
    }
}