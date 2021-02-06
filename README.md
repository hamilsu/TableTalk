## 1.	Introduction: - Storm 
TableTalk a collaboration tool for organizing board game nights with other people. It could be for personal or business use, as many game stores love to host tournaments or other get-togethers. The website would link with the BoardgameAtlas Api (Links to an external site.) which is a REST API which would allows for the integration of search features for boardgame rules and pictures so that users could make lobbies based on the game(s) they have and/or want to play.
## 2.	Storyboard (screen mockups): Invision, FluidUI, Powerpoint, paint, etc... will be fine. - Storm


Start Page
![Start Page](https://user-images.githubusercontent.com/55035232/106964285-e0494280-670f-11eb-912f-d6710a576ce2.PNG)

Log In Page
![Sign in](https://user-images.githubusercontent.com/55035232/106964297-e5a68d00-670f-11eb-9277-5954339d77eb.PNG)

Start Page after logging in
![Logged In](https://user-images.githubusercontent.com/55035232/106964304-e9d2aa80-670f-11eb-86ed-02f22f7dfe2b.PNG)

Create New Room
![Create Game](https://user-images.githubusercontent.com/55035232/106964529-3b7b3500-6710-11eb-85a9-e60c96bd1319.PNG)

Join Game
![Join Game](https://user-images.githubusercontent.com/55035232/106964343-f48d3f80-670f-11eb-9c48-7d652faac351.PNG)

Time Selector
![Time Selector](https://user-images.githubusercontent.com/55035232/106964352-f7883000-670f-11eb-9b76-f45a364fbe4d.PNG)


Overall View of Storyboard 
![TableTalk Overview](https://user-images.githubusercontent.com/55035232/106964268-da536180-670f-11eb-8e81-6292d25e4611.PNG)




## 3.	Functional Requirements in the format (fill in the square brackets with your own words):  - Luke
o As a User

o I want to log in

o So that I can use the app.

Given a username and password field

When I enter valid credentials

Then I should be logged in

-or-

Given a username and password field

When I enter invalid credentials

Then I should be notified of the incorrect credentials



o As a user

o I want to search for games

o So that I can find the game I want to play

Given a search field

When I type in the name of a game

Then I should be shown the correct game

-or-

Given a search field

When I type in the name of an unknown game

Then I should be shown a “Game Not Found” screen



o As a user

o I want to add friends

o So that I can interact with them

Given an “add” button on other people’s profiles

When I tap the button

Then it should send an invite to them to be friends



o As a user

o I want to create groups of friends (rooms)

o So that I can plan group events

Given a screen for rooms

When I tap “Create Room” button

Then I should create a room and add friends to it

-or-

Given a list of friends

When I tap “Add to room” button on friend’s profile

Then I should choose from my list of rooms or create a new room to add my friend to


   
## 4.	Class Diagram – Mamadou

o	UML-based class diagram.

o	Class Diagram Description: One or two lines for each class to describe use of interfaces,  classes and resources, interfaces, etc. Don't worry about putting 
more than a few words to each class; this does not need to be thorough.

![Class Diagram](images/Class%20Diagram.PNG)

## 5.	JSON Schema – Mamadou

o	 Your project should have an REST endpoint that emits JSON, which another group can consume.  The design document should contain a draft JSON schema for this endpoint. 

  You can create a schema from a Java class at QuickType.io.  This Java class is typically a DTO.  That's all you need at this point.

{
"Location":[
{
"id": "http://json-schema.org/geo",
"$schema": "http://json-schema.org/draft-06/schema#",
"description": "A geographical coordinate",
"type": "object",
"properties": {
"latitude": {
"type": "number"
},
"longitude": {
"type": "number"
}
}
},
{
"Person":[
{
"Register()": " ",
"Login()": " ",
"Profile()": " ",
"viewProfile": " "
},
{
"Register User":[
{
"firstName": "",
"lastName": "",
"userName": "",
"password": "",
"displayProfile": ""
},
{
"Login":[
{
"Verify()":"",
"printErrorMessage":""
},
{
"Games":[
{
"gameName": "",
"gameDate": ""
},
{
"GameListing":[
{
"Create()":"",
"Edit": "",
"View":""
},
{
"GameDescription":[
{
"gameName()":"",
"username":"",
"date": "",
"time": "",
"gameLocation":""
}]
}]
}]   
}]    
}]
}]

}]
}
 
## 6.	Scrum Roles, and who will fill those roles

Luke is UI Specialist

Storm And Mamadou Business Logic

Anne Scrum Master

## 7.	github.com project link - Anne
## 8.	 A scrum or kanban board, using GitHub projects or something similar, that contains: - Anne

	A milestone for Milestone #1, with tasks associated.
	
	Projects for Milestone #1.
	
	Tasked stores for Projects for Milestone #1. 
	
	Sprint tasks that elaborate on the stories, with technical details.
	
	These should be technical tasks that are required to implement one of the features.
	
	You only need to task out stories for Sprint #1.  You can task out stories for Sprint #2 and #3 as we get closer to those sprints. 
	
	The Product Owner/Scrum Master/DevOps person on your team should select stories to play for each sprint, from the list of available stories in the Product Backlog.
	
	As long as you have the tasks in GitHub Projects, under Projects, and associated with milestones, you do not need to repeat them in the design doc.  I'll look at  the Project 	       and Milestone view to see them. 
	
	Milestones for Milestone #2 and #3.   
	
	You do not need projects or tasks for these later milestones. You can define those in planning meetings, as we get closer.
	
## 9) Link to Teams for your 8:00 Sunday group stand up. 
Wednesdays @ 8:30 on Teams.

