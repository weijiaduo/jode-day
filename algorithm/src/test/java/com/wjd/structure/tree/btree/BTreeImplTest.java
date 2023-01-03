package com.wjd.structure.tree.btree;

import com.wjd.algorithm.tree.btree.build.BTreeLevelBuilder;
import com.wjd.algorithm.tree.btree.traverse.BTreeLevelTraverse;
import com.wjd.util.IOUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BTreeImplTest {

    @Test
    void testGet() {
        int m = 4;
        List<List<Integer>> values = Arrays.asList(
                List.of(21, 22),
                List.of(11, 12),
                null,
                List.of(31, 32, 33),
                List.of(1, 2)
        );

        BTreeImpl<Integer, Integer> btree = buildBTree(m, values);

        // 验证存在的值
        assertEquals(1, btree.get(1));
        assertEquals(2, btree.get(2));
        assertEquals(11, btree.get(11));
        assertEquals(12, btree.get(12));
        assertEquals(21, btree.get(21));
        assertEquals(22, btree.get(22));
        assertEquals(31, btree.get(31));
        assertEquals(32, btree.get(32));
        assertEquals(33, btree.get(33));
        // 验证不存在的值，左右边界
        assertNull(btree.get(0));
        assertNull(btree.get(3));
        assertNull(btree.get(20));
        assertNull(btree.get(23));
        assertNull(btree.get(30));
        assertNull(btree.get(34));
        assertNull(btree.get(40));
        assertNull(btree.get(43));
    }

    @Test
    void testPut() {
        int m = 5;
        BTreeImpl<Integer, Integer> btree = new BTreeImpl<>(m);
        // 1. 空树插入
        btree.put(39, 39);
        btree.put(22, 22);
        btree.put(97, 97);
        btree.put(41, 41);
        assertEquals("[[22, 39, 41, 97]]", btree.toString());

        // 2. 根节点分裂
        btree.put(53, 53);
        assertEquals("[[41], [22, 39], [53, 97]]", btree.toString());

        // 3. 叶子节点分裂
        btree.put(13, 13);
        btree.put(21, 21);
        btree.put(40, 40);
        assertEquals("[[22, 41], [13, 21], [39, 40], [53, 97]]", btree.toString());

        btree.put(30, 30);
        btree.put(27, 27);
        btree.put(33, 33);
        assertEquals("[[22, 33, 41], [13, 21], [27, 30], [39, 40], [53, 97]]", btree.toString());

        btree.put(36, 36);
        btree.put(35, 35);
        btree.put(34, 34);
        assertEquals("[[22, 33, 36, 41], [13, 21], [27, 30], [34, 35], [39, 40], [53, 97]]", btree.toString());

        btree.put(24, 24);
        btree.put(29, 29);
        assertEquals("[[22, 33, 36, 41], [13, 21], [24, 27, 29, 30], [34, 35], [39, 40], [53, 97]]", btree.toString());

        // 4. 内部节点分裂
        btree.put(26, 26);
        assertEquals("[[33], [22, 27], [36, 41], [13, 21], [24, 26], [29, 30], [34, 35], [39, 40], [53, 97]]", btree.toString());
    }

    /**
     * 验证删除叶子节点的情况
     */
    @Test
    void testLeafRemove() {
        int m = 5;
        String s = "[[33], [22, 27, 30], [36, 41], [13, 17, 21], [23, 24, 25, 26], [28, 29], [31, 32], [34, 35], [39, 40], [53, 97]]";
        List<List<Integer>> values = toListList(s);
        BTreeImpl<Integer, Integer> btree = buildBTree(m, values);

        // 1. 删除叶子节点元素，节点仍然合法
        btree.remove(21);
        assertEquals("[[33], [22, 27, 30], [36, 41], [13, 17], [23, 24, 25, 26], [28, 29], [31, 32], [34, 35], [39, 40], [53, 97]]", btree.toString());

        // 2. 删除叶子节点元素，节点变成非法，右兄弟可借
        btree.remove(13);
        assertEquals("[[33], [23, 27, 30], [36, 41], [17, 22], [24, 25, 26], [28, 29], [31, 32], [34, 35], [39, 40], [53, 97]]", btree.toString());

        // 3. 删除叶子节点元素，节点变成非法，左兄弟可借
        btree.remove(29);
        assertEquals("[[33], [23, 26, 30], [36, 41], [17, 22], [24, 25], [27, 28], [31, 32], [34, 35], [39, 40], [53, 97]]", btree.toString());

        // 4. 删除叶子节点元素，节点变成非法，父子节点合并
        btree.remove(24);
        assertEquals("[[33], [26, 30], [36, 41], [17, 22, 23, 25], [27, 28], [31, 32], [34, 35], [39, 40], [53, 97]]", btree.toString());
    }

    /**
     * 验证删除内部节点的情况
     */
    @Test
    void testInternalRemove() {
        int m = 5;
        String s = "[[33], [22, 27, 30], [36, 41], [13, 17, 21], [23, 24, 25, 26], [28, 29], [31, 32], [34, 35], [39, 40], [53, 97]]";
        List<List<Integer>> values = toListList(s);
        BTreeImpl<Integer, Integer> btree = buildBTree(m, values);

        // 1. 删除内部节点元素，使用前驱节点替代，然后删除
        btree.remove(22);
        assertEquals("[[33], [21, 27, 30], [36, 41], [13, 17], [23, 24, 25, 26], [28, 29], [31, 32], [34, 35], [39, 40], [53, 97]]", btree.toString());

        // 2. 删除内部节点元素，使用后驱节点替代，然后删除
        btree.remove(21);
        assertEquals("[[33], [23, 27, 30], [36, 41], [13, 17], [24, 25, 26], [28, 29], [31, 32], [34, 35], [39, 40], [53, 97]]", btree.toString());

        // 3. 删除内部节点元素，节点变成非法，左兄弟可借
        btree.remove(36);
        assertEquals("[[30], [23, 27], [33, 41], [13, 17], [24, 25, 26], [28, 29], [31, 32], [34, 35, 39, 40], [53, 97]]", btree.toString());

        // 4. 删除内部节点元素，节点变成非法，父子节点合并
        btree.remove(25);
        btree.remove(23);
        assertEquals("[[27, 30, 33, 41], [13, 17, 24, 26], [28, 29], [31, 32], [34, 35, 39, 40], [53, 97]]", btree.toString());
    }

    /**
     * 验证节点元素满了以后的分裂
     */
    @Test
    void testBTNodeAdd() {
        List<List<Integer>> expect = Arrays.asList(
                List.of(3),
                List.of(1, 2),
                List.of(4)
        );
        int m = 4;
        BTNode<Integer, Integer> root = new BTNode<>(m);
        root = root.add(1, 1);
        root = root.add(2, 2);
        root = root.add(3, 3);
        // 节点分裂
        root = root.add(4, 4);

        List<List<Integer>> actual = new BTreeLevelTraverse<Integer, Integer>().traverse(root);
        assertEquals(expect.toString(), actual.toString());
    }

    /**
     * 字符串转成二维列表
     *
     * @param s 字符串
     * @return 二维列表
     */
    private List<List<Integer>> toListList(String s) {
        Integer[][] matrix = IOUtils.toBoxIntMatrix(s);
        List<List<Integer>> values = new ArrayList<>();
        for (Integer[] arr : matrix) {
            if (arr == null) {
                values.add(null);
            } else {
                values.add(Arrays.asList(arr));
            }
        }
        return values;
    }

    /**
     * 构建B-树
     *
     * @param values 层序遍历列表
     * @return B-树
     */
    private BTreeImpl<Integer, Integer> buildBTree(int m, List<List<Integer>> values) {
        try {
            BTreeImpl<Integer, Integer> btree = new BTreeImpl<>(m);
            BTNode<Integer, Integer> root = new BTreeLevelBuilder().build(values);
            // 因为没有开放根节点，所以直接通过反射来设值
            Field rootField = BTreeImpl.class.getDeclaredField("root");
            rootField.setAccessible(true);
            rootField.set(btree, root);
            rootField.setAccessible(false);
            return btree;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}