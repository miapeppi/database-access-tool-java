#Assignment 6
###Access and expose a database
This project contains API for retrieving customer data from [Chinook database](https://www.sqlitetutorial.net/sqlite-sample-database/) and [Thymeleaf](https://www.thymeleaf.org/) for displaying views.

###API
- Read all the customers in the database
- Read a specific customer from the database by Id
- Read a specific customer by name
- Return a page of customers from the database
- Add a new customer to the database
- Update an existing customer
- Return the number of customers in each country, ordered descending (high to low)
- Customers who are the highest spenders (total in invoice table is the largest), ordered descending
- For a given customer, their most popular genre
    
###Thymeleaf
- Home view
  - Shows 5 random artists, 5 random songs, and 5 random genres
  - Has a search bar which is used to search for tracks
- Results view
  - Shows a row of results containing track name, artist, album, and genre for the query the user has made
