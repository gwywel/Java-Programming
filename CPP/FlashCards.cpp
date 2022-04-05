#include <iostream>
#include <ctime>
int main() {
  std::string cards[12] = {
  "I go (on foot) (imp.)", 
  "You (inf.) go (on foot) (imp.)", 
  "He goes (on foot) (imp.)",
  "We go (on foot) (imp.)",
  "You (f.) go (on foot) (imp.)",
  "They go (on foot) (imp.)",
  "I go (on foot) (p.)", 
  "You (inf.) go (on foot) (p.)", 
  "He goes (on foot) (p.)",
  "We go (on foot) (p.)",
  "You (f.) go (on foot) (p.)",
  "They go (on foot) (p.)"
  };

  std::string answers[12] = {
  "хожу", 
  "ходишь", 
  "ходит",
  "ходим",
  "ходите",
  "ходят",
  "иду",
  "идёшь",
  "идёт",
  "идём",
  "идёте",
  "идут"
  };

  int lengthOfDeck = sizeof(cards)/sizeof(cards[0]);

  while (true) {
    std::srand(std::time (0));
    int randomPick = rand() % 12;

    std::string userInput;
    std::cout << "Translate " + cards[randomPick];
    std::cout << "\n";
    std::getline(std::cin, userInput);

    if (userInput == answers[randomPick]) {
      std::cout << "Correct!";
      std::cout << "\n";
    }
    else {
      std::cout << "Incorrect, the correct answer was: " + answers[randomPick];
      std::cout << "\n";
    }
  }
  
}