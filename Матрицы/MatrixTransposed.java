public class MatrixTransposed {
    public static void main(String[] args) {
        int lines = 3;
        int col = 5;
        int M[][] = new int[lines][col];
        int TransposedM[][] = new int[col][lines];
        M = C_M(M);
        c_m(M);
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < lines; j++) {
                TransposedM[i][j] = M[j][i];
            }
        }
        System.out.println("========");
        c_m(TransposedM);
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