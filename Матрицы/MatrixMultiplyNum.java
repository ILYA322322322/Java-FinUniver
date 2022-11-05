import java.util.Scanner;

public class MatrixMultiplyNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input str: ");
        int lines = in.nextInt(); //кол-во строк
        System.out.print("Input colums: ");
        int col = in.nextInt();//кол-во столбцов
        System.out.print("Input a number: ");
        int num = in.nextInt();
        int M[][] = new int[lines][col];
        int MM[][] = new int[lines][col];
        M = C_M(M);
        c_matrix(M);
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < col; j++) {
                MM[i][j] = M[i][j]*num;
            }
        }
        System.out.println("    =    ");
        c_matrix(MM);
    }
    static int[][] C_M(int Vremenay_M[][]) {
        for (int i = 0; i < Vremenay_M.length; i++) {
            for (int j = 0; j < Vremenay_M[i].length; j++) {
                Vremenay_M[i][j] = (int) (Math.random() * 10); //ходим циклом по матрице и заполняем рандомными цифрами
            }
        }
        return Vremenay_M;
    }

    //создадим метод для вывода матрицы
    static void c_matrix(int Vremenay_M[][]) {
        for (int i = 0; i < Vremenay_M.length; i++) {
            for (int j = 0; j < Vremenay_M[i].length; j++) {
                System.out.print(Vremenay_M[i][j]+"\t");
            }
            System.out.println();//перенос строки
        }
    }
}