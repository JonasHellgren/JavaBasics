package apach_linear_algebra;



import org.apache.commons.math3.linear.*;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * https://commons.apache.org/proper/commons-math/userguide/linear.html
 * math3 is newer and better than math2
 */

public class TestMatrixAndVector {


    @Test
    public void given2DimMatrix_whenGettingRowAndColDimension_thenIsTwo() {
        double[][] matrixData = { {1d,2d,3d}, {2d,5d,3d}};
        RealMatrix m = MatrixUtils.createRealMatrix(matrixData);

        // One more with three rows, two columns, this time instantiating the
        // RealMatrix implementation class directly.
        double[][] matrixData2 = { {1d,2d}, {2d,5d}, {1d, 7d}};
        RealMatrix n = new Array2DRowRealMatrix(matrixData2);

        // Note: The constructor copies  the input double[][] array in both cases.

        // Now multiply m by n
        RealMatrix p = m.multiply(n);
        System.out.println(p.getRowDimension());    // 2
        System.out.println(p.getColumnDimension()); // 2

        Assert.assertEquals(2,p.getRowDimension());
        Assert.assertEquals(2,p.getColumnDimension());


        // Invert p, using LU decomposition
        RealMatrix inverse = MatrixUtils.inverse(p);


    }

    @Test public void given2DimMatrixAndVector_whenMultipling_thenVector() {

        double[][] matrixData = { {1d,1d,1d}, {1d,1d,1d}};
        RealMatrix m = MatrixUtils.createRealMatrix(matrixData);
        RealVector v = new ArrayRealVector(new double[]{1d, 2d,1d});

        RealVector vRes =m.operate(v);
        System.out.println("vRes = " + vRes);

        Assert.assertEquals(2,vRes.getDimension());


    }

}
