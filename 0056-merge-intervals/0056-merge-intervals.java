

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 1. Crucial Step: Sort intervals by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ls = new ArrayList<>();
        
        // Start by pushing the first interval into the list
        int[] currentInterval = intervals[0];
        ls.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // 2. If the next interval overlaps with the current one, merge them
            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // 3. If they don't overlap, move your pointer to the new interval
                currentInterval = interval;
                ls.add(currentInterval);
            }
        }

        // Convert List back to 2D Array
        return ls.toArray(new int[ls.size()][]);
    }
}