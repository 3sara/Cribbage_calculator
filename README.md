# Cribbage Hand Scorer

This Java program calculates the score of a Cribbage hand consisting of five card, the last one is the starter card. 
The program can process hands and calculate the total score based on the standard Cribbage rules, 
including points for "fifteen-twos", runs, pairs, and flushes. 


## Cribbage Hand Representation
- Each card is represented by a two-character string:
    - The first character represents the rank.
    - The second character represents the suit.


## Project Structure
The project contains the following Java classes:
- `Card`: Represents a playing card, including rank, suit, and point value. A card can be instantiated with a string containing rank, suite, points and enumeratedRank, or simply specifying rank and suite in a two character string.
- `Hand`: Represents a Cribbage hand and provides methods for sorting and retrieving cards. This class includes two constructors: une to build the hand starting from a list of cards objects, and one to build a hand starting from a string. 
- `Calculator`: Contains the logic for computing the score of a hand using various methods (`fifteenTwos`, `runsPairs`, `flush`).
- `Main`: This class serves as the entry point of the program. It creates instances of 
   Cribbage hands using both string representations and arrays of `Card` objects. 
   It then calculates and displays the scores for these hands using the scoring logic 
   defined in the `Calculator` class. 

## Contributors

- Gaia Alessio ([Gaiiaalessio](https://github.com/Gaiiaalessio))
- Sara Carpenè ([3sara](https://github.com/3sara))
- Stefano Tumino ([Nefasto1](https://github.com/Nefasto1))


  


  
