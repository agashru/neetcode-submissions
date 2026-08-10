class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s : tokens){
            if(!"+-/*".contains(s)){
                st.push(Integer.valueOf(s));
                continue;
            } else{
                int num2 = st.pop();
                int num1 = st.pop();
                int result = 0;
                switch(s){
                    case "+" :{
                        result = num1 + num2;
                        break;
                    }
                    case "-" :{
                        result = num1 - num2;
                        break;
                    }
                    case "*" :{
                        result = num1 * num2;
                        break;
                    }
                    case "/" :{
                        result = num1 / num2;
                        break;
                    }
                }
                st.push(result);
            }
        }
        return st.pop();
    }
}
