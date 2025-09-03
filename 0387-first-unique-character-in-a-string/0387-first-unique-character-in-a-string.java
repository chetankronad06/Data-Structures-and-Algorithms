class Solution {
    public int firstUniqChar(String s) {
    //first soln
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     char[] arr = s.toCharArray();
    //     for (char c : arr) {
    //         map.put(c, map.getOrDefault(c, 0) + 1);
    //     }
    //     for (int i = 0; i < arr.length; i++) {
    //         if (map.get(arr[i]) == 1) {
    //             return i;
    //         }
    //     }

    //     return -1;
    // }


    // second soln
    int[] freq = new int[26];

    for (char c : s.toCharArray()) {
        freq[c - 'a']++;
    }
    for (int i = 0; i < s.length(); i++) {
        if (freq[s.charAt(i) - 'a'] == 1) {
            return i;
        }
    }
    return -1;
    }

}
