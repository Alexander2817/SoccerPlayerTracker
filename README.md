# Soccer Player Tracker

This is a Java-based command-line application that allows coaches, analysts, and fans
to track soccer players and their match performances.

---

## Features

- Adding and removing players
- Logging match statistics
- Viewing player Statistics
- Generating performance rankings based on:
   - goals
   - assists
   - minutes played
   - matches played
   - yellow cards
   - red cards


## Compilation

To compile, open a terminal in the project folder and run:

```bash
javac *.java
```
## Running

After compiling, you will run the program with:

```bash
java Main
```

Follow the prompts to enter your name, email, and role (coach / analyst / fan).

## Testing

1. Launch the app using `java Main`.
2. Enter your credentials (name, email, role).
3. Choose your role (Recommend you use `coach` for full access).
4. From the menu:
   - View stats of the preloaded player
   - Add a new player to test data entry
   - Log a performance for a player
   - Generate rankings (you’ll be prompted for a ranking type)

## About "tracker.dat"

- This file stores player and performance data.
- It will automatically be updated when you add/remove players or log performances.
- It will save once you close the program(entering 0)
- To not start with any data, you can delete `tracker.dat` and run the app again.


