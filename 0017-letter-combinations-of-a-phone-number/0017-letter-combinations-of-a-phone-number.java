import java.util.*;

class Solution {
    private HashMap<Integer, String> Map = new HashMap<>();

    public Solution() {
        Map.put(2, "abc");
        Map.put(3, "def");
        Map.put(4, "ghi");
        Map.put(5, "jkl");
        Map.put(6, "mno");
        Map.put(7, "pqrs");
        Map.put(8, "tuv");
        Map.put(9, "wxyz");
    }

    public void solve(String digits, int i, List<String> res, StringBuilder temp) {
        if (i >= digits.length()) {
            if (temp.length() > 0) {
                res.add(temp.toString());
            }
            return;
        }
        char ch = digits.charAt(i);
        String value = Map.get(ch - '0'); 
        for (char chr : value.toCharArray()) {
            temp.append(chr);
            solve(digits, i + 1, res, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        solve(digits, 0, res, new StringBuilder());
        return res;
    }
}
