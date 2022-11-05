public class MatrixDegree {
    public static void main(String[] args) {
        int One[][] = new int[3][3];
        int Two[][] = new int[3][3];
        int RESULT[][] = new int[3][3];
        One = C_M(One);
        Two = One;
        c_m(One);
        System.out.println("    ^    ");
        int n = 3;
        int power = 1;
        int RESULT_0[][] = new int[3][3];
        System.out.println(n);
        while (power < n) {
            for (int i = 0; i < One.length; i++) {
                for (int u = 0; u < Two[0].length; u++) {
                    for (int j = 0; j < Two.length; j++) {

                        RESULT[i][u] += Two[i][j] * One[j][u];
                    }
                }
            }
            Two = RESULT;
            RESULT = RESULT_0;
            power++;
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