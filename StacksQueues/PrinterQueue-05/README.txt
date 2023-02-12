5. Printer Queue
The printer queue is a simple way to control the order of files sent to a printer device. We know that a single printer can be shared between multiple devices. So to preserve the order of the files sent, we can use a queue. 

Write a program which takes filenames until the "print" command is received. Then as output, print the filenames in the order of printing. Some tasks may be canceled. If you receive "cancel" you have to remove the first file to be printed. If there is no current file to be printed, print "Printer is on standby".

Examples:

Input 1:
Lab.docx
cancel
cancel
Presentation.pptx
NoteNothing.txt
SomeCode.java
cancel
print

Output 1:
Canceled Lab.docx
Printer is on standby
Canceled Presentation.pptx
NoteNothing.txt
SomeCode.java

Input 2:
Presentation.pptx
cancel
Text.txt
cancel
cancel
cancel
print

Output 2:
Canceled Presentation.pptx
Canceled Text.txt
Printer is on standby
Printer is on standby