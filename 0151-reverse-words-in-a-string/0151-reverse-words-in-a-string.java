import java.util.*;

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder result = new StringBuilder();
        int idx = s.length() - 1;
        while (idx >= 0) {
            StringBuilder temp = new StringBuilder();
            while (idx >= 0 && s.charAt(idx) != ' ') {
                temp.append(s.charAt(idx));
                idx--;
            }
            result.append(temp.reverse());
            while (idx >= 0 && s.charAt(idx) == ' ') {
                idx--;
            }
            if (idx >= 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}