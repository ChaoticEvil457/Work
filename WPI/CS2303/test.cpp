#include <iostream>
#include <fstream>

void swap(int &a, int &b);
void fun();

int main()
{
    std::ofstream myfile; // ifstream >> read only
    myfile.open("example.txt");
    myfile << "writing to file" << std::endl;
    myfile.close();

    int j = 1;
    int &r = j;
    int x = 5;
    int y = 6;
    std::cout << x << y << std::endl;
    swap(x, y);
    std::cout << x << y << std::endl;
    fun();
}

void swap(int &a, int &b)
{
    int temp = a;
    a = b;
    b = temp;
}

void fun()
{
    int a = 0;
    int &r = a;
    r = r + 1;
    int *p = &r;
    std::cout << a << std::endl;
}