#FOSSEE Summer Internship
#Project: Xcos on Browser
#PartA: Xcos on Desktop

#Problems:
1. Create a Java Swing application which will open a frame. Place a label, Changing Properties, in
the center. When a user right clicks on label, a menu (list) should open with three options. One
of them should be Properties. When user clicks on Properties, a new window/pop up should
open up with fields such as Change Text, Change Background color and Change Font Color.
User will enter values for the same. Upon clicking on Submit button, all changes should reflect
on label Changing Properties.

2. Use Java to implement a Student Ranking System (the code must handle each of the
mentioned conditions for ranking)
Enter Student details: Roll number, Name, Language 1, Language 2, Math, Science, Environmental
Science (for minimum 5 students)
a. Generate the rank for list of students in a class based on total marks.
b. If 2 or more students have the same total then prioritize rank based on highest mark with the
order of subjects being Math, Science, ES, Language 1 and Language 2
c. If you are unable to filter based on criterion b, then provide rank based on ascending order of
Name
d. Use Object Oriented principles to develop the same




#Solutions:

Compile each of the files using Java-compiler and execute.

1. 
File Name: ChangingProperties.java
Input: There is no input from the user initially.
	Working: 
	1. User has to RIGHT-CLICK the label "Changing Properties" to get the pop-up menu.
	2. The PopupMenu has three items (Dummy1, Dummy2 and Properties).
	3. The first two menu items, simply create a Message Dialog to display a message.
	4. The properties item, when clicked, will open a Dialog.
	5. The dialog has three fields
	   i) Change Text : 
	   		A new text can be specified here to be displayed on the label.
	  ii) Change Foreground Color
	  		#This option takes 3 input INTEGER values (between 0-255), corresponding to red, green and 
	  		 blue components of the color.
	  		#Corresponding color will be the text color of the label.
	 iii) Change Background Color 
	 		#This option takes 3 input INTEGER values (between 0-255), corresponding to red, green and 
	  		 blue components of the color.
			#Corresponding color will be the background color of the label.


2.
File Name: StudentRanking.java
NOTE:
The application is interactive with the user. There should not be any problem with the usage. In case
of any difficulties, the input and output details are specified below.

	Input:
	1. The number of students that are to be ranked.
	2. For each student, enter the Name, Roll Number and 
	   marks (Maths, Science, Environmental Science, Language1, Language2),strictly in specified order.

	Output:
	The ranking of each student with the corresponding details.


