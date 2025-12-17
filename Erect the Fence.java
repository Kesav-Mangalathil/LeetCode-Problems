import java.util.*;

class Solution {
    public int[][] outerTrees(int[][] trees) {
        if (trees.length <= 3) return trees;

        // Sort by x, then y
        Arrays.sort(trees, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        List<int[]> lower = new ArrayList<>();
        for (int[] p : trees) {
            while (lower.size() >= 2 &&
                   cross(lower.get(lower.size() - 2),
                         lower.get(lower.size() - 1), p) < 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(p);
        }

        List<int[]> upper = new ArrayList<>();
        for (int i = trees.length - 1; i >= 0; i--) {
            int[] p = trees[i];
            while (upper.size() >= 2 &&
                   cross(upper.get(upper.size() - 2),
                         upper.get(upper.size() - 1), p) < 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(p);
        }

        // Remove last point of each (duplicate endpoints)
        lower.remove(lower.size() - 1);
        upper.remove(upper.size() - 1);

        // Use Set to avoid duplicates
        Set<String> seen = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int[] p : lower) {
            String key = p[0] + "," + p[1];
            if (seen.add(key)) result.add(p);
        }
        for (int[] p : upper) {
            String key = p[0] + "," + p[1];
            if (seen.add(key)) result.add(p);
        }

        return result.toArray(new int[result.size()][]);
    }

    private int cross(int[] o, int[] a, int[] b) {
        return (a[0] - o[0]) * (b[1] - o[1])
             - (a[1] - o[1]) * (b[0] - o[0]);
    }
}

