public class MatrixMultiply {
    public static void main(String[] args) {
        int One[][] = new int[2][3];
        int Two[][] = new int[3][2];
        int RESULT[][] = new int[2][2];
        One = C_V_M_R(One);
        Two = C_V_M_R(Two);
        outputmatrix(One);
        System.out.println("    *    ");
        outputmatrix(Two);
        for (int i = 0; i < One.length; i++) {
            for (int u = 0; u < Two[0].length; u++) {
                for (int j = 0; j < Two.length; j++) {
                    RESULT[i][u] += One[i][j] * Two[j][u];
                }
            }
        }
        System.out.println("    =    ");
        outputmatrix(RESULT);
    }
    static int[][] C_V_M_R(int Vremenay_M[][]) {
        for (int i = 0; i < Vremenay_M.length; i++) {
            for (int j = 0; j < Vremenay_M[i].length; j++) {
                Vremenay_M[i][j] = (int) (Math.random() * 10);
            }
        }
        return Vremenay_M;
    }
    static void outputmatrix(int Vremenay_M[][]) {
        for (int i = 0; i < Vremenay_M.length; i++) {
            for (int j = 0; j < Vremenay_M[i].length; j++) {
                System.out.print(Vremenay_M[i][j]+"\t");
            }
            System.out.println();
        }
    }
}