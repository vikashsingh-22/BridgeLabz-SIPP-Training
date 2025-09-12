package Java_Methods.Level3;

public class Determinant {

    public static double determinant3x3(double[][] m) {
        return m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1])
             - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0])
             + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    public static double[][] inverse2x2(double[][] m) {
        double det = m[0][0]*m[1][1] - m[0][1]*m[1][0];
        if (det == 0) throw new ArithmeticException("Matrix is not invertible");
        double[][] inverse = new double[2][2];
        inverse[0][0] = m[1][1] / det;
        inverse[0][1] = -m[0][1] / det;
        inverse[1][0] = -m[1][0] / det;
        inverse[1][1] = m[0][0] / det;
        return inverse;
    }

    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0) throw new ArithmeticException("Matrix is not invertible");

        double[][] cofactor = new double[3][3];

        cofactor[0][0] = (m[1][1]*m[2][2] - m[1][2]*m[2][1]);
        cofactor[0][1] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]);
        cofactor[0][2] = (m[1][0]*m[2][1] - m[1][1]*m[2][0]);

        cofactor[1][0] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]);
        cofactor[1][1] = (m[0][0]*m[2][2] - m[0][2]*m[2][0]);
        cofactor[1][2] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]);

        cofactor[2][0] = (m[0][1]*m[1][2] - m[0][2]*m[1][1]);
        cofactor[2][1] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]);
        cofactor[2][2] = (m[0][0]*m[1][1] - m[0][1]*m[1][0]);

        double[][] adjugate = new double[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                adjugate[i][j] = cofactor[j][i];

        double[][] inverse = new double[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                inverse[i][j] = adjugate[i][j] / det;

        return inverse;
    }

    public static void printMatrix(String label, double[][] matrix) {
        System.out.println(label);
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%.2f\t", value);
            }
            System.out.println();
        }
    }
}

