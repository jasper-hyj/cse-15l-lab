import static org.junit.Assert.*;

import org.junit.*;

public class ArrayTests {

  @Test
  public void testReverseInPlace() {
    int[] input1 = { 1, 2, 3, 4, 5, 6 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[] { 6, 5, 4, 3, 2, 1 }, input1);
  }

  @Test
  public void testReverseOneElementInPlace() {
    int[] input1 = { 1 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[] { 1 }, input1);
  }
  // @Test
  // public void testReversed() {
  //     int[] input1 = {1, 2, 3, 4, 5, 6};
  //     assertArrayEquals(new int[]{6, 5, 4, 3, 2, 1}, ArrayExamples.reversed(input1));
  // }

  // @Test
  // public void testAverageWithoutLowest() {
  //     double[] input1 = {2, 2, 3, 4, 5, 6};
  //     assertEquals(4.0, ArrayExamples.averageWithoutLowest(input1), 0.0001);

  // }
}
