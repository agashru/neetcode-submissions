class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s : tokens){
            if(!"+-/*".contains(s)){
                st.push(Integer.parseInt(s));
            } else{
                int num2 = st.pop();
                int num1 = st.pop();
                switch(s){
                    case "+" : {
                        st.push(num2 + num1);
                        break;
                    }
                    case "-": {
                        st.push(num1 - num2);
                        break;
                    }
                    case "*":{
                        st.push(num2 * num1);
                        break;
                    }
                    case "/":{
                        st.push(num1 / num2);
                        break;
                    }
                }
            }
        }
        return st.pop();
    }
}
