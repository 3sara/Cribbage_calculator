# Cribbage Hand Scorer

This Java program calculates the score of a Cribbage hand consisting of five card, the last one is the starter card. 
The program can process hands and calculate the total score based on the standard Cribbage rules, 
including points for combinations totaling 15, runs, pairs, and flushes. 


## Cribbage Hand Representation
- Each card is represented by a two-character string:
    - The first character represents the rank:
    - The second character represents the suit:


## Project Structure
The project contains the following Java classes:
- `Card`: Represents a playing card, including rank, suit, and point value.
- `Hand`: Represents a Cribbage hand and provides methods for sorting and retrieving cards.
- `Calculator`: Contains the logic for computing the score of a hand using various methods (`fifteenTwos`, `runsPairs`, `flush`).
- `Main`: This class serves as the entry point of the program. It creates instances of 
   Cribbage hands using both string representations and arrays of `Card` objects. 
   It then calculates and displays the scores for these hands using the scoring logic 
   defined in the `Calculator` class. 

## Contributors

- Sara Carpenè ([3sara](https://github.com/3sara))
- Stefano Tumino ([Nefasto1](https://github.com/Nefasto1))
- Gaia Alessio ([Gaiiaalessio](https://github.com/Gaiiaalessio))

  


  
