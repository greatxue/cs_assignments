import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDequeTest {
    @Test
    /** This test performs addLast calls. */
    public void addLastTest() {
        Deque<String> lld1 = new ArrayDeque<>();

        lld1.addLast("front"); // ["front"]
        lld1.addLast("middle"); // ["front", "middle"]
        lld1.addLast("back"); // ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    /** This test performs interspersed addFirst and addLast calls. */
    public void addFirstAndAddLastTest() {
        Deque<Integer> lld1 = new ArrayDeque<>();
        lld1.addLast(0);   // [0]
        assertThat(lld1.toList()).containsExactly(0).inOrder();

        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]
        assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
    }

    @Test
    /** This test ensures whether empty() works well. */
    public void isEmptyTest() {
        Deque<String> lld1 = new ArrayDeque<>();
        assertThat(lld1.isEmpty()).isTrue();

        lld1.addFirst("isNotEmpty");
        assertThat(lld1.isEmpty()).isFalse();
    }


    @Test
    /** This test ensures whether size() returns the right size. */
    public void sizeTest() {
        Deque<String> lld1 = new ArrayDeque<>();
        assertThat(lld1.size()).isEqualTo(0);

        lld1.addFirst("size = 1");
        lld1.addLast("size = 2");
        assertThat(lld1.size()).isEqualTo(2);
    }

    @Test
    public void removeFirstAndLastTest() {
        Deque<String> lld1 = new ArrayDeque<>();

        lld1.addLast("front"); // ["front"]
        lld1.addLast("middle"); // ["front", "middle"]
        lld1.addLast("back"); // ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

        assertThat(lld1.removeLast()).isEqualTo("back"); // ["front", "middle"]
        assertThat(lld1.toList()).containsExactly("front", "middle").inOrder();

        assertThat(lld1.removeFirst()).isEqualTo("front"); // ["front", "middle"]
        assertThat(lld1.toList()).containsExactly( "middle").inOrder();


    }

    @Test
    public void resizeTest() {
        Deque<Integer> lld1 = new ArrayDeque<>();
        for (int i = 0; i < 16; i++) {
             lld1.addFirst(0);
         }
        assertThat(lld1.size()).isEqualTo(16);

        for (int i = 0; i < 13; i++) {
            lld1.removeFirst();
        }
        assertThat(lld1.size()).isEqualTo(4);
        // Set the breakpoint, step in to check the variable "items.length" within.


         }
}
