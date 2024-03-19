

#include "fileTokens.h"

namespace DS {

    fileTokens::fileTokens(const std::string &f, char fieldDelimiter, char recordDelimiter) : file_name(f) {
        this->fieldDelimiter = fieldDelimiter;
        this->recordDelimiter = recordDelimiter;
        open();
    }

    fileTokens::fileTokens(const char *f, char fieldDelimiter, char recordDelimiter) : file_name(f) {
        this->fieldDelimiter = fieldDelimiter;
        this->recordDelimiter = recordDelimiter;
        open();
    }

    bool fileTokens::open() {
        fin.open(file_name.c_str(), std::ifstream::in);
        if (fin.fail()) {
            throw std::runtime_error("Unable to open and/or read " + file_name);
        }

        return true;
    }

    bool fileTokens::hasToken() const {
        return !fin.eof();
    }

    std::string fileTokens::getNextToken(bool force_lowercase/*=false*/, bool numbers_only/*=false*/) {

        std::ostringstream s;
        size_t spaces = 0;
        char character;

        if (fin) {

            //Move over initial spaced
            while (fin && isspace(fin.peek()) )
                fin.ignore();

            while (fin && fin.peek() != fieldDelimiter and fin.peek() != recordDelimiter ) {
                character = fin.get();
                if ( !numbers_only || isdigit(character)) {
                    if (isspace(character)) {
                        ++spaces;
                    } else {
                        for (size_t i = 0; i < spaces; ++i)
                            s << ' ';
                        s << static_cast<char>(force_lowercase ? tolower(character) : character);
                        spaces = 0;
                    }
                }
            }

            //Move file pointer to start of next word
            if (fin)
                fin.ignore();

            while (fin && isspace(fin.peek()) )
                fin.ignore();

            return s.str();
        } else
            throw std::runtime_error("Unexpected end of file reached.");

    }

    fileTokens::~fileTokens() {
        fin.close();
    }

    long fileTokens::getNextLong() {
        std::string token = getNextToken(false, true);
        std::istringstream iss(token);
        long result;
        iss >> result;
        return result;

    }

    long strToLong(const std::string& s) {
        long n = 0;
        char c;
        std::istringstream iss(s);
        std::ostringstream oss;

        while ( iss >> c ) {
            if ( isdigit(c) )
                oss << c;
        }
        std::istringstream fss(oss.str());
        fss >> n;
        return n;
    }

    std::string strToLower(const std::string& s) {
        std::ostringstream oss;
        for ( auto c = s.begin() ; c != s.end() ; ++c )
            oss << static_cast<char>(tolower(*c));
        return oss.str();
    }
}