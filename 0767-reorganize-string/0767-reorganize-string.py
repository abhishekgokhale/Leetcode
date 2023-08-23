class Solution:
    def reorganizeString(self, s: str) -> str:
        counts = collections.Counter(s)
        maxFreq = max(counts.values())
        if maxFreq - 1 > sum(counts.values()) - maxFreq:
            return ""
        ans = []
        heap = []
        for k, v in counts.items():
            heap.append((-v, k))
        heapq.heapify(heap)
        c1, c2 = "", ""
        v1, v2 = 1, 1
        while heap:
            # print(heap)
            v1, c1 = heapq.heappop(heap)
            if heap:
                v2, c2 = heapq.heappop(heap)
            ans.append(c1)
            if c2:
                ans.append(c2)
            v1 += 1
            if v1 < 0:
                heapq.heappush(heap, (v1, c1))
            v2 += 1
            if v2 < 0:
                heapq.heappush(heap, (v2, c2))
            c2 = ""
        
        return "".join(ans)