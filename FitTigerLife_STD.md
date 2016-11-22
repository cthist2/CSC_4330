# Software Testing Document
## for FitTigerLife
### Version 1.0 approved
### Prepared by *Robin Tallitsch, Triston Lamonte, Thomas Chang, Spencer Janin, Charlie Thistlethwaite, and Cort Fitzpatrick*
### *CSC 4330*
### *11/21/2016*

---

## Table of Contents

 * Table of Contents
 * [Revision History](#Revision)

1. [Introduction](#Introduction)
  * 1.1 [Purpose](#purpose)
2.	[Test Cases](#TestCases)
  *   [1.1	Calorie Counter 1](#CalorieCounter1)
  *   [1.2	Calorie Counter 2](#CalorieCounter2)
  * 	[2.1 Weights Tracker 1](#WeightsTracker1)
  * 	[2.2 Weights Tracker 2](#WeightsTracker2)
  * 	[3.1 Edit Goal 1](#EditGoal1)
  * 	[3.2 Edit Goal 2](#EditGoal2)
  * 	[4.1 Profile 1](#Profile1)
  * 	[4.2 Profile 2](#Profile2)
  * 	[4.3 Profile 3](#Profile3)
  * 	[5.1 BMI Calculator 1](#BMICalculator1)
  * 	[5.2 BMI Calculator 2](#BMICalculator2)
  * 	[5.3 BMI Calculator 3](#BMICalculator3)
  * 	[6.1 Cardio Tracker 1](#CardioTracker1)
  * 	[6.2 Cardio Tracker 2](#CardioTracker2)
  * 	[6.3 Cardio Tracker 3](#CardioTracker3)
  * 	[7.1 Timer 1](#Timer1)
  * 	[8.1 Entry Tracker 1](#EntryTracker1)

---

## Revision History <a name="Revision"></a>

| Name | Date | Reason for Change | Version |
| :--- | :--- | :--- | :--- |
| Robin Tallitsch, Triston Lamonte | 11/21/2016 | Initial | 1.0 |

---

# 1. Introduction <a name="Introduction"></a>

### 1.1 Purpose<a name="purpose"></a>
The purpose of this document is to show the testing of the various features in the “FitTigerLife” application. This document mainly entails the test cases and the pass/fails of multiple scenarios the system is put through.

---

# 2. Test Cases <a name="TestCases"></a>

### 1.1 Calorie Counter 1<a name="CalorieCounter1"></a>

Test Case #: 1.1  
System:  FitTigerLife Application  
Designed by:  Spencer Janin  
Executed by:  Spencer Janin  
Short Description:  Validating submission to the Calorie Calculator  
Test Case Name:  Calorie Counter Submission 1  
Subsystem:  Calorie Counter  
Priority:   6    
Design Date:  11/6/16  
Execution Date:  11/16/16  

Pre-conditions  
~The system displays the main menu

| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Click in the designated entry space | a number pad will appear for the user to enter in total calories | P | |
| 2 | Enter ‘2000’ | The system waits for the user to submit this entry | P | |
| 3 | Hit Submit | The system adds the value submitted to the daily total value | P | |
| 4 | Enter ‘3000’ | The system waits for the user to submit this entry | P | |
| 5 | Hit Submit | The system adds the value submitted to the daily total value | P | system correctly adds the numbers to each other|
| 6 | Check Post-condition 1, 2 | | | | |

Post-conditions  
~The daily value stored is updated   
~The new daily value is shown  

---

### 1.2 Calorie Counter 2<a name="CalorieCounter2"></a>

Test Case #:  1.2  
System:  FitTigerLife Application  
Designed by: Spencer Janin   
Executed by: Spencer Janin   
Short Description: Validating empty submission to the Calorie Calculato   
Test Case Name: Calorie Counter 2   
Subsystem:  Calorie Counter    
Priority:  6     
Design Date: 11/6/16   
Execution Date: 11/16/16

Pre-conditions  
~The daily value stored is updated   
~The new daily value is shown  

| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Click in the designated entry space | a number pad will appear for the user to enter in total calories | P | |
| 2 | Hit Submit | The system adds the value submitted to the daily total value | F | Crash |

Post-conditions  
~The daily value stored is updated   
~The new daily value is shown

---



### 2.1 Weights Tracker 1<a name="WeightsTracker1"></a>

Test Case #:  2.1  
System:  FitTigerLife Application  
Designed by:  Thomas Chang  
Executed by:  Charlie Thistlewaite  
Short Description:  Validating submission to Weights Tracker fields  
Test Case Name:  Weights Tracker Submission 1  
Subsystem:  Weights Tracker  
Priority:   7    
Design Date:  10/30/16  
Execution Date: 11/16/16  

Pre-conditions  
~The system displays the main menu  
~Timer functioning  

| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Click in the designated entry space | a number pad will appear for the user to enter data | P| |
| 2 | Enter any number not ‘null’ | The system waits for the user to submit this entry | P | Repeat steps 1 & 2 for each of the three spaces|
| 3 | Hit Submit | The system adds the values submitted to the daily totals | P| |
| 4 | Click Pull Past Records | The system attempts to pull latest 5 entries | P | Issue with Entry Tracker (8.1)|
| 5 | Check Post-condition 1| | | | |


Post-conditions  
~The values stored are updated

---

### 2.2. Weights Tracker 2<a name="WeightsTracker2"></a>

Test Case #:  2.2  
System:  FitTigerLife Application  
Designed by:  Thomas Chang   
Executed by:  Charlie Thistlewaite   
Short Description:  Validating submission to Weights Tracker fields  
Test Case Name:  Weights Tracker 2  
Subsystem:  Weights Tracker   
Priority:   7    
Design Date:  10/30/16   
Execution Date:  11/16/16   

Pre-conditions  
~The values stored are updated

| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Click in the designated entry space | a number pad will appear for the user to enter data | P | Unnecessary for this test as the entry spaces start as ‘null’|
| 2 | Enter ‘null’ | The system waits for the user to submit this entry | P | Repeat steps 1 &  2 for each of the three spaces|
| 3 | Hit Submit | The system adds the values submitted to the daily totals | P| |
| 4 | Click Pull Past Records | The system attempts to pull latest 5 entries | F | Crash|


Post-conditions  
~The system displays the main menu  
~Timer functioning  

---

### 3.1 Edit Goal 1<a name="EditGoal1"></a>

Test Case #:  3.1  
System:  FitTigerLife Application  
Designed by:  Spencer Janin  
Executed by:  Spencer Janin  
Short Description:  Validating submission to Edit Goal fields  
Test Case Name:  Edit Goal 1   
Subsystem:  Edit Goal   
Priority: 1      
Design Date:  11/13/16   
Execution Date: 11/16/16   

Pre-conditions  
~The system displays the main menu  
~Profile needs to have initial data to pull  

| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Click ‘Change Goal Info’ | Brings user to a screen to change their goal information | P | |
| 2 | Click in the designated entry space | a number pad will appear for the user to enter data | P| |
| 3 | Enter any number not ‘null’ | The system waits for the user to submit this entry | P | Repeat steps 2 & 3 for each of the four spaces|
| 4 | Hit Store Data | The system replaces the initial values with ones submitted by user| P| |
| 5 | Go to Home Screen | | | |
| 6 | Go back to Edit Goal| | | |
| 7 | Check Post-condition 1| | | | |


Post-conditions  
~The goal values shown have been updated  

---

### 3.2 Edit Goal 2<a name="EditGoal2"></a>

Test Case #:  3.2  
System:  FitTigerLife Application  
Designed by:  Spencer Janin   
Executed by:  Spencer Janin   
Short Description:  Validating submission to Edit Goal fields  
Test Case Name:  Edit Goal 2   
Subsystem:  Edit Goal   
Priority:  1     
Design Date:  11/13/16   
Execution Date:  11/16/16   

Pre-conditions  
~The system displays the main menu  
~Profile needs to have initial data to pull  

| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Click ‘Change Goal Info’ | Brings user to a screen to change their goal information | P | |
| 2 | Click in the designated entry space | a number pad will appear for the user to enter data | P| |
| 3 | Enter ‘null’ | The system waits for the user to submit this entry | P | Repeat steps 2 & 3 for each of the four spaces|
| 4 | Hit Store Data | The system replaces the initial values with ones submitted by user| P | |
| 5 | Go to Home Screen | | | |
| 6 | Go back to Edit Goal| | | |
| 7 | Check Post-condition 1 | | | System saves the empty data successfully |


Post-conditions  
~The goal values shown have been updated

---

### 4.1 Profile 1<a name="Profile1"></a>

Test Case #:  4.1   
System:  FitTigerLife Application  
Designed by:  Thomas Chang   
Executed by:  Spencer Janin   
Short Description:  Validating submission to Profile fields  
Test Case Name:  Profile 1   
Subsystem:  Profile   
Priority:  9     
Design Date:  11/2/16   
Execution Date:  11/16/16   

Pre-conditions  
~The system displays the main menu  

| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Click in the designated entry space | a number pad will appear for the user to enter data | P| |
| 2 | Enter any number not ‘null’ | The system waits for the user to submit this entry | P | Repeat steps 1 & 2 for each of the three spaces|
| 3 | Select Female | Stores female value | P | System defaults to Male |
| 4 | Click Submit Changes | The system replaces the initial values with ones submitted by user| P| |
| 5 | Check Post-condition 1, 2| | | | |


Post-conditions  
~ The profile values have been updated and saved  
~ Values have been sent to BMI Calculator  

---

### 4.2 Profile 2<a name="Profile2"></a>

Test Case #:  4.2   
System:  FitTigerLife Application  
Designed by:  Thomas Chang   
Executed by:  Spencer Janin   
Short Description:  Validating submission to Profile fields  
Test Case Name:  Profile 2   
Subsystem:  Profile   
Priority:  9     
Design Date:  11/2/16   
Execution Date: 11/16/16   

Pre-conditions  
~The system displays the main menu  

| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Click in the designated entry space | a number pad will appear for the user to enter data | P| |
| 2 | Enter any number not ‘null’ | The system waits for the user to submit this entry | P | Repeat steps 1 & 2 for each of the three spaces|
| 3 | Select Male | Stores male value | P | unnecessary since System defaults to Male |
| 4 | Click Submit Changes | The system replaces the initial values with ones submitted by user| P| |
| 5 | Check Post-condition 1, 2| | | | |


Post-conditions  
~ The profile values have been updated and saved  
~ Values have been sent to BMI Calculator  

---

### 4.3 Profile 3<a name="Profile3"></a>

Test Case #:  4.3   
System:  FitTigerLife Application  
Designed by:  Thomas Chang   
Executed by:  Spencer Janin   
Short Description:  Validating submission to Profile fields  
Test Case Name:  Profile 3   
Subsystem:  Profile   
Priority:  9     
Design Date:  11/2/16   
Execution Date: 11/16/16   

Pre-conditions  
~The system displays the main menu  


| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Click in the designated entry space | a number pad will appear for the user to enter data | P| |
| 2 | Enter ‘null’ | The system waits for the user to submit this entry | P | Repeat steps 1 & 2 for each of the three spaces|
| 3 | Select Male or Female | Stores male or female value | P | System defaults to Male |
| 4 | Click Submit Changes | The system replaces the initial values with ones submitted by user| F | Crash |


Post-conditions  
~ The profile values have been updated and saved  
~ Values have been sent to BMI Calculator   

---

### 5.1 BMI Calculator 1<a name="BMICalculator1"></a>

Test Case #:  5.1   
System:  FitTigerLife Application  
Designed by:  Thomas Chang   
Executed by:  Charlie Thistlewaite   
Short Description:  Validating proper calculations  
Test Case Name:  BMI Calculator 1   
Subsystem:  BMI Calculator   
Priority:      7   
Design Date:  11/2/16   
Execution Date: 11/16/16   

Pre-conditions  
~The system displays the main menu  
~Profile needs to have initial data to pull  


| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Numbers submitted are not ‘null’ | The system takes in information| P | |
| 2 | System Calculation | System runs the algorithm | P | |
| 3 | Check Post|condition 1| | | |


Post-conditions  
~ The result is shown is shown at the bottom of Profile  


---

### 5.2 BMI Calculator 2<a name="BMICalculator2"></a>

Test Case #:  5.2  
System:  FitTigerLife Application  
Designed by:  Thomas Chang  
Executed by:  Charlie Thistlewaite  
Short Description:  Validating proper calculations  
Test Case Name:  BMI Calculator 2  
Subsystem:  BMI Calculator  
Priority:       7  
Design Date:  11/2/16  
Execution Date: 11/16/16  

Pre-conditions  
~The system displays the main menu  
~Profile needs to have initial data to pull   

| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Numbers submitted are ‘null’ | The system takes in information| P | |
| 2 | System Calculation | System runs the algorithm | P | |
| 3 | Check Post-condition 1 | | F | Crash|

Post-conditions  
~ The result is shown is shown at the bottom of Profile  

---

### 5.3 BMI Calculator 3<a name="BMICalculator3"></a>

Test Case #:  5.3  
System:  FitTigerLife Application  
Designed by:  Thomas Chang  
Executed by:  Charlie Thistlewaite  
Short Description:  Validating proper calculations  
Test Case Name:   BMI Calculator 3  
Subsystem:  BMI Calculator  
Priority:       7  
Design Date:  11/2/16  
Execution Date: 11/16/16  

Pre-conditions  
~The system displays the main menu  
~Profile needs to have initial data to pull  


| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Numbers submitted are not ‘null’ and the height is set to ‘0’ | The system takes in information| P  | the algorithm divides by height which is 0 in this case|
| 2 | System Calculation | System runs the algorithm | P | Outputs 0 as an exception to dividing by 0|
| 3 | Check Post-condition 1| | | | |


Post-conditions  
~ The result is shown is shown at the bottom of Profile  

---

### 6.1 Cardio Tracker 1<a name="CardioTracker1"></a>

Test Case #:  6.1  
System:  FitTigerLife Application  
Designed by:  Thomas Chang  
Executed by:   Charlie Thistlewaite  
Short Description:  Validating submission to Cardio Tracker fields  
Test Case Name:  Cardio Tracker 1  
Subsystem:  Cardio Tracker  
Priority:      7   
Design Date:  10/30/16  
Execution Date: 11/16/16  

Pre-conditions  
~The system displays the main menu  

| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Click in the designated entry space | a number pad will appear for the user to enter data | P| |
| 2 | Enter any number not ‘null’ and not a decimal| The system waits for the user to submit this entry | P | |
| 3 | Click Submit | The system stores the values submitted by user| P | |
| 4 | Check Post-condition 1| | | | |


Post-conditions  
~ The data submitted has been saved  

---

### 6.2 Cardio Tracker 2<a name="CardioTracker2"></a>

Test Case #:  6.2  
System:  FitTigerLife Application  
Designed by:   Cardio Tracker  
Executed by:   Thomas Chang  
Short Description:  Validating submission to Cardio Tracker fields  
Test Case Name:  Cardio Tracker 2  
Subsystem:  Cardio Tracker  
Priority:    7   
Design Date:   10/30/16  
Execution Date: 11/16/16   

Pre-conditions  
~The system displays the main menu  

| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Click in the designated entry space | a number pad will appear for the user to enter data | P| |
| 2 | Enter ‘null’| The system waits for the user to submit this entry | P | |
| 3 | Click Submit | The system stores the values submitted by user| P | |
| 4 | Check Post-condition 1 | | | System saves the empty data successfully


Post-conditions  
~ The data submitted has been saved  

---

### 6.3 Cardio Tracker 3<a name="CardioTracker3"></a>

Test Case #:  6.3  
System:  FitTigerLife Application  
Designed by:  Thomas Chang  
Executed by:  Charlie Thistlewaite  
Short Description:  Validating submission to Cardio Tracker fields   
Test Case Name:  Cardio Tracker 3  
Subsystem:  Cardio Tracker  
Priority:    7   
Design Date:  10/30/16  
Execution Date: 11/16/16  

Pre-conditions  
~The system displays the main menu  

| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Click in the designated entry space | a number pad will appear for the user to enter data | P| |
| 2 | Enter any number not ‘null’ and is a decimal| The system waits for the user to submit this entry | P | |
| 3 | Click Submit | The system stores the values submitted by user| P | |
| 4 | Check Post-condition 1 | | | | |


Post-conditions  
~ The data submitted has been saved  

---

### 7.1 Timer 1<a name="Timer1"></a>

Test Case #:  7.1  
System:  FitTigerLife Application  
Designed by:  Spencer Janin  
Executed by:  Charlie Thistlewaite  
Short Description:  Verifying the actions of Timer work  
Test Case Name:  Timer 1  
Subsystem:  Cardio Tracker/Weights Tracker  
Priority:    2   
Design Date:  11/6/16  
Execution Date: 11/16/16  

Pre-conditions  
~The system displays the main menu  
~Access to Cardio Tracker/Weights Tracker  


| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Click Start | The timer starts counting shown by Minutes : Seconds | P | |
| 2 | Wait for 3 seconds | | | |
| 3 | Click Stop | The timer stops at 00:03 | P  | |
| 4 | Click Reset | The timer resets back to 00:00 | P| |
| 5 | Click Reset | The timer stays at 00:00 | P | check to see if resetting at zero works|
| 6 | Click Stop | The timer stays at 00:00 | P | check to see if stop at zero works|
| 7 | Click Start | The timer starts counting shown by Minutes : Seconds | P | |
| 8 | Wait for 3 seconds | | | |
| 9 | Click Reset | The timer is at 00:03 and continues to count up | P | Check to see if resetting during count-up does not affect it|
| 10 | Check Post-condition 1 | | | Weights Tracker does not save the timer’s value


Post-conditions  
~ The data shown is saved when Cardio Tracker is submitted  

---

### 8.1  Entry Tracker 1<a name="EntryTracker1"></a>

Test Case #:  8.1  
System:  FitTigerLife Application  
Designed by:  Thomas Chang  
Executed by:  Spencer Janin  
Short Description:  Verifying correct saving and showing of data  
Test Case Name:  Entry Tracker  1
Subsystem:  Entry Tracker  
Priority:     8  
Design Date:  11/13/16  
Execution Date:11/16/16  

Pre-conditions  
~The system displays the main menu  
~ Values from either Cardio Tracker   Weights Tracker   or Calorie Counter have been saved  

| Step | Action | Expected System Response | Pass/Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 2 | Click Pull Past Records in Weights Tracker | System pulls latest 5 entries | P  | |
| 1 | Check Post-condition 1  | | | |
| 2 | Check Post-condition 2 | F | Entries shown are first 5, not most recent 5 | | |

Post-conditions  
~ The data has been properly saved
~ Shows data from the 5 most recent entries

---
