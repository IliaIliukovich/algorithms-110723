package lesson20231115;

public class MinCost {

/*
    Самый дешёвый путь
    В каждой клетке прямоугольной таблицы N*M записано некоторое число.
    Изначально игрок находится в левой верхней клетке.
    За один ход ему разрешается перемещаться в соседнюю клетку либо вправо, либо вниз
    (влево и вверх перемещаться запрещено).
    При проходе через клетку игрок платит определенную сумму, значение которой записано в этой клетке.
    Требуется найти минимальную стоимость пути, отдав которую игрок может попасть в правый нижний угол.
 */

    public static void main(String[] args) {
        int[][] costs = new int[][]{{0, 1, 4, 4},
                                    {4, 1, 1, 1},
                                    {4, 4, 4, 1},
                                    {4, 4, 4, 0}};
        System.out.println(calculateMinCost(costs));
        System.out.println(calculateMinCostMemo(costs));
    }

    public static int calculateMinCost(int[][] cost) {
        return minCost(cost, 0, 0);
    }

    private static int minCost(int[][] cost, int i, int j) {
        // some big number to avoid going beyond the boundaries of the array
        if (i >= cost.length || j >= cost[0].length) return 100000;
        // lower right corner case
        if ((i == cost.length - 1) && (j == cost[0].length - 1)) return cost[i][j];
        // recursion formula
        int minCost = cost[i][j] + Math.min(minCost(cost, i + 1, j), minCost(cost, i, j + 1));
        return minCost;
    }

    public static int calculateMinCostMemo(int[][] cost) {
        // cache array init
        int[][] minCache = new int[cost.length][cost[0].length];
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[0].length; j++) {
                minCache[i][j] = -1;
            }
        }
        return minCostMemo(cost, minCache, 0, 0);
    }

    private static int minCostMemo(int[][] cost, int[][] minCache, int i, int j) {
        // some big number to avoid going beyond the boundaries of the array
        if (i >= cost.length || j >= cost[0].length) return 100000;
        // check if the min cost value present in cache
        if (minCache[i][j] != -1) return minCache[i][j];
        // lower right corner case
        if ((i == cost.length - 1) && (j == cost[0].length - 1)) {
            minCache[i][j] = cost[i][j];
        } else // recursion formula fills the minCache array
            minCache[i][j] = cost[i][j] + Math.min(minCostMemo(cost, minCache, i + 1, j),
                    minCostMemo(cost, minCache, i, j + 1));
        return minCache[i][j];
    }


}
