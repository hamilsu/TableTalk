## Spring 2 Code Reviewers: You must have Wampserver installed and running on your machine in order to build the project

## 1.	Introduction:
TableTalk a collaboration tool for organizing board game nights with other people. It could be for personal or business use, as many game stores love to host tournaments or other get-togethers. The website would link with the BoardgameAtlas Api (Links to an external site.) which is a REST API which would allows for the integration of search features for boardgame rules and pictures so that users could make lobbies based on the game(s) they have and/or want to play.

## 2.	Storyboard:


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




## 3.	Functional Requirements:

1. 
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


2.

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


3.

o As a user

o I want to add friends

o So that I can interact with them

Given an “add” button on other people’s profiles

When I tap the button

Then it should send an invite to them to be friends


4.

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


   
## 4.	Class Diagram: 

![Class Diagram](images/ClassDiagram.PNG)


Person: Class assigned to each visitor of the website, allows them to register, login, and make changes to their profile.
Register User: Temporary class used to register a new user account.

Login: Temporary class used to verify and login a user, as well as print an error message

GameLibrary: Personal library of games, allows for the creation of new games in the library. The editing of the games currently in the library, and a standard view for the library.

GameDescription: Basically the individual games themselves. Allows for the name of the game, the user it belongs to, and tie ins to specific rooms if applicable at the time. See Room for more info

Games: More of a shorthand for each room the user is currently a part of. Gives access to the name, date, time, and member list of each room that has already been set up.

Room: Synonymous with a lobby. Main class that controls the collaboration aspects of each game night. Allows for invite links to be generated, the list of games available in the host’s library, and a description of the of game night the host wants to plan.


## 5.	JSON Schema: 

o	 Your project should have an REST endpoint that emits JSON, which another group can consume.  The design document should contain a draft JSON schema for this endpoint. 

  You can create a schema from a Java class at QuickType.io.  This Java class is typically a DTO.  That's all you need at this point.


{
"Room":[

{

"createInviteLink": "The user will be able to create a link which they can use to invite friends",

"Roomname": "Friends can find your room using the name if they don't have a link",

"Gamelibrary": "have  the games that you can choose from",

"gameDescription": " What the game is about who created the room"

},

{

"Person":[
{

"Register()": "user doesn't have an account need to register",

"Login()": "after registering users can login",

"Profile()": "users can have acces to their profile ",

"viewProfile": " they can have a viewprofile where they can change name"
},
{

"Register User":[
{

"firstName": "user registering entering the firstname",

"lastName": "user registering entering the lastname",

"userName": " users also have to create a username that they can use to login",

"password": " password for authentication",

"displayProfile": " Displaying the user profile"
},
{
"Login":[
{

"Verify()":"Make sure that the user authentications are correct",

"printErrorMessage":" send error message if authentication is wrong"
},
{
"Games":[
{

"gameName": "have a game name when created",

"gameDate": "date is needed for games"
},
{
"GameListing":[
{

"Create()":" have to create a room",

"Edit": "user can also edit the room",

"View":"users can see the room they created"
},
{
"GameDescription":[
{

"gameName()":"when someone else is looking at the room",

"username":"need to know who created the room",

"date": "date of the game",

"time": "time of the game",

"gameRoom":"name of gameroom"
}]
}]
}]   
}]    
}]
}]

}]}
 
## 6.	Scrum Roles:

UI Specialist: Luke Greeley

Business Logic Specialists: Storm Hamilton & Mamadou Kone

Scrum Master: Anne Catherwood

## 7.	GitHub Project Link:

[Repository](https://github.com/hamilsu/TableTalk)

## 8.	 Scrum Board (AKA Github Projects):
[Project Board](https://github.com/discospiff/SpringBootMicroservicesWithIntelliJIDEA/milestone/1)

## 9) Standup Time and Link:  
[Wednesdays and Sundays @ 9:00 on Teams](https://teams.microsoft.com/l/meetup-join/19%3ameeting_OThiNzkzYTgtYzAzMi00YzBkLTk2ZWUtYzMyYjFjYmRkNDM2%40thread.v2/0?context=%7b%22Tid%22%3a%22f5222e6c-5fc6-48eb-8f03-73db18203b63%22%2c%22Oid%22%3a%220a98679a-f018-43b0-b7ad-e6cb6d74f56d%22%7d) 

