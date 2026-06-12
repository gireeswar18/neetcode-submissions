class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        List<List<Integer>> bucket = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            bucket.add(new ArrayList<>());
        }

        int[] res = new int[k];
        int ind = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            bucket.get(map.get(key)).add(key);
        }

        System.out.println(bucket);

        for (int i = n; i >= 0; i--) {
            int j = 0;
            if (bucket.get(i).size() > 0) {
                while(j < bucket.get(i).size() && ind < k) {
                    res[ind++] = bucket.get(i).get(j++);
                }
            }
        }

        return res;
    }
}
