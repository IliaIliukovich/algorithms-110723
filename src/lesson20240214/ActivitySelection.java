package lesson20240214;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

    public static void main(String[] args) {
        double startOfDay = 10.0;
        double endOfDay = 20.0;


        List<Activity> activityList = Arrays.asList(
                new Activity(10.0, 12.0),
                new Activity(19.0, 20.0),
                new Activity(10.5, 11.5),
                new Activity(13.0, 16.0),
                new Activity(14.0, 19.0),
                new Activity(16.0, 19.0));

        List<Activity> timetable = activitySelection(activityList, startOfDay, endOfDay);
        System.out.println("Max activities possible to arrange: " + timetable.size());
        timetable.forEach(System.out::println);
    }

    public static List<Activity> activitySelection(List<Activity> activityList, double startOfDay, double endOfDay) {
        activityList.sort(Comparator.comparing(activity -> activity.end));

        List<Activity> timetable = new ArrayList<>();
        double previousEnd = startOfDay;
        for (Activity activity : activityList) {
            if (activity.start >= previousEnd && activity.end <= endOfDay) {
                timetable.add(activity);
                previousEnd = activity.end;
            }
        }
        return timetable;
    }


    static class Activity {
        double start;
        double end;

        public Activity(double start, double end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }


}
