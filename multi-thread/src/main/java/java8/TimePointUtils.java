package java8;


import java.util.List;

public class TimePointUtils {
    public static TimePoint transferTime(String recordDate, List<String> timePoints) {
        TimePoint result = new TimePoint();
        int hour = Integer.parseInt(recordDate);

        // 3 7 11 15 19 23
        int size = timePoints.size();
        int realPoint = Integer.MIN_VALUE;
        for (int i = 0; i < size; i ++) {
            // 根据配置的时间点该判断规则也要变化，使用predicate即可
            if (hour >= Integer.parseInt(timePoints.get(i % size)) &&
                hour < Integer.parseInt(timePoints.get((i + 1) % size))) {
                realPoint = Integer.parseInt(timePoints.get(i % size));
            }
            if (realPoint == Integer.MIN_VALUE) {

                int t0 = Integer.parseInt(timePoints.get(0));
                int t1 = Integer.parseInt(timePoints.get(size - 1));
                if (hour < t0) {
                    realPoint = t1;
                }
                if (hour >= t1) {
                    realPoint = t1;
                }

            }
            // 添加predicate处理时间点转换时间的规则
            result.setTimePoint(realPoint + "");
        }


        return result;
    }
}
