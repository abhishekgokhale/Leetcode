class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        Set<Pair<Integer, Integer>> seen = new HashSet<>();
        
        heap.add(new int[]{0, 0});
        seen.add(new Pair(0, 0));
        while(k > 0 && !heap.isEmpty()){
            // System.out.println(heap);
            int[] node = heap.remove();
            int i = node[0];
            int j = node[1];
            ans.add(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));
            if(0 <= i+1 && i+1 < nums1.length)
                if(!seen.contains(new Pair(i+1, j))){
                    heap.add(new int[]{i+1, j});
                    seen.add(new Pair(i+1, j));
                }
            if(0 <= j+1 && j+1 < nums2.length)
                if(!seen.contains(new Pair(i, j+1))){
                    heap.add(new int[]{i, j+1});
                    seen.add(new Pair(i, j+1));
                }
            k--;
        }
        return ans;
    }
}