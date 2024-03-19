/*
Programmer Name: S. Miller
Purpose: Opens a file and reads one word as a time from the file
Update: Broke up fileTokens.h to fileTokens.h and fileTokens.cpp
Date Updated: 2021-15-4
*/

#ifndef FILETOKENS_H
#define FILETOKENS_H

#include <string>
#include <cctype>
#include <sstream>
#include <fstream>
#include <stdexcept>

namespace DS {

    class fileTokens {
    public:
        //Default constructor - NONE
        // do not allow default constructor
        fileTokens() = delete;

        //VALUE Constructors
        //Create an object wrapper around the file_name passed
        //Precondition: file exists and is readable
        //Postcondition: File is opened, will crash if file is unable to be read
        fileTokens(const std::string &, char fieldDelimiter=',', char recordDelimiter='\n');

        fileTokens(const char *, char fieldDelimiter=',', char recordDelimiter='\n');

        //Destructor
        //Precondition: n/a
        //Postcondition: Closes the file
        virtual ~fileTokens();

        //Accessors
        //Precondition: n/a
        //Postcondition: Returns true if the file has at least one word left and EOF has not been reached yet
        bool hasToken() const;

        //Mutators
        //Precondition: File still has words to read
        //Postcondition: Returns the next word in the file converted to lowercase. File pointer is moved to the start of
        //  the next word.
        std::string getNextToken(bool force_lowercase=false, bool numbers_only=false);

        long getNextLong();

    private:
        //Open the file
        bool open();

        //The file used for reading
        std::string file_name;

        //File stream, maintains seek pointer
        std::ifstream fin;

        char fieldDelimiter;
        char recordDelimiter;
    };

    long strToLong(const std::string&);
    std::string strToLower(const std::string&);

}
#endif //FILETOKENS_H
