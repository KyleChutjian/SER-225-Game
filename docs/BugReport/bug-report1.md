# Updated Bug Report

## Bug #1 - Key Overrides
We continuously forgot this was a bug, and has been there since the very start.
For more information, check the last bug in: bug-report.md

## Bug #2 - Item Block Audio & Enemies
After hitting the Item Block and spamming the pause button, the audio gets delayed and sometimes happens again when restarting the level.
Additionally, some enemy indexes in the Item Blocks need to be fixed. 
We forgot to change this after adding new enemies, which changed the StillDinosaur indexes to change.

## Bug #3 - Volume Mixer
The volume mixer itself works fine, but change what values each percent has.
25%, 50%, and 75% volume should be updated. 
Also, when changing the sound effect settings, it updates late. 
For example: when switching from 25% to 50%, it will play the 25% audio. 
We fixed this for the music part, but forgot to fix for the sound effects.

## Bug #4 - Character Shop
We did not get the chance to finish the Character Shop, but we got the rough outline of it finished. 

## Bug $5 - Random Crashing Bug
We have no clue what causes this bug, but we believe it involves some of the enemies and the camera class. 
If we were to guess, the code we were given was not developed to involve vertical levels or too many enemies.
You will accidentally find this bug while messing around with the program.