# Puzzle Retreat Solver Instructions

This program will solve the puzzles in the **Puzzle Retreat** app!

Created by Jason Robertson - 7/13/2014

# Drawing the puzzle
1. In a simple text file, use the symbols explained below to draw the puzzle.
2. The board must be a rectangle.
3. Fill in the outside edge using boundary symbols to ensure the board is a rectangle.
4. Some text editors will trim trailing spaces. If you keep getting errors that say it needs to be a rectangle,
   try adding an extra column of boundary markers to eliminate this problem.

```
# = boundary
  = open space
< = left arrow
> = right arrow
^ = up arrow
v = down arrow
t = tree space
1-5 = ice block
f = fire block
. = diamond block
```

Example:

```
--------------
Everest-07.txt
--------------
##33##
#2  2#
.    .
.    2
#3  ^#
##ff##
```

```
--------------
Garden-11.txt
--------------
###3##
#    2
1 2  #
#    3
#  t1#
#31 ##
#   2#
######
```

# Understanding the Answer!
1. The answer will be given back to you in a set of instructions.
2. Follow them in order and you should win the puzzle!
3. Each block will be referred to with rows and columns.
4. Row 1 is the top row of the puzzle that you drew.
5. Column 1 is the furthest left column of the map that you drew up.
6. Hope this makes sense.
7. Good luck, have fun!

PS: If you get an error saying, sorry I couldn't find an answer, then double
check your puzzle!! I'm pretty confident the puzzle solver works. A common
mistake is to place spaces instead of # boundary spaces. Good luck!!
