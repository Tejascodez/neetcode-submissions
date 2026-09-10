class Solution {
    public String mergeAlternately(String word1, String word2) {

        StringBuilder sb = new StringBuilder();

        int i = 0; int j = 0;

        while(i < word1.length() && j < word2.length()){
            char ch = word1.charAt(i);
            char ch2 = word2.charAt(j);
            sb.append((ch));
            sb.append((ch2));

            i++;
            j++;
        }
        while(i < word1.length()){
            sb.append(word1.charAt(i));
            i++;
        }
            while(j < word2.length()){
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
        
    }
}