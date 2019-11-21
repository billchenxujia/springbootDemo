package effectiveJava.chapter8.item52;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * 类 @code(SetList)
 *
 * <p>
 *  功能简介：
 * <p>
* 重载导致问题（jdk5加入自动拆装箱后出现的）
* 重载不同导致了结果不可预测
 * <p>
 *  创建时间：2019年5月8日
 *
 * @author chenxj
 */
public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
        }

        System.out.println(set + " " + list);
    }
}
