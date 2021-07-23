# BuzzFinder

Michael Ingram (Developer, Scrum Master, Repo Owner)
Alex Lopez (Developer)
Kim Nettleton (Developer)
Rachel Richardson (Developer, DBA)

## Overview

BuzzFinder is an application that allows the user to search a vast database of breweries and beers to find whichever beer or brewery they are looking for. If the user has an account then they can also add a beer or brewery as a favorite. Additionally, a logged in user can leave a review of any beer or brewery. Having a BuzzFinder account provides the user with a place to keep their favorite beers and breweries that won't get lost! And if the user no longer likes a beer or brewery, they can always remove it from the list.

## Description

The user is first shown a welcome page. The welcome page has information about the BuzzFinder database as well as buttons in the navigation bar that log in, sign up, or search. Clicking the log in button takes the user to a log in page that prompts them for their username and password. Once logged in the user is taken to their profile page. If the user clicks the sign up button the are taken to a page that prompts them for a username, password, and favorite beer style. After inputing this information the user is prompted to finish their account sign up by inputting their name, and address. After finishing the signing up process the user is taken to their profile page. Lastly, if the user clicks the search button they are taken to a search page where they can search the database.

The search page has four options for searching: search by brewery name, search by beer name, search by beer style, and search by brewery location. After submitting the search the user is taken to a page displaying the results list that includes every beer or brewery that matched the search criteria. Next to each search result is a button to view the brewery or beer details. When a user clicks on the details button they are taken to that beer or breweries detail page. If the user is logged into an account, the details page will include buttons to add that beer or brewery as a favorite, leave a review of the beer or brewery, or return to their homepage.

The user's profile page displays their information, including name, and address, and their favorite beer and breweries, if they have any. From here a user can choose to update or delete their account. If the user's lists aren't empty, they can view the details of a beer or brewery in their list by clicking the details button. If the list is empty, the user can add favorites by clicking the search button in the navigation bar, and then clicking the favorite button once they have navigated to the details page as described above.

A logged in user can also leave a review of a beer of brewery by clicking the review button on the details page. Clicking review takes the user to a form with the corresponding beer or brewery's name already filled out in the top. After filling out and submitting the review form the user is directed back to the details page, where they can see their review posted below the beer or brewery. When a user is ready to leave, they can click the log out button in the navigation bar, and are redirected to the homepage.

Link to Deployed App: http://52.42.7.37:8080/BuzzFinder/

## Implementation

The project was first mapped out with an EER Diagram in MySql WorkBench. From there entities were made for the main tables and relationships were mapped according to the diagrams layout of foreign and primary keys. These relationships were then Junit tested, and after all of the tests were successful, DAOs and DAOImpls were created for each entity, except brewery review and beer review, which were consolidated into one DAO and DAOImpl. Lastly, the contollers and jsps were created and customized by bootstrap and css.

## Technologies and Methodologies Used

- Java
- CRUD
- MySQL
- JPA
- Spring MVC
- HTML
- CSS
- Group Project
- Full Stack

## Lessons Learned

- Importance of Communication: Our team was excited to get started on the project, and would have benefited from taking more time to communicate exactly who was going to do what part of the project. This would have prevented us from having multiple copies of code in separate classes that do the same thing.

- Attention to Detail: In a full stack application that involves many people it is important to pay attention to every single letter in code more than ever. If one team member has a variable annotated just one letter off, it will effect the entire application, and may be hard to find when you have moved on further in the code.

## Stretch Goals

- Brewery Tour: A logged in user would be able to plan a day of brewery tours by using the brewery information local to their area.

- Admin Level User: A brewery owner that could log in to make changes to the brewery or beer sold at their brewery.

- More Search Functionality: A user would be able to search for beer by using a brewery name, and vice versa. As well as being able to find a brewery by what style of beer they make most of.

## How To Download and Run

The database is dowloaded from the project's git page in the DB folder. Once the database is downloaded, the app is run by going to the website linked in the description above.
