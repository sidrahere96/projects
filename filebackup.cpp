#include <iostream>
#include <filesystem>
#include <string>
#include <chrono>

using namespace std;
namespace fs = std::filesystem;

int main() {
    string src, dest;
    cout << "Source folder: ";
    cin >> src;
    cout << "Backup folder: ";
    cin >> dest;

    string timestamp = to_string(
        chrono::system_clock::now().time_since_epoch().count()
    );

    string newDir = dest + "/backup_" + timestamp;
    fs::create_directory(newDir);

    for (auto &p : fs::directory_iterator(src)) {
        if (fs::is_regular_file(p)) {
            fs::copy(p.path(), newDir + "/" + p.path().filename().string());
        }
    }

    cout << "Backup created in " << newDir << endl;
}
