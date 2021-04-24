package cn.edu.ctgu.Test6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class LinkedListTest {

    @ParameterizedTest
    @DisplayName("测试LinkList的remove方法")
    @CsvSource({
            "1,true",
            "5,false"
    })
    void removeTest(Integer node,boolean flag) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        boolean b = list.remove(node);
        assertEquals(flag, b);
    }
    @Test
    @DisplayName("测试LinkList的remove方法值为null返回为false的情况")
    void null_removeTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(false, list.remove(null));
    }
    @Test
    @DisplayName("测试LinkList的remove方法值为null返回为true的情况")
    void null_true_removeTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null);
        assertEquals(true, list.remove(null));
    }

}