class Solution {
       private static final Map<Character, String> dToL = new HashMap<>();
    
    static {
        dToL.put('2', "abc");
        dToL.put('3', "def");
        dToL.put('4', "ghi");
        dToL.put('5', "jkl");
        dToL.put('6', "mno");
        dToL.put('7', "pqrs");
        dToL.put('8', "tuv");
        dToL.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
         if(digits == null || digits.length() == 0){
             return new ArrayList<>();
         }
          List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }
    private static void backtrack(List<String> result, StringBuilder current, String digits, int index) {
       
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
       
        char digit = digits.charAt(index);
        String letters = dToL.get(digit);
        
      
        for (char letter : letters.toCharArray()) {
            current.append(letter);  
            backtrack(result, current, digits, index + 1); 
            current.deleteCharAt(current.length() - 1); 
        }
    }

}