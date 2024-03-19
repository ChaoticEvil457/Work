#include <stdio.h>
#include <fstream>
using std::cout;
using std::endl;
using std::ifstream;
using std::ostream;
using std::string;
class Matrix
{
public:
    Matrix(int);
    Matrix();
    ~Matrix();
    void readMatrix(string fileName);
    Matrix operator+(Matrix &B);
    Matrix operator+(float);                                  // Allows A + 2.2
    friend Matrix operator+(float, const Matrix &A);          // Allows 2.2 + A
    friend ostream &operator<<(ostream &os, const Matrix &A); // Allows cout << A
    void print();
    float *data;
    int length;
};
