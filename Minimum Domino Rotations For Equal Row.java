class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
         int ans = check(tops[0], tops, bottoms);
        if (ans != -1) return ans;
        return check(bottoms[0], tops, bottoms);
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int rotateTop = 0, rotateBottom = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }
            if (tops[i] != target) rotateTop++;
            if (bottoms[i] != target) rotateBottom++;
        }
        return Math.min(rotateTop, rotateBottom);
    }
}