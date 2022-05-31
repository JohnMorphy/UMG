package com.company;

public class ReversePN {

    public static String postfix(String equation) {
        String[] splitEquation = equation.split(" ");
        Stack<String> operators = new Stack<String>();

        String RPN="";
        String a;
        int k=0;
        while (k < splitEquation.length) {
            a = splitEquation[k];
            if (a.matches("[0-9]*"))
            {
                RPN += a;
                k++;
                continue;
            }

            if (a.matches("[*/+()-]") && operators.isEmpty())
            {
                operators.push(a);
                k++;
                continue;
            }

            if

        }
        return RPN;
    }

    public static int sum(String RPN) {
        String[] splitRPN = RPN.split(" ");
        Stack<Integer> valueStack = new Stack<Integer>();
        String a;
        int k = 0;
        while (k < splitRPN.length) {
            a = splitRPN[k];
            if (a.matches("[0-9]*"))
                valueStack.push(Integer.parseInt(a));
            else {
                int outcome = 0, aa, bb;
                aa = valueStack.pop();
                bb = valueStack.pop();
                switch (a) {
                    case "-":
                        outcome = bb - aa;
                        break;
                    case "+":
                        outcome = bb + aa;
                        break;
                    case "*":
                        outcome = bb * aa;
                        break;
                    case "/":
                        outcome = bb / aa;
                        break;
                }
                valueStack.push(outcome);
            }
            k++;
        }
        return valueStack.peek();
    }
    public static void main(String[] args) {
        String equation = "( 100 + 11 ) * 10 / 20";
        System.out.println("Równanie: \n" + equation);

        String RPN = postfix(equation);
        System.out.println("Postfix: \n" + RPN);

        int outcome = sum(RPN);
        System.out.println("Wynik: \n" + outcome);
    }
}
