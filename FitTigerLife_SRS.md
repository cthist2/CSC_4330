ASSIGNMENT 2: SRS DOCUMENT
* Use the standard IEEE template format
* All team members should participate in
preparing the document
* Assignment 2 is due Friday, October 21st, 2016
at 11:55 pm.

# Software Requirements Specification
## for FitTigerLife
### Version 1.0 approved
### Prepared by *Robin Tallitsch, Triston Lamonte, Thomas Chang, Spencer Janin, Charlie Thistlethwaite, and Cort Fitzpatrick*
### *organization*
### *date created*

---

## 1. Table of Contents
 Table of Contents
 Revision History
1. [Introduction](#Introduction)
  * 1.1 [Purpose](#purpose)
  * 1.2 [Document Conventions](#document-conventions)
  * 1.3 [Intended Audience and Reading Suggestions](#intended-audience-and-reading-suggestions)
  * 1.4 [Product Scope](#product-scope)
  * 1.5 [References](#references)
2.	[Overall Description](#overall-description)
  * 2.1	[Product Perspective](#product-perspective)
  * 2.2	[Product Functions](#product-functions)
  * 2.3	[User Classes and Characteristics](#product-perspective)
  * 2.4	[Operating Environment](#operating-environment)
  * 2.5	[Design and Implementation Constraints](#design-and-implementation-constraints)
  * 2.6	[User Documentation](#user-documentation)
  * 2.7	[Assumptions and Dependencies](#assumptions-and-dependencies)
3. [External Interface Requirements](#external-interface-requirements)
  * 3.1	[User Interfaces](#user-interfaces)
  * 3.2	[Hardware Interfaces](#hardware-interfaces)
  * 3.3	[Software Interfaces](#software-interfaces)
  * 3.4	[Communications Interfaces](#communications-interfaces)
4. [System Features](#system-features)
  * 4.1	[System Feature 1](#system-feature-1)
  * 4.2	[System Feature 2](#system-feature-2)
5. [Other Nonfunctional Requirements](#other-nonfunctional-requirements)
  * 5.1	[Performance Requirements](#performance-requirements)
  * 5.2	[Safety Requirements](#safety-requirements)
  * 5.3	[Security Requirements](#security-requirements)
  * 5.4	[Software Quality Attributes](#software-quality-attributes)
  * 5.5	[Business Rules](#business-rules)
6. [Other Requirements](#other-requirements)
7. [Appendix](#appendix)
  * 7.1 [Glossary](#glossary)
  * 7.2 [Analysis Models](#analysis-models)
  * 7.3 [To Be Determined List](#to-be-determined-list)

---

## Revision History

| Name | Date | Reason for Change | Version |
| :--- | :--- | :--- | :--- |
| someone | 10/20/2016 | because reasons | 0.0 |

---

## 1. Introduction <a name="Introduction"></a>

#### 1.1 Purpose<a name="purpose"></a>
The purpose of this document is to list and give detailed descriptions of the various requirements necessary for the “Fit Tiger Life” application. This document will also entail the development of the system as well as interface, system constraints, and interactions. This document covers the initial prototype of the application with no current revisions nor releases.

#### 1.2 Document Conventions<a name="document-conventions"></a>
The documentation for this application follows IEEE Standard 830-1993 as a standard. Every requirement stated is to have it’s own priority as listed by the requirement itself. Any non-functional requirements will not list their priority, but instead inherit priority of the requirement it references to a lesser degree of the requirement.

#### 1.3 Intended Audience and Reading Suggestions<a name="intended-audience-and-reading-suggestions"></a>
This SRS document is written to be used by developers and testers working on this project. The intended audience of this document should be familiar with Android interfaces and other Android applications so that the information from this SRS document is familiar to the reader. Any marketing staff should also be familiar with the requirements and specifications of the Google App Store that this application will be distributed on.
Reader is Suggested to read Sections 1 and 2 prior to any other sections as those sections will help the reader understand any document conventions and help understand the product’s goals before getting into the functionality of the application. testers should pay attention primarily to Section 4 when testing functionality, and use Sections 2 and 5 for judging if the current version is in line with the overall goal.

#### 1.4 Product Scope<a name="product-scope"></a>
Fit Tiger Life is a small and efficient exercise and diet application intended for android users who are looking for an application to help track their fitness progress similar to Couch to 5K and Google Fit. This application will be more focused on being efficient and easily accessible, whereas the other two you needed subscriptions or logins, this application will not. Much like other fitness applications, there will be common tools like a Calorie Calculator, and a Cardio Exercise Tracker that the intended user will be looking for in a fitness application.

#### 1.5 References<a name="references"></a>
http://www.ibm.com/developerworks/rational/library/content/legacy/parttwo/1000/0670/0670_Schneider_Ch07.pdf Documenting Use Cases/ Schneider/ ver 1.0/ August 17th 2010/ IBM DevWorks

---

## 2. Overall Description<a name="overall-description"></a>

#### 2.1 Product Perspective<a name="product-perspective"></a>
This application is building on the market made by Google Fit, FitBits, C25K, and other various fitness tools that have come about due to the self fitness boom over the past decade. The application itself is to be self contained unlike many other applications that are parts of bigger organizations. This application will help users who want an application quickly at their fingertips to where the user not have to sign up or sign in just to get the features the user wants.
#### 2.2 Product Function<a name="product-functions"></a>

#### 2.3 User Classes and Characteristics<a name="product-perspective"></a>
This application should only affect one overarching User Class of an Android User who will want a fitness app. Characteristics of the User class are that the user has experience with other applications based in the Android Operating System, will be looking for an easy accessible application dedicated to self fitness, and will be using the app on a daily or a near daily basis.
#### 2.4 Operating Environment<a name="operating-environment"></a>
The operating environment for this application will be on Android mobile phones 7.0 and up where the application will be self-contained with no networking. Any input of data will come from the user. The application must be able to coexist with other applications.
#### 2.5 Design and Implementation Constraints<a name="design-and-implementation-constraints"></a>
The most important constraint on the developing aspect is that the application will not have any networking or database implementation where any storage will be local. Local memory shall not exceed 500 Mb of total memory storage, otherwise there should be minimal memory requirements. The early version of this application will only be in English and moving to more languages is not in consideration at this moment. For implementing this application, it has to not interfere with other applications to where it runs in parallel with other applications.
#### 2.6 User Documentation<a name="user-documentation"></a>
A key aspect of Fit Tiger Life is to be easily accessible so that all  User Interface should be easily recognizable and quickly understood specifically by Android users. Fit Tiger Life will stick to common conventions of [Android UI](https://developer.android.com/guide/topics/ui/index.html).
#### 2.7 Assumptions and Dependencies<a name="assumptions-and-dependencies"></a>
Fit Tiger Life will have to save data locally so there is an assumption that there will be enough space on the device for this data. There is also an assumption that this application will qualify to be on the Google App Store.

---

## 3. External Interface Requirements<a name="external-interface-requirements"></a>

#### 3.1 User Interfaces<a name="user-interfaces"></a>
The first time the user opens the application, the user will be brought to the home screen and prompted to make a personal profile, provided they know the know the info being asked for in age, height, gender, and weight. Afterwards the user goes on and uses the application to their needs. If the user wishes to change the personal info at any time, they can by going to Profile (FR.1).
The main Page will have access to all parts of the application, and all parts of the application will have access to a Home button to where they can easily traverse all parts. The pathways between activities will be done primarily through the use of buttons for the user to tap and be brought to their destination. As of now there are no animations for any button presses.
For Users to insert their data, most spaces for them to do so are going to be empty fields to either input a number or a string of characters. When selecting from a certain set of answers, as in type of workout, there shall be primarily drop down boxes.

#### 3.2 Hardware Interfaces<a name="hardware-interfaces"></a>
The main hardware interface the app has to deal with is the screen size of the device. The minimum screen size the app will be developed for is 2.8 inches diagonal with an aspect ratio between 1.333 (4:3) and 1.779 (16:9). The application has one main interaction with the local storage of data on the device. Other hardware connections that happens within the application will be primarily taken care of by the underlying Operating System of the mobile phone.
#### 3.3 Software Interfaces<a name="software-interfaces"></a>
Essential interaction between this app and other software and tools on the device is limited to the native clock and date. The application will be compatible with Android OS 7.0 and up, so any software native to Android 7.0 installation should be compatible with Fit Tiger Life.
#### 3.4 Communications Interfaces<a name="communications-interfaces"></a>
To prevent the application from having slow down issues, all functions on the application local to the user’s mobile device. The only data transfers that occur will be between the application and the hard drive of the device which will transfer data via Secure Shell transfers. The file formats for these data transfers are TBD with XML, ASCII, and HTML in consideration.

---

## 4. System Features<a name="system-features"></a>

#### 4.1 System Feature 1<a name="system-feature-1"></a>

| **Item** | **FR-1: Record Exercise** |
| :------- | :------------------------|
| **Summary** | something here |
| **Rational** | something here |
| **Requirements** | something here |
| **References** | something here |

![this appears if the image doesn't load](https://cnet4.cbsistatic.com/hub/i/2011/10/27/a66dfbb7-fdc7-11e2-8c7c-d4ae52e62bcc/android-wallpaper5_2560x1600_1.jpg "When you hover over the image this text appears")

![this appears if the image doesn't load](./doc/pics/android.jpg "When you hover over the image this text appears")

<img src="./doc/pics/android.jpg" width="200" height="200" />
#### 6.2 System Feature 2

---

## 5. Other Nonfunctional Requirements<a name="other-nonfunctional-requirements"></a>

#### 5.1 Performance Requirements<a name="performance-requirements"></a>
The application needs to open and run within 3 seconds. Functions must start operating within 0.2 seconds of being requested by the user. Timer must be running when in use whether it be in the foreground or background. Graphs must be fully created before viewable by the user.
#### 5.2 Safety Requirements<a name="safety-requirements"></a>
There will be generic safety requirements built into the system. The user will be advised to rest if the exercising session goes for an abnormal length of time. The user shall get updates at various integrals to advise the user to cease their workout if the inhibit abnormal pains or soreness. The system will also alert the user at various times to be alert of their surroundings when doing do the cardio exercises.
#### 5.3 Security Requirements<a name="security-requirements"></a>
Personal Information is up to the user to stay secure. No critical information will be stored in the application or on the device unless the user willingly inputs it. Any security or privacy certifications will be in parallel with the Google App Store.
#### 5.4 Software Quality Attributes<a name="software-quality-attributes"></a>
**Fast**- The product should be as responsive to the user’s input as possible. Once a user interacts with a feature, the application should respond with the appropriate response in the shortest time possible.

**Easy to use**- The interface is simple and easy for the user to understand how to use the product with minimal confusion.  How the user should interact with each feature of the product should be self evident and immediately doable.

**Streamlined**- The number of interactions the user is required to make with the application in order to achieve the desired response should be as minimal as possible. There should be the fewest possible delays before the user can start using the product.
#### 5.5 Business Rules<a name="business-rules"></a>

---

## 6. Other Requirements<a name="other-requirements"></a>

---

## 7. Appendix<a name="appendix"></a>

#### 7.1 Glossary<a name="glossary"></a>

#### 7.2 Analysis Models<a name="analysis-models"></a>

#### 7.3 To Be Determined List<a name="to-be-determined-list"></a>
