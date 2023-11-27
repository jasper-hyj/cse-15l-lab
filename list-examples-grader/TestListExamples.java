import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.*;

class IsMoon implements StringChecker {

  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {

  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFilter() {
    List<String> list = new ArrayList<>() {
      {
        add("a");
        add("bd");
        add("c");
        add("ed");
        add("e");
        add("f");
        add("ger");
      }
    };

    assertArrayEquals(
      new String[] { "a", "c", "e", "f" },
      ListExamples.filter(list, new ImplStringChecker()).toArray()
    );
  }

  @Test(timeout = 500)
  public void testMerge() {
    List<String> list1 = new ArrayList<>() {
      {
        add("a");
        add("bd");
        add("c");
        add("ed");
        add("e");
        add("f");
        add("ger");
      }
    };
    List<String> list2 = new ArrayList<>() {
      {
        add("a");
        add("bd");
        add("c");
        add("ed");
        add("e");
        add("f");
        add("ger");
      }
    };
    assertArrayEquals(
      new ArrayList<>() {
        {
          add("a");

          add("a");
          add("bd");
          add("bd");
          add("c");
          add("c");
          add("e");
          add("e");
          add("ed");
          add("ed");
          add("f");
          add("f");
          add("ger");
          add("ger");
        }
      }
        .toArray(),
      ListExamples.merge(list1, list2).toArray()
    );
  }
}

class ImplStringChecker implements StringChecker {

  @Override
  public boolean checkString(String s) {
    return s.length() == 1;
  }
}
