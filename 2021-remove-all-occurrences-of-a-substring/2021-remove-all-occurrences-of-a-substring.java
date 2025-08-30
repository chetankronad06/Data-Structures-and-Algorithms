class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int partLength = part.length();
        
        while (sb.indexOf(part) != -1) {
            int idx = sb.indexOf(part); 
            sb.delete(idx, idx + partLength); 
        }
        
        return sb.toString();
    }
}
