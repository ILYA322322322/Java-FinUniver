public class MitrixSubtraction {//Вычитание матриц
        public static void main(String[] args) {
            int One[][] = new int[3][3];
            int Two[][] = new int[3][3];
            int Resultat[][] = new int[3][3];
            One = C_M(One);
            Two = C_M(Two);
            outputmatrix(One);
            System.out.println("    -    ");
            outputmatrix(Two);
            for (int i = 0; i < Resultat.length; i++) {
                for (int j = 0; j < Resultat[i].length; j++) {
                    Resultat[i][j] = One[i][j] - Two[i][j];
                }
            }
            System.out.println("    =    ");
            outputmatrix(Resultat);
        }
        static int[][] C_M(int Vremenay_M[][]) {
            for (int i = 0; i < Vremenay_M.length; i++) {
                for (int j = 0; j < Vremenay_M[i].length; j++) {
                    Vremenay_M[i][j] = (int) (Math.random() * 10); //ходим циклом по матрице и заполняем рандомными цифрами
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

