package Algorithms;

import java.util.Stack;

public class ExpressionToDouble {
    private static boolean isNumber(char ch){
        return ch == '.' || (ch >= '0' && ch <= '9');
    }

    private static void hasAddOrSub(Stack<Character> s, char operation){
        StringBuilder number = new StringBuilder();
        while(true){
            char cur = s.peek();
            if (cur == operation)
                break;

            number.insert(0, cur);
            s.pop();
        }

        s.pop();
        double right = Double.parseDouble(number.toString());
        number.replace(0, number.length(), "");

        while(!s.isEmpty()){
            char cur = s.peek();
            number.insert(0, cur);
            s.pop();
        }

        double left = Double.parseDouble(number.toString());
        number.replace(0, number.length(), "");

        double res;
        if (operation == '+')
            res = left + right;
        else
            res = left -right;
        String str = res + "";
        for(char chr : str.toCharArray()){
            s.push(chr);
        }
    }

    private static void hasMulOrDiv(Stack<Character> s, char opration){
        StringBuilder number = new StringBuilder();
        while(true){
            char cur = s.peek();
            if (cur == opration)
                break;

            number.insert(0, cur);
            s.pop();
        }

        s.pop();
        double right = Double.parseDouble(number.toString());
        number.replace(0, number.length(), "");

        while(!s.isEmpty()){
            char cur = s.peek();
            if (cur == '+' || cur == '-')
                break;
            number.insert(0, cur);
            s.pop();
        }

        double left = Double.parseDouble(number.toString());
        number.replace(0, number.length(), "");
        double res;
        if (opration == '*')
            res = left * right;
        else
            res = left / right;

        String str = res + "";
        for(char chr : str.toCharArray()){
            s.push(chr);
        }
    }

    private static boolean checkInfo(char []datas){
        for(int i = 0; i < datas.length-1; i++){
            if (!isNumber(datas[i]) && !isNumber(datas[i+1]))
                return false;
            if (datas[i] == '.' && datas[i+1] == '.')
                return false;
        }
        return true;
    }

    private static String StringToRes(String info){
        Stack<Character> s = new Stack<>();
        char []dates = info.toCharArray();
        if (!checkInfo(dates))
            return "";
        boolean hasAdd = false;
        boolean hasSub = false;
        boolean hasMul = false;
        boolean hasDiv = false;

        for (char ch : dates){
            if (isNumber(ch)){
                s.push(ch);
            }
            else{
                switch(ch){
                    case '+':
                        if (hasMul){
                            hasMulOrDiv(s, '*');
                            hasMul = false;
                        }

                        if (hasDiv){
                            hasMulOrDiv(s, '/');
                            hasDiv = false;
                        }

                        if (hasAdd){
                            hasAddOrSub(s, '+');
                            hasAdd = false;
                        }

                        if (hasSub){
                            hasAddOrSub(s, '-');
                            hasSub = false;
                        }

                        s.push(ch);
                        hasAdd = true;
                        break;
                    case '-':
                        if (hasMul){
                            hasMulOrDiv(s, '*');
                            hasMul = false;
                        }

                        if (hasDiv){
                            hasMulOrDiv(s, '/');
                            hasDiv = false;
                        }

                        if (hasAdd){
                            hasAddOrSub(s, '+');
                            hasAdd = false;
                        }

                        if (hasSub){
                            hasAddOrSub(s, '-');
                            hasSub = false;
                        }

                        s.push(ch);
                        hasSub = true;
                        break;
                    case '*':
                        if (hasMul){
                            hasMulOrDiv(s, '*');
                            hasMul = false;
                        }

                        if (hasDiv){
                            hasMulOrDiv(s, '/');
                            hasDiv = false;
                        }
                        s.push(ch);
                        hasMul = true;
                        break;
                    case '/':
                        if (hasMul){
                            hasMulOrDiv(s, '*');
                            hasMul = false;
                        }

                        if (hasDiv){
                            hasMulOrDiv(s, '/');
                            hasDiv = false;
                        }
                        s.push(ch);
                        hasDiv = true;
                        break;
                    case '=':
                        if (hasMul){
                            hasMulOrDiv(s, '*');
                            hasMul = false;
                        }

                        if (hasDiv){
                            hasMulOrDiv(s, '/');
                            hasDiv = false;
                        }

                        if (hasAdd){
                            hasAddOrSub(s, '+');
                            hasAdd = false;
                        }

                        if (hasSub){
                            hasAddOrSub(s, '-');
                            hasSub = false;
                        }

                        StringBuilder number = new StringBuilder();
                        while(!s.isEmpty()){
                            char cur = s.peek();
                            number.insert(0, cur);
                            s.pop();
                        }
                        return number.toString();

                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(StringToRes("3*4+2+4*3="));
    }

}

