# Blossom

![image](https://user-images.githubusercontent.com/52862591/165040240-9202646e-78aa-48e9-ac84-5e50189a5c00.png)

# An application to help you with your daily tasks and help you out with stress

## Table of contents:
- [Architecture](#architecture-and-design)
- [Design](#design)
- [Demonstration & Features](#demonstration)
- [Technologies Used](#technologies-used)
- [Local Setup & Contributing](#contributing)
- [License](#license)
- [Authors](#authors)

### architecture and design:

Because I have built this for fun and just to explore AR and three JS, following a good structure was not the highest on my list, and so, it is kinda (very) clunky!. 
<br>
However, here is how I have structure the application:
```
*
|_css
|_ideas
|_img
|_js
|_journal
|_games

```
### Design:

* The home page

For the home page, I decided to try and put a three JS transition, to captivate the attention of a new user as well as retain old one. A little over the top? Maybe. Worth it? ABSOLUTELY!

![image](https://user-images.githubusercontent.com/52862591/165067704-db510480-d5f7-49ed-96da-48ad70075384.png)

* The login page

All users have to login/signup with a Gmail account. Why Gmail? Because I plan to integrate this application with Google calendars, Google Photos, Maps, etc. 
We achieve user registration using Firebase. We have a simple and elegant login/signup page

![image](https://user-images.githubusercontent.com/52862591/165068562-60fc0bde-acdf-4f7c-a716-8cdf2d3939fb.png)

* The profile page

On successfully logging in, the user is taken to the profile page. The profile page consists of a robot that you can play around with and user options consisting of games, My tasks and logout.

![image](https://user-images.githubusercontent.com/52862591/165065266-38f231fa-3780-4b1a-b74a-831647d0795f.png)

* Adding tasks to the To Do list:

You can add tasks to the to do list. These are currently stored locally only. In the future I might shift them to Firebase's realtime storage database so that they can be accessed from any device that the user might login from.

![image](https://user-images.githubusercontent.com/52862591/165070588-519b845b-3c95-4d05-bfbc-d2f92e1fa131.png)

* Robot animations

The different animations have been achieved using a raycaster, which detects a user tap and randomly plays an animation. Currently, I am not handling an exception case that occurs when a user taps the robot too frequently.

* Games

There are different games that I have included. Sure, they are not competitive in nature and so, have no scores, but they were never meant to be competitive. These are just there for the user to relax. All work and no play makes Jack a dull boy!

![image](https://user-images.githubusercontent.com/52862591/165069776-74bf67e7-0415-4673-914c-f7445ed0b758.png)

These include, the cat and wool ball

![image](https://user-images.githubusercontent.com/52862591/165070199-93b365e1-3842-41bd-b955-ae8742b88fc0.png)

Chill the lion

![image](https://user-images.githubusercontent.com/52862591/165070315-acd584ce-67a8-4d3e-be4b-44620d5639a4.png)

and Sneez the Dragon

![image](https://user-images.githubusercontent.com/52862591/165070423-b4bb4dc0-dbc1-41c3-881f-27858236cc33.png)

### Demonstration:
checkout the live site on https://jadenfurtado.github.io/Blossom

### Technologies-used

* The front end is written in HTML, CSS and JS. As mentioned, a lot of ThreeJS has been used in this app for various transition effects and the animations and 3D models.
* The backend uses Firebase for authentication and Firebase Readltime database for future versions of the application that may require a DB. 
* Why firebase? Well, as I was building this for fun and with the aim of focusing on three JS and AR, I did not want to spend too much time coding a backend and so firebase was the obvious candidate. That and the fact that this use case kinda seemed reasonable for me to use it at that time. Although, if the number of users on this application grow, I might consider shifting to a backend built on Flask.
* As it does not really have a backend, I have hosted it on GitHub pages for now

### Local Setup and Contribution:
For setup:
- Clone the repository locally
- Change a few of the links in the site (They were hardcoded by me 😅)
Feel free to open an issue or a PR and I'd love to see what ideas you have for this application!

### Security:
I take the security and safety of my application and its users very seriously. Although I have taken every precaution that I could, I realize that there may be a few loopholes that I may have missed. Do please flag them to me should you find any so that they can be patched by me ASAP!

### License:
<a href="https://github.com/JadenFurtado/selfHelpApp/blob/main/LICENSE">The app is under the Creative Commons Zero v1.0 Universal license</a>

### Authors:

This app was written by me, <a href="https://twitter.com/furtado_jaden">Jaden Furtado</a>
For certain components that I have used, the credits go to them. The list is <a href="https://github.com/JadenFurtado/Blossom/blob/main/CREDITS.md">here</a>
