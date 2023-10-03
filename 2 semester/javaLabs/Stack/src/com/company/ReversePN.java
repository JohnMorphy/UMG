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

            // Operand (liczbę) zawsze dopisujemy do końcowego wyniku
            if (a.matches("[0-9]*"))
            {
                RPN += a + " ";
                k++;
                continue;
            }

            // Jeśli stos operatorów jest pusty, a nasz znak to operator to go dodajemy
            if (a.matches("[*/+-]") && operators.isEmpty())
            {
                operators.push(a);
                k++;
                continue;
            }

            // Jeśli na górze stosu znajduje się (, dodaj nowy operator do stosu
            if (a.matches("[*/+-]") && operators.peek().matches("[(]"))
            {
                operators.push(a);
                k++;
                continue;
            }

            // Jeśli nowy operator ma większy priorytet (od góry stosu), dodaj do stosu
            if (a.matches("[*/]") && operators.peek().matches("[+-]"))
            {
                operators.push(a);
                k++;
                continue;
            }

            // Jeśli nowy operator ma mniejszy lub równy priorytet, dopisz górę stosu do wyniku i dodaj do stosu
            if (a.matches("[+-]") && operators.peek().matches("[*/+-]"))
            {
                RPN += operators.pop() + " ";
                operators.push(a);
                k++;
                continue;
            }

            if (a.matches("[*/]") && operators.peek().matches("[*/]"))
            {
                RPN += operators.pop() + " ";
                operators.push(a);
                k++;
                continue;
            }

            // Lewy nawias zawsze dodajemy do stosu
            if(a.matches("[(]"))
            {
                operators.push(a);
                k++;
                continue;
            }

            // Jeśli nowy operator to prawy nawias, dopisuj do wyniku równania, aż znajdziesz lewy nawias.
            // Nawiasy są usuwane i nie znajdują się w prefiksie
            if(a.matches("[)]"))
            {
                while(!operators.peek().matches("[(]"))
                {
                    RPN += operators.pop() + " ";
                }
                operators.pop();
                k++;
                continue;
            }
        }

        // Dodajemy pozostałe operatory do wyniku
        while (!operators.isEmpty()) {
            RPN += operators.pop() + " ";
        }

        return RPN;
    }

    public static void display(String equation){
        System.out.println("Równanie: \n" + equation);

        String RPN = postfix(equation);
        System.out.println("Postfix: \n" + RPN);

        int outcome = sum(RPN);
        System.out.println("Wynik: \n" + outcome);

        System.out.println();
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

    }
}
