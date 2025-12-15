class Solution {
    public int convertTime(String current, String correct) {
       int cur = toMinutes(current);
        int cor = toMinutes(correct);

        int diff = cor - cur;
        int ops = 0;

        int[] steps = {60, 15, 5, 1};
        for (int s : steps) {
            ops += diff / s;
            diff %= s;
        }
        return ops;
    }

    private int toMinutes(String t) {
        int h = Integer.parseInt(t.substring(0, 2));
        int m = Integer.parseInt(t.substring(3, 5));
        return h * 60 + m; 
    }
}