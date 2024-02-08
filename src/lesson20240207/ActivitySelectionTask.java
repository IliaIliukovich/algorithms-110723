package lesson20240207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ActivitySelectionTask {

    public static class Task {
        String name;
        int dealine;
        int cost;

        public Task(String name, int dealine, int cost) {
            this.name = name;
            this.dealine = dealine;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", dealine=" + dealine +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void main(String[] args) {
        Task task1 = new Task("A", 1, 100);
        Task task2 = new Task("B", 2, 200);
        Task task3 = new Task("C", 0, 300);
        Task task4 = new Task("D", 0, 400);
        Task task5 = new Task("E", 2, 500);

        List<Task> tasksToWork = getOptimalList(Arrays.asList(task1, task2, task3, task4, task5));
        tasksToWork.forEach(System.out::println);
    }

    public static List<Task> getOptimalList(List<Task> list) {
        list.sort((o1, o2) -> o2.cost - o1.cost);

        int maxDeadline = list.stream().map(task -> task.cost).mapToInt(value -> value).max().orElse(0);
        boolean[] isBusy = new boolean[maxDeadline];

        List<Task> tasksToWork = new ArrayList<>();
        for (Task t : list) {
            int currentDay = t.dealine;
            while (currentDay >= 0) {
                if (!isBusy[currentDay]) {
                    tasksToWork.add(t);
                    isBusy[currentDay] = true;
                    break;
                } else {
                    currentDay--;
                }
            }
        }
        tasksToWork.sort(Comparator.comparing(task -> task.dealine));
        return tasksToWork;
    }

}
