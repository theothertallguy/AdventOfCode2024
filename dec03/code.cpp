#include <fstream>
#include <vector>
#include <iostream>
#include <iterator>
#include <sstream>
#include <regex>
#include <string>
using namespace std;



string readInput() {
    string filePath = "input.txt";
    ifstream file(filePath);
    string line;
    string ret = "";
    while (getline(file, line)) {
        ret = ret + line;
    }
    file.close();

    return ret;
}

vector<string> regexWork(string input, bool mode, regex rex) {
    vector<string> arr;
    const string s = input;
    auto words_begin = sregex_iterator(s.begin(), s.end(), rex);
    auto words_end = sregex_iterator();

    for (sregex_iterator i = words_begin; i != words_end; ++i)
    {
        smatch match = *i;
        string match_str = match.str();
        arr.push_back(match_str);
    }

    return arr;
}

void mathWork(vector<string> mulStrings) {

    int index = mulStrings.size();

    int nums = 0;

    bool enabled = true;

    for (int i = 0; i < index; i++) {
        if (enabled && (mulStrings[i].find("mul") != -1)) {
            string pair = mulStrings[i].substr(4,(mulStrings[i].length()-5));
            int comma = pair.find(',');

            string left = pair.substr(0,comma);
            string right = pair.substr(comma+1);

            nums += stoi(left) * stoi(right);
        } else if (enabled && (mulStrings[i] == "don't()")) {
            enabled = false;
        } else if (!enabled && (mulStrings[i] == "do()")) {
            enabled = true;
        }
    }

    cout << nums << endl;
}

int main() {
    string input = readInput();
    //cout << input;

    vector<string> mulStrings;
    vector<string> mulStrings2;
    regex words_regex("(mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\))");
    regex words_regex2("(mul\\(\\d+,\\d+\\))");
    
    mulStrings = regexWork(input, true, words_regex);
    mathWork(mulStrings);
    mulStrings2 = regexWork(input, true, words_regex2);
    mathWork(mulStrings2);
    return 0;
}