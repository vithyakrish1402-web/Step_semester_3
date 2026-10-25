package arrays_and_complexity.assigment_problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PopularCanteenOrder {

    public static class PopularItemResult {
        private String item;
        private int count;

        public PopularItemResult(String item, int count) {
            this.item = item;
            this.count = count;
        }

        public String getItem() {
            return item;
        }

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return "(\"" + item + "\", " + count + ")";
        }
    }

    public static PopularItemResult mostPopular(String[] orders) {
        if (orders == null || orders.length == 0) {
            return new PopularItemResult("", 0);
        }

        Map<String, Integer> freqMap = new HashMap<>();
        int maxCount = 0;
        for (String order : orders) {
            int newCount = freqMap.getOrDefault(order, 0) + 1;
            freqMap.put(order, newCount);
            if (newCount > maxCount) {
                maxCount = newCount;
            }
        }

        for (String order : orders) {
            if (freqMap.get(order) == maxCount) {
                return new PopularItemResult(order, maxCount);
            }
        }

        return new PopularItemResult(orders[0], maxCount);
    }

    public static PopularItemResult mostPopular(List<String> orders) {
        if (orders == null || orders.isEmpty()) {
            return new PopularItemResult("", 0);
        }
        return mostPopular(orders.toArray(new String[0]));
    }

    public static void main(String[] args) {
        String[] orders1 = {"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"};
        System.out.println(mostPopular(orders1));

        String[] orders2 = {"tea", "coffee", "coffee", "tea"};
        System.out.println(mostPopular(orders2));
    }
}
