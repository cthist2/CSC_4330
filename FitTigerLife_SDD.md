# Software Design Document
## for FitTigerLife
### Version 1.0 approved
### Prepared by *Robin Tallitsch, Triston Lamonte, Thomas Chang, Spencer Janin, Charlie Thistlethwaite, and Cort Fitzpatrick*
### *CSC 4330*
### *11/2/2016*

---

## Table of Contents

 * Table of Contents
 * [Revision History](#Revision)

1. [Introduction](#Introduction)
  * 1.1 [Purpose](#purpose)
  * 1.2 [Intended Audience](#intended-audience)
  * 1.3 [Scope](#scope)
2.	[System Architecture](#System-Arch)
  * 2.1	[Main Architecture](#Main)
  * 2.2	[Sub-System Architecture](#Sub)
        - 2.2.1 [Profile](#profile)
        - 2.2.2 [Cardio Tracker](#Cardio)
        - 2.2.3 [Weights Tracker](#Weights)
        - 2.2.4 [Entry Tracker](#Entry)
        - 2.2.5 [Calorie Calculator](#Calorie)
        - 2.2.6 [Data Graphing](#Graphing)
        - 2.2.7 [Timer](#Timer)
        - 2.2.8 [BMI Calculator](#BMI)
3. [Application Views](#Views)
  * 3.1	[Development View](#Development)
  * 3.2	[Physical View](#Physical)
  * 3.3	[Database View](#Database)
  * 3.4	[Work-Assignment View](#Work-assignment)
4. [Element Catalog](#Element-Catalog)
5. [User Interfaces](#UI)
  * 5.1	[User Interface Description](#UI-Description)
  * 5.2	[User Interfaces Diagram](#UI-Diagram)

---

## Revision History <a name="Revision"></a>

| Name | Date | Reason for Change | Version |
| :--- | :--- | :--- | :--- |
| Robin Tallitsch, Triston Lamonte | 10/31/2016 | Initial | 1.0 |

---

# 1. Introduction <a name="Introduction"></a>

### 1.1 Purpose<a name="purpose"></a>
The purpose of the Software Design Document is to describe the implementation of the Fit Tiger Life application sufficiently to allow software development to proceed with a common understanding of how the application should be built.

### 1.2 Intended Audience<a name="intended-audience"></a>
The primary audience for the Software Design Document are members of the Software development team.

### 1.3 Scope<a name="scope"></a>
Fit Tiger Life is a small and efficient exercise and diet application intended for android users who are looking for an application to help track their fitness progress similar to Couch to 5K and Google Fit. This application will be more focused on being efficient and easily accessible, whereas the other two you needed subscriptions or logins, this application will not. Much like other fitness applications, there will be common tools like a Calorie Calculator, and a Cardio Exercise Tracker that the intended user will be looking for in a fitness application.

---

# 2. System Architecture<a name="System-Arch"></a>

### 2.1 Main Architecture<a name="Main"></a>

### 2.2 Sub-System Architecture<a name="Sub"></a>

###### 2.2.1 Profile<a name="Profile"></a>
The system accepts a positive integer for the user’s age, a boolean to represent the user’s gender, and two positive doubles for the user’s height and weight. If there is missing information, the submission process will pull the previously stored values in the profile database file as input.  If the user inputs invalid data, then the system will alert the user to use only positive numbers. When valid data in submitted to the system, the system will write to the profile database file and store the age, height, weight, and gender the user submitted, this will override the previous information stored in the profile.
Rationale: The information stored by this system is necessary for several other systems in the application to function, but all the information is subject to change so we need to provide the user with the ability to override the previous information. We also do not want to burden our users by inputting all their information every time they want to update select items, so fields left blank by the user should retain the previously stored information.

###### 2.2.2 Cardio Tracker<a name="Cardio"></a>
The cardio tracker accepts time in the form hh:mm:ss as input along with distance in the form of a double, it also pulls the user’s weight from the profile. It is expected that time will be inputted from the timer, but the user may also manually input the time. Those three inputs are used to run the calories burned formula, and the calories calculated from that formula are subtracted from the net calories.
Rationale: The application requires a method to subtract the calories the user has burned in addition to adding the calories consumed. To this end the cardio Tracker allows the user to easily calculate the calories they have burned with just the time they have jogged and the distance they have traveled.


###### 2.2.3 Weights Tracker<a name="Weights"></a>


###### 2.2.4 Entry Tracker<a name="Entry"></a>

###### 2.2.5 Calorie Calculator<a name="Calorie"></a>
This system accepts a positive integer as input from the user. Should the user input invalid data the system will alert them to use only positive whole numbers. When the system receives valid data, it will add the input to the net calories value stored in the calories file. After that the system will update the net calories displayed to the user.
Rationale: In order for the user to track their calories, the application required a method for the user to store the calories they have consumed and that value has to be stored so that it can be called even after the application has been closed. For that reason adding the imputed value to a value stored in a file appeared to be the most efficient way to achieve that goal.

###### 2.2.6 Data Graphing<a name="Graphing"></a>

###### 2.2.7 Timer<a name="Timer"></a>
Will be used in pair with the Cardio Tracker and Weights Tracker where the time will be shown in seconds, minutes, and hours. The Weights Tracker will utilize the timer as a countdown timer. When a countdown timer has been initialized, the inputted time will be converted into number of seconds and a loop will decrement the value by 1 until it reaches 0 seconds where this should also trigger a function to cue an auditory noise from the device. The Timer will not be allowed to receive a new initialization value until the exercise option has changed.
The Cardio tracker will utilize the timer as a count-up timer. When a count-up timer has been initialized it will start a loop at integer value 0 and increment the value by 1 per second until stopped by the user. The original time will be converted into seconds saved as an integer value, then it will be sent to Entry Tracker*.


###### 2.2.8 BMI Calculator<a name="BMI"></a>
Pulls the double values for weight and height, runs the BMI equation of [703(weight/(height*height))] and outputs the result to the screen.
Rationale: Body Mass Index (BMI) was deemed necessary because users would deem it necessary from a fitness application. It was also made to be as unobtrusive as possible in the application since it is a simple formula. To make it more unobtrusive, the calculator does not store any data, rather just reads and outputs.


---

# 3. External Interface Requirements<a name="external-interface-requirements"></a>

### 3.1 Development View<a name="Development"></a>
Fit Tiger Life will be developed using Android Studio 2.0, and coded in java.

### 3.2 Physical View<a name="Physical"></a>
The only hardware the Fit Tiger Life shall interact with is the user’s android phone. Besides running off the hardware the application will read and write to the phone’s local memory which may or maynot be a separate storage item.

### 3.3 Database View<a name="Database"></a>
Fit Tiger Life does not rely on a server side database, all required information is stored locally to the user’s phone. The database directory contains the following files: a file to store information written by the profile system, a file to store the current calorie total for a day, a file that stores a list of exercise and the relevant information pertaining to each exercise to be read by exercise tracker, and a log of all the changes to the previously mentioned files.
<img src="./doc/pics/DatabaseDiagram.png" width="400" height="260" />

### 3.4 Work-Assignment<a name="Work"></a>



---

# 4. Element Catalog<a name="Element"></a>





---

# 5. User Interfaces<a name="UI"></a>

### 5.1 User Interface Description<a name="UI-Description"></a>
* Home page: The main directory for the user to navigate the application. It contains six buttons labeled Profile, Calorie Calculator, Cardio Tracker, Weights Training, BMI  Calculator, and History each of which links to their respective functions.
* Profile: Contains data fields for the user to record their weight in pounds, height in inches, and age in years and labeled appropriately, along with two buttons, one labeled male and the other label female, and a submit button to record the input.
* Calorie Calculator: This page contains a single data field labeled “Add Calories”, a button under that field that adds the inputted number to calories total, and a box containing the net calorie gain for the day labeled “Today’s Net Calories”.
* Cardio Tracker: This page contains a timer with a stop/start button, a field labeled time and another field labeled distance, and a button labeled submit that subtracts calories from the calorie file after running the appropriate calculations.
* Weights Tracker: This page contains a dropdown menu that lists weight training exercises, selecting any of the exercises shall bring up instructions on how to properly execute that exercise and a timer, and three fields allow the user to input the number of reps, weight, and number of sets.
* BMI Calculator: This page contains a box displaying the BMI labeled Your BMI.
* History: This page contains a line graph generated based on calories over time and a button that bring up the data from entry tracking organized by date and time.


### 5.2 User Interfaces Diagram<a name="UI-Diagram"></a>
<img src="./doc/pics/uiDiagram.png" width="800" height="1000" />

---
