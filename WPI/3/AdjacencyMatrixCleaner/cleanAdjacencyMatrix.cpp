#include <iostream>
#include <string>
#include <fstream>
#include <iomanip>

using namespace std;

const string INPUT_FILE = "data.txt";
const string OUTPUT_FILE = "output.txt";

int findLength()
{
    ifstream input;
    input.open(INPUT_FILE);
    if (input.is_open())
    {

        int len = 0; // counter variable
        string s;
        getline(input, s); // saves the first line of data to string s
        for (char c : s)
        {
            if (c > 47 && c < 58) // if the data is 0 or 1, it's valid, increase the stored length
            {
                len++;
            }
        }
        input.close();
        return len; // returns the length
    }
    return -1;
}
int main()
{
    int len = findLength(); // dimensions of the matrix
    string s;
    int *matrix = (int *)malloc(len * len * sizeof(int));
    int pos = 0;
    int edges = 0; // stores edges
    ifstream input;
    input.open(INPUT_FILE);
    if (input.is_open())
    {
        while (getline(input, s)) // for every line of the file
        {
            for (char c : s)
            {
                if (c == 48 || c == 49) // if the character found is a 1 or 0
                {
                    matrix[pos] = (int)c - 48; // store the character as an integer in the matrix
                    if (c == 49 && pos >= pos / len + len * (pos / len))
                    { // increments the edge counter if there is a connection (1) ignores previously checked rows
                        edges++;
                    }
                    pos++; // next position in the array
                }
            }
        }
        input.close();
    }
    ofstream output;
    output.open(OUTPUT_FILE);
    if (output.is_open())
    {
        output << "p " << len << " " << edges << "\n"; // first line is the number of vertices and edges
        for (int i = 0; i < len; i++)
        {
            for (int j = i; j < len; j++)
            {
                if (matrix[j + i * len] == 1) // if there's a connection add the edge to the file
                {
                    output << "e " << i << " " << j << "\n";
                }
            }
        }
        output.close();
    }
    free(matrix);
}
