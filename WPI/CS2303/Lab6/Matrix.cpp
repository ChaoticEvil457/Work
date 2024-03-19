#include <iostream>
#include <string>
#include <iomanip>

#include "Matrix.h"

Matrix::Matrix(int l1){
    length = l1;
    data = new float[length];
    
}


Matrix::Matrix(){
    length = 0;
    data = NULL;
    
}



void Matrix::readMatrix(string fileName) {
    ifstream input;
    input.open(fileName);
    
    for (int i = 0; i < length; i++){
        input >> data[i];
    }
    input.close();
}




/*******************************************************************************
* void print(Matrix& A){
*
* Output:
*   Prints A to the screen
********************************************************************************/

void Matrix::print(){

   // print values to screen
    for (int i = 0; i < length; i++){
       cout << std::setw(8) << data[i];  
    }
    printf("\n");

}

/*******************************************************************************
* Matrix::~Matrix()
*
* Deconstructor for Matrix object
********************************************************************************/
Matrix::~Matrix(){
    delete data;
}