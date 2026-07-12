class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;   
    }
    private void backtrack(String s, int index, List<String> current, List<String> result) {
    
        
        if (current.size() == 4 && index == s.length()) {
            result.add(String.join(".", current));
            return;
        }

     
        if (current.size() == 4) return;

       
        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);
            
           
            if (isValid(part)) {
                current.add(part); 
                backtrack(s, index + len, current, result); 
                current.remove(current.size() - 1); 
            }
        }
    }

   
    private boolean isValid(String part) {
        if (part.length() > 1 && part.startsWith("0")) return false; 
        int value = Integer.parseInt(part);
        return value >= 0 && value <= 255;
    }
}