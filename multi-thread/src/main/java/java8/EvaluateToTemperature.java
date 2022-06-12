package java8;

import java.util.ArrayList;
import java.util.List;

public class EvaluateToTemperature {

    public static void main(String[] args) {
        List<EvaluateRecord> records = getRecords();
        List<String> timePoints = new ArrayList<>();
        timePoints.add("4");
        timePoints.add("8");
        timePoints.add("12");
        timePoints.add("16");
        timePoints.add("20");
        timePoints.add("24");
        List<TimePoint> result = transferTime(records, timePoints);

        result.forEach(timePoint -> System.out.println(timePoint.toString()));
    }

    private static List<TimePoint> transferTime(List<EvaluateRecord> records, List<String> timePoints) {
        List<TimePoint> result = new ArrayList<>();
        records.forEach(point -> result.add(TimePointUtils.transferTime(point.getRecordDate(), timePoints)));

        return result;
    }

    private static List<EvaluateRecord> getRecords() {
        // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        List<EvaluateRecord> result = new ArrayList<>();
        for (int i = 0; i <= 23; i ++) {
            EvaluateRecord record = new EvaluateRecord();
            record.setRecordCode(i + "");
            record.setRecordDate(i + "");
            result.add(record);
        }

        return result;
    }
}
