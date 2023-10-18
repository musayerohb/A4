Eva's Reflection:
    Something we didn't consider doing at first was having the solve method check not just the squares immediately
    next to the square's current location, but also the squares next to those. Once we realized that this allowed
    the method to more accurately see the correct path and detect dead ends, a lot of our confusion over the apparent
    bugs in the maze's navigation cleared up. We're still struggling with understanding how the path could label
    itself without first labeling the starting point, since our program always does this when marking the path after
    first running through the path that brings it to the finish point. I want to have more opportunities to practice
    recursion and the different ways it can be applied, particularly in real-life scenarios because I feel those would
    be easier to understand.

Musa's Reflection:
    What's working well right now is thinking of how to do operations in a way that's easier for the computer to comprehend. This especially 
    came in handy when trying to do Phase 1, where we read the file, but instead of having the computer find the height and width of that 
    file directly, it would find it from a list containing the contents of the File, as each line of the file is stored as a row. When we 
    were stuck on the recursive methods, other people helped us understand that instead of checking if the 2d array's contents were walls 
    or visited already, we could check if it's neighboring blocks were open spaces instead, and use neighboring blocks to backtrack to where 
    the currentLocation last had another un-visited space to go to. Overall, learning how to think outside the box was helpful 
    to learning the recursive part of the assignment.

    We still struggled on trying to do the simplification of the method, and how to correctly label the path from the finishPoint to the startPoint.
    I'm especially looking to learn more about how to simplify my methods in future assignments. 

Consulted with Angelica, Hala, and Chloe on Phase Two. Consulted with Angelica particularly on getting the path to label itself after completely navigating the maze. 