#include <iostream>
#include <string>
#include <queue>
#include <cmath>

/*
Write a recursive method that takes a string as a parameter.  
It returns a string composed of itself, and a mirror image of itself(reversed), 
separated by a hyphen.  Complete this function without the aid of a helper 
function and without the usage of the
string classes reverse method.
*/
std::string mirrorString(std::string);


/*
Write a recursive method that receives a queue of type int.
The function OUTPUTS to the passed ostream the reversed queue.
No temporary stack or queue should be used.
The original queue should appear the same as it was before calling.
Precondition: All integers in the queue will be less than or equal to 2147483646
*/
void outRevQueue(std::queue<int> &q, std::ostream &outs=std::cout);

/*
Write a recursive function to RETURN the nth term from the following SERIES
{ 0, 0.5, 1.5, 3, 5, 7.5 }
That is, the 0th term is 0, the 1st term is 0.5.
HINT: Only the 0th term is required to handle the base case.  The difference between each term depends on the previous
RULE EXCEPTION: You may use multiplication operator on the recursive step for this one
*/
double myseries( unsigned long n  );

/*
Given a non-negative long n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops).
Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
count7(717) = 2
count7(7) = 1
count7(123) = 0
*/
unsigned long count7( unsigned long n );

/*
Given an array of ints, is it possible to divide the ints into two groups, so
that the sum of the two groups is the same, with these constraints: all the
values that are multiple of 13 must be in one group, and all the values that
are a multiple of 3 (and not a multiple of 13) must be in the other. (No loops
needed.)
*/
bool split13_3(const long nums[], const size_t count);

/*
Write a recursive method that takes as parameters a String s and an integer i and returns a String that has s repeated i times.
For example, if the given string is "Go bears! " and the integer is 3 then the return value would be "Go bears! Go bears! Go bears! ".
(Note that if the integer is 0, then the empty string "" should be returned.)
*/
std::string repeat(std::string s, unsigned int i);

/*
Write and test a method mult with the following specification without using the multiplication operator.
Write a recursive method that performs the multiplication by repeated addition. Make your method work for both positive and
negative integers, as well as zero.
Start by calling a separate helper method that assumes both parameters are non-negative. Then, in the calling method,
make an adjustment afterwards for the case when the signs of the two original numbers were different.
PARAMETERS:   integers j and k
RETURN VALUE: the product j*k
*/
long mult(long j, long k);

//PROVIDED HELPER FUNCTION YOU MAY USE
//Precondition: n/a
//Postcondition: Returns the number of digits in number.
//  For example, when number is 3456, the function will return four.
template <typename T>
T getDigitCount(T number) {
    return floor(log10(number < 0 ? -number : number)) + 1;
}

//PROVIDED HELPER FUNCTION YOU MAY USE
//Precondition: n/a
//Postcondition: Returns  base to the integer power of exp (instead of having to manually cast
template <typename T>
T ipow(T base, T exp){
    return static_cast<T>(pow(static_cast<double>(base), static_cast<double>(exp)));
}

// Precondition: N/A
// Postcondition: Returns true if the passed integer is a palendrome. For example, 1221 is, and 1231 is not.
// Also, -1221 is a palendrome, and -1231 is not.
// Implement WITHOUT any additional helper functions. Avoid creating any local variables.
// Assume the number has no zeros.
bool isIntegerPalindrome(long long num);
