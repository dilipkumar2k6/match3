match3
======

Match3 Program to match 3 or more number blocks and print it. This program is based on command line. Following are multiple ways to run this program. Followin are more details.

Using Eclipse: <br\>
1. Load complete project in eclipe as existing project.<br\>
2. Run Run.java class file.<br\>

Using Command line:<br\>
1. Open command line<br\>
2. Change directory to match3/bin<br\>
3. Run folloing command <br\>
java   match3.Run 5 5 3 <br\>

This program perform following <br\>
1. Create Grid as per given height and width<br\>
2. Populate grid data as per given number of block types<br\>
3. Apply algorithm to find out match for same blocks (same number) <br\>
4. Print original grid<br\>
5. Print Matches in (x,y) co-ordinate format. Please note; this (x,y) is not position in 2D array. In case you want to use it as 2D array position then use rever i.e. (y,x)<br\>
6. Print result grid with matched block marked as X<br\>

Algorithm Used
======
1. Loop each block in 2D Array
2. For each block; first look for match horizontally; if match is not found horizontally then look for vertically as match find process #3
3. Same match find process is used for both horizontal and vertical tracing
4. In match find process; following are steps<br\>
    a. check if current block is already selected or not<br\>
    b. If current block is not already processed then find next two more block and see if it can create minimum 3 match;<br\>
    c. If does then add these three blocks as match <br\>
    d. Loop for remaining blocks and see if new blocks can be added in this match or not.<br\>
5. If current block is already selected for match then don't do anything
6. If next block (step 4#b and 4#d) is already processed then look for following<br\>
    a. Check if this block used in other match is located at end or at middel<br\>
    b. If located at end then remove this match from previous match and add into current match<br\>
    c. If located at the middle of previous match then need to check the size of current match and previous match and based on that split previous match and use this block for current match.<br\>

Note: 6#c is not implemented.<br\>


Open Bugs
======
This program has some known bugs. Following are more details on known bugs. <br/>
1. Program is not tested when grid is having same blocs in diagonal format. i,e, in following format <br/>
--  --  --  --  2  --  --  --  --  
--  --  --  --  2  --  --  --  --  
--  --  --  --  2  --  --  --  --  
2   2   2   2   2  2   2   2   2  
--  --  --  --  2  --  --  --  --  
--  --  --  --  2  --  --  --  --  
--  --  --  --  2  --  --  --  --  
--  --  --  --  2  --  --  --  --  
--  --  --  --  2  --  --  --  --  
