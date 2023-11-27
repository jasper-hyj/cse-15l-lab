import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    @Test
    public void testFilter() {
        List<String> list = new ArrayList<>() {{
            add("a");
            add("bd");
            add("c");
            add("ed");
            add("e");
            add("f");
            add("ger");
        }};

        assertArrayEquals(new String[]{"a", "c", "e", "f"},
                ListExamples.filter(list, new ImplStringChecker()).toArray());
    }

    @Test
    public void testMerge() {
        List<String> list1 = new ArrayList<>() {{
            add("a");
            add("bd");
            add("c");
            add("ed");
            add("e");
            add("f");
            add("ger");
        }};
        List<String> list2 = new ArrayList<>() {{
            add("a");
            add("bd");
            add("c");
            add("ed");
            add("e");
            add("f");
            add("ger");
        }};
        assertArrayEquals(new ArrayList<>() {{
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
        }}.toArray(), ListExamples.merge(list1, list2).toArray());
    }
}

class ImplStringChecker implements StringChecker {

    @Override
    public boolean checkString(String s) {
        return s.length() == 1;
    }
}
