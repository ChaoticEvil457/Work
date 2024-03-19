#include <cmath> //for nan
#include <iostream>
#include <limits>
#include <cstring> // Provides strchr
#include "mystack.h"

/*
Precondition: None
Postcondition: Reads the next line of input (including the newline character at the end of the line). It treats this input line as an arithmetic expression.
If the expression has an error (such as division by zero), then the function consumes the rest of the line and returns nan("Invalid").
Otherwise, the function sets okay to true and sets answer to the value of the expression. The function always consumes all characters in the input stream up to and including the newline.

Here are a few considerations:
   The input expressions are postfix expressions.
   Use the evaluation algorithm from Figure 7.10 in the textbook.

   The possible errors that will cause a return of nan("Invalid"):
       (a) division by zero,
       (b) an operation symbol is read but the stack does not have at least two numbers,
       (c) the entire expression has been read and evaluated but the numbers stack does not have exactly one number on it.
       Note: You will need to ignore the rest of the input line whenever you encounter an error to avoid infinite loop.
*/
double process_line(std::istream &ins)
{
    DS::mystack<double> s;
    double num;
    char op;
    while (ins && ins.peek() != '\n')
    {
        if (isdigit(ins.peek()) || ins.peek() == '.')
        {
            ins >> num;
            s.push(num);
        }
        else if (strchr("+-/*%", ins.peek()) != NULL)
        {
            ins >> op;
            if (op == '-' && (isdigit(ins.peek()) || ins.peek() == '.')) // negative numbers
            {
                ins >> num;
                s.push(-num);
            }
            else
            {
                if (s.size() < 2)
                {
                    s.push(nan("invalid")); // invalid if there aren't two numbers to operate on
                    break;
                }
                double right = s.top();
                s.pop();
                double left = s.top();
                s.pop();
                switch (op)
                {
                case '+':
                    s.push(left + right);
                    break;
                case '-':
                    s.push(left - right);
                    break;
                case '*':
                    s.push(left * right);
                    break;
                case '/':
                    if (right == 0)
                    {
                        s.push(nan("invalid")); // invalid if dividing by 0
                        break;
                    }
                    s.push(left / right);
                    break;
                case '%':
                    if (left < right)
                    {
                        s.push(nan("invalid")); // invalid if modulating a smaller by a larger
                        break;
                    }
                    s.push((int)left % (int)right);
                    break;
                }
            }
        }
        else
        {
            ins.ignore();
        }
        if (s.top() == nan("invalid"))
        {
            break;
        }
    }
    ins.ignore(1000, '\n');
    if (s.size() != 1)
    {
        s.push(nan("invalid")); // invalid with extra numbers or no numbers
    }
    return s.top();
}
