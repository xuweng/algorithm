package com.leetcode.tag.dfs.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 17.07. 婴儿名字
 * <p>
 * 图论算法.图论算法.图论算法
 * <p>
 * 十分钟看答案.看代码.
 */
public class TrulyMostPopular {
    /**
     * 并查集
     * <p>
     * 作者：accountofjizhiwei
     * 链接：https://leetcode-cn.com/problems/baby-names-lcci/solution/bing-cha-ji-si-lu-yong-hashmapzuo-95ms-by-accounto/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public String[] trulyMostPopular(String[] names, String[] synonyms) {
            Map<String, Integer> map = new HashMap<>();
            Map<String, String> unionMap = new HashMap<>();     //并查集， key(子孙)->value(祖宗)
            for (String name : names) {     //统计频率
                int idx1 = name.indexOf('(');
                int idx2 = name.indexOf(')');
                int frequency = Integer.parseInt(name.substring(idx1 + 1, idx2));
                map.put(name.substring(0, idx1), frequency);
            }
            for (String pair : synonyms) {  //union同义词
                int idx = pair.indexOf(',');
                String name1 = pair.substring(1, idx);
                String name2 = pair.substring(idx + 1, pair.length() - 1);
                while (unionMap.containsKey(name1)) {   //找name1祖宗
                    name1 = unionMap.get(name1);
                }
                while (unionMap.containsKey(name2)) {   //找name2祖宗
                    name2 = unionMap.get(name2);
                }
                if (!name1.equals(name2)) {   //祖宗不同，要合并
                    int frequency = map.getOrDefault(name1, 0) + map.getOrDefault(name2, 0);    //出现次数是两者之和
                    String trulyName = name1.compareTo(name2) < 0 ? name1 : name2;
                    String nickName = name1.compareTo(name2) < 0 ? name2 : name1;
                    unionMap.put(nickName, trulyName);      //小名作为大名的分支，即大名是小名的祖宗
                    map.remove(nickName);       //更新一下数据
                    map.put(trulyName, frequency);
                }
            }
            String[] res = new String[map.size()];
            int index = 0;
            for (String name : map.keySet()) {
                String sb = name + '(' +
                        map.get(name) +
                        ')';
                res[index++] = sb;
            }
            return res;
        }
    }

    class Solution1 {
        HashMap<String, Integer> nameIndexMap;
        HashMap<String, String> disJoinMap;
        int[] frequencies;
        String[] pureNames;

        public String[] trulyMostPopular(String[] names, String[] synonyms) {
            disJoinMap = new HashMap<>();
            nameIndexMap = new HashMap<>();
            int n = names.length;
            frequencies = new int[n];
            pureNames = new String[n];

            UF set = new UF(n);
            int i = 0;
            for (String nameCount : names) {
                int index1 = nameCount.indexOf("(");
                String name = nameCount.substring(0, index1);
                String count = nameCount.substring(index1 + 1, nameCount.length() - 1);
                int countInt = Integer.parseInt(count);

                frequencies[i] = countInt;
                nameIndexMap.put(name, i);
                pureNames[i++] = name;
            }

            for (String synName : synonyms) {
                int index2 = synName.indexOf(",");
                String name1 = synName.substring(1, index2);
                String name2 = synName.substring(index2 + 1, synName.length() - 1);

                if (nameIndexMap.containsKey(name1) && nameIndexMap.containsKey(name2)) {
                    set.union(nameIndexMap.get(name1), nameIndexMap.get(name2));
                }
            }

            int[] counts = new int[n];
            for (int j = 0; j < n; j++) {
                int index = set.find(j);
                counts[index] += frequencies[j];
            }


            List<String> resList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (counts[j] != 0) {
                    String sb = pureNames[j] + '(' +
                            counts[j] +
                            ')';
                    resList.add(sb);
                }
            }

            return resList.toArray(new String[0]);
        }

        private class UF {
            int[] f;
            int[] sf;

            UF(int n) {
                f = new int[n];
                sf = new int[n];

                for (int i = 0; i < n; i++) {
                    f[i] = i;
                    sf[i] = 1;
                }
            }

            public int find(int x) {
                while (x != f[x]) {
                    x = f[x];
                }
                return x;
            }

            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);

                if (rootX == rootY) {
                    return;
                }
                //长名字合并到短名字
                if (pureNames[rootX].compareTo(pureNames[rootY]) > 0) {
                    f[rootX] = rootY;
                } else {
                    f[rootY] = rootX;
                }
            }
        }

    }

}
