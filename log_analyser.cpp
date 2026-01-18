#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {
    string file;
    cout << "Log file: ";
    cin >> file;

    ifstream in(file);
    int errors = 0, warnings = 0;
    string line;

    while (getline(in, line)) {
        if (line.find("ERROR") != string::npos) errors++;
        if (line.find("WARN") != string::npos) warnings++;
    }

    cout << "Errors: " << errors << endl;
    cout << "Warnings: " << warnings << endl;
}
 log_analyser {
    
}
