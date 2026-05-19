class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();


        for(String token : tokens){
            
            if(token.equals("+")   || token.equals("-") || token.equals("/") || token.equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;


                switch(token){
                    case "+" : result = a + b; break;
                    case "-" : result = a - b; break;
                    case "/" :  if (b == 0) {
                            throw new ArithmeticException("Divide by zero");
                        }
                        result = a / b;
                        break;
                    case "*" : result = a * b; break;
                }
                stack.push(result);
                
            }else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
