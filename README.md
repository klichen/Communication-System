# Communication-System
CSC207 Final Project: Communication System for Conference-type Events

-----READ ALL BEFORE STARTING-----

*IMPORTANT* ONE MUST LOGOUT EACH TIME AFTER THEY USE THE PROGRAM AND
NEVER PRESS THE STOP 'MAIN' BUTTON. This ensures the files are saved
correctly each time one logs in and out of an account.

-----CLONING REPO-----
IMPORTANT - The user must first clone our repository (make sure the link ends with
.../group_0047) and in the folder there should be a "phase1" folder
followed by our "src" folder. This means the main project folder is "group_0047".
This is just to ensure the filepath is read correctly by our methods.

In case when you cloned our repository and the project folder is "phase1"
instead of "group_0047", meaning that the top left most folder on the project pane
reads "phase1" instead of "group_0047", then in the ControllerLayer.LoadAndSaveObjects.java class
you would have to change the file path for BOTH methods to
"src/allObjects.txt" from "phase1/src/allObjects.txt" for the program to function.

-----RUNNING THE PROGRAM-----
To run our program, the user must run our Main method. A prompt will
appear asking for a username followed by the password. All pre-made
logins and events are in "data.txt".

Inside "data.txt" there will be two categories, namely, Events and
Logins. These pre-made events and logins  will be active upon
running the Main method.

For "Events", the order in which the data is laid out is:
    Room Number,Entities.Event ID,Time,Entities.Speaker Username,Entities.Speaker Password
    Ex. 1,Entities.Event 1,9,speaker1,password

For "Logins", the order in which the data is laid out is:
    Entities.Person Type,Username,Password
    Ex. attendee,Jack,password

To login, the user must type in one of the pre-made logins
in "data.txt".

-----AFTER LOGGING ON-----
A list of options will appear for the user depending on which
type of person one logs in as. To chose an option, the user must
enter the corresponding keyboard input (a number). Depending on
which option the user chooses, there will be prompts for the user.

(IN CASE YOU FORGET)*IMPORTANT* ONE MUST LOGOUT (An option
every user has) EACH TIME AFTER THEY USE THE PROGRAM AND NOT
PRESS THE STOP 'MAIN' BUTTON. This ensures the files are
saved correctly each time one logs in and out of an account.

Once the user logs out, the program will end (saves all data to
allObjects.txt) and one must run the Main method again to load
the data log in. The user must NOT change anything in allObjects.txt.
