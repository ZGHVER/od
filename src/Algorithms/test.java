package Algorithms;

public class test {
    public static void main(String[] args) {

        System.out.println(analyze("1+2-3+4-7+1+3-2-2"));
    }

    public static double analyze(String s) {
        Stack<Double> number=new Stack<>();
        Stack<String> operate=new Stack<>();

        for(int i=0 ;i<s.length();i++){
             String t=String.valueOf(s.charAt(i));
            switch (t) {
                case "(": operate.push(t); break;
                case "+": operate.push(t); break;
                case "-": operate.push(t); break;
                case "*": operate.push(t); break;
                case "/": operate.push(t); break;
                case ")": operate.push(t); break;
                default: number.push(Double.valueOf(t));break;
            }
        }
        return calculate(number,operate);
    }

    private static double calculate(Stack<Double> number, Stack<String> operate) {
        Stack<Double> n = new Stack<>();
        Stack<String> s = new Stack<>();
        String s1;

        while (true)
        {
            if (operate.isEmpty())
            {
                n.push(number.pop());
                return getValue(n, s);
            }
            s1 = operate.pop();
            switch (s1) {
                case ")": number.push(calculate(number, operate));break;
                case "(":n.push(number.pop());
                        return getValue(n, s);
                default:
                    s.push(s1);
                    n.push(number.pop());
                    break;
            }
        }
    }

    private static double getValue(Stack<Double> number,Stack<String> opera)
    {
        Stack<Double> n = new Stack<>();
        Stack<String> s = new Stack<>();


        while (!opera.isEmpty())
        {
            String ss = opera.pop();
            switch (ss) {
                case "*":
                    number.push(number.pop() * number.pop());
                    break;
                case "/":
                    number.push(number.pop() / (number.pop()));
                    break;
                default:
                    s.push(ss);
                    n.push(number.pop());
                    break;
            }
        }
        n.push(number.pop());
        {
            Stack<Double> nu = n;
            n = new Stack<>();
            while (!nu.isEmpty())
                n.push(nu.pop());
            Stack<String> nus = s;
            s = new Stack<>();
            while (!nus.isEmpty())
                s.push(nus.pop());
        }
        while (!s.isEmpty())
        {
            String op = s.pop();
            switch (op)
            {
                case "+":
                    n.push(n.pop() + n.pop());
                    break;
                case "-":
                    n.push(n.pop()-n.pop());
                    break;
            }
        }
        return n.pop();
    }

}
