import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest2 {
	
	@Test
	public void test01_MatrixConstructor_1() {
		Matrix m = new Matrix();
		assertEquals("", 1, m.imp.length);
		assertEquals("", 1, m.imp[0].length);
	}
	
	@Test
	public void test02_MatrixConstructor_2() {
		Matrix m = new Matrix(3, 4);
		assertEquals("Matrix with 3 rows", 3, m.imp.length);
		for(int r = 0; r < 3; r++) {
			assertEquals("4 columns on row " + r + " of matrix", 4, m.imp[r].length);
		}
	}

}
