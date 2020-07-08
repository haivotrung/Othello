# Othello

Othello is a board game that looks similar to Go, but has simpler rules and strategy.

Quick Overview
•	The board is 8x8
•	Pieces are placed within squares.  The pieces are white on one side, and black on the other.
•	There are two players.  One places pieces down with the white side up, the other with the black side up.
•	When a player places a piece, any pieces of the opponent’s color that are in a straight line between the piece being played and another piece of the same color, are flipped to that color.
•	When it is a player’s turn, they must place a piece such that at least one of their opponent’s pieces is flipped.  If this is not possible, the player must pass.  If a player can play, they may not pass.
•	The game ends when either the entire board is full of pieces, or both players pass consecutively.
•	The winner is the player who has the most pieces of their color at the end of the game.

A fuller treatment can be found at: https://en.wikipedia.org/wiki/Reversi. This program will use the standard Othello opening state, not the Reversi variant.

Move Notation

The program accept moves in <letter><number> format, with the letters and numbers as illustrated on the above board.  No space required between the letter and number, but spaces should be accepted here.  The program must be tolerant of moves not in this format and simply re-prompt for input, not crash.

Display

The board display with the coordinates, as shown.  White disks must display as “W”, black disks as “B”, and blank spaces as “.”.

The program, after printing out a board, display the move that put the board in that state, and then whose move it is.

For example:
D8
White to move


Undo

The program accept “U” as input, and undo the last move.  This includes changing which player’s turn it is, if required.  It need only do this once.  It must not allow an undo as the first move, but must not crash if this happens – it should simply re-prompt.

