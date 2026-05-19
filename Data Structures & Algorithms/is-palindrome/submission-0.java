
class Solution {
    public  static boolean isPalindrome(String s) {
     String str = s.replaceAll("[^a-zA-Z0-9]" , "").toLowerCase();
     String rstr = new StringBuilder(str).reverse().toString();

        return  str.equals((rstr));
    }

    public static void main (String[] args){
        String[] testStrings = {"Was it a car or a cat I saw?", "tab a cat"};
        for(String test : testStrings){
            System.out.println(test +"  " + isPalindrome(test));
        }
    }
}
