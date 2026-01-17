#include <iostream>
#include <fstream>

using namespace std;

int main() {
    double balance = 0;
    ifstream in("balance.txt");
    if (in) in >> balance;
    in.close();

    cout << "Current balance: " << balance << endl;

    cout << "Enter amount (+ for deposit, - for withdraw): ";
    double x;
    cin >> x;
    balance += x;

    ofstream out("balance.txt");
    out << balance;
    out.close();

    cout << "New balance: " << balance << endl;
}
