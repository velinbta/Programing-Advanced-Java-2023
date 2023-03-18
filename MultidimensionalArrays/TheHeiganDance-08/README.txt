8. The Heigan Dance
At last, level 80. And what do level eighties do? Go raiding. This is where you are now - trying not to be wiped by the famous dance boss, Heigan the Unclean. The fight is pretty straightforward - dance around the Plague Clouds and Eruptions, and you'll be just fine.
Heigan's chamber is a 15-by-15 two-dimensional array. The player always starts at the exact center. For each turn, Heigan uses a spell that hits a certain cell and the neighboring rows/columns. For example, if he hits (1,1), he also hits (0,0, 0,1, 0,2, 1,0 .... 2,2). If the player's current position is within the area of damage, the player tries to move. First, he tries to move up. If there's damage/wall, he tries to move right, down, and left. If he cannot move in any direction because the cell is damaged or there is a wall, the player stays in place and takes the damage.
Cloud does 3500 damage when it hits, and 3500 damage the next turn. Then it expires. Eruption does 6000 damage when it hits. If a spell hits a player that also has an active Cloud from the previous turn, the cloud damage is applied first. Both Heigan and the player may die in the same turn. If Heigan is dead, the spell he would have cast is ignored.
The player always starts at 18500 hit points; Heigan starts at 3,000,000 hit points. Each turn, the player does damage to Heigan. The fight is over either when the player is killed, or Heigan is defeated.

Input
On the first line, you receive a floating-point number D - the damage done to Heigan each turn.
On the next several lines - you receive input in format "{spell} {row} {col} - {spell}" is either Cloud or Eruption.

Output
 On the first line  
If Heigan is defeated: "Heigan: Defeated!"
Else: "Heigan: {remaining}", where remaining is rounded to two digits after the decimal separator.
On the second line:
If the player is killed: "Player: Killed by {spell}".
Else "Player: {remaining}".
On the third line: "Final position: {row, col}" -> the last coordinates of the player.

Constraints
D is a floating-point number in the range [0 ... 500000].
A damaging spell will always affect at least one cell.
Allowed memory: 250ms/16MB.

Examples:

Input 1:
10000
Cloud 7 7
Eruption 6 7
Eruption 8 7
Eruption 8 7

Output 1:
Heigan: 2960000.00
Player: Killed by Eruption
Final position: 8, 7

Input 2:
500000
Cloud 7 6
Eruption 7 8
Eruption 7 7
Cloud 7 8
Eruption 7 9
Eruption 6 14
Eruption 7 11

Output 2:
Heigan: Defeated!
Player: 12500
Final position: 7, 11

Input 3:
12500.66
Cloud 7 7
Cloud 7 7
Cloud 7 7
Cloud 7 7

Output 3:
Heigan: 2949997.36
Player: Killed by Plague Cloud
Final position: 7, 7