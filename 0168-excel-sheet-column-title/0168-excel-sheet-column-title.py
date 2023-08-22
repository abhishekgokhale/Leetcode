class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        ans = []
        while columnNumber > 0:
            ans.append(chr((columnNumber - 1) % 26 + ord('A')))
            columnNumber = math.floor((columnNumber - 1) / 26)
        return "".join(ans)[::-1]