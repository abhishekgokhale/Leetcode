class Codec:
    def encode(self, strs: List[str]) -> str:
        """Encodes a list of strings to a single string.
        """
        encoded = ''
        for s in strs:
            encoded += str(len(s)) + '/:' + s
        return encoded

    def decode(self, s: str) -> List[str]:
        """Decodes a single string to a list of strings.
        """
        decoded = []
        i = 0
        while i < len(s):
            delim = s.find('/:', i)
            length = int(s[i:delim])
            str_ = s[delim+2: delim+2+length]
            decoded.append(str_)
            i = delim + 2 + length
        
        return decoded


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))