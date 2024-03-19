#include <stdio.h>
#include <fstream>
using std::cout;
using std::endl;
using std::ifstream;
using std::string;
class Matrix
{
public:
    Matrix(int);
    Matrix();
    ~Matrix();
    void readMatrix(string fileName);
    Matrix operator+(Matrix &B)
    {
        Matrix C;
        C.length = this->length;
        C.data = (float*) malloc(C.length);
        for (int i = 0; i < C.length; i++)
        {
            C.data[i] = this->data[i] + B.data[i];
        }
        return C;
    }
    void print();
    float *data;
    int length;
};
