# Library System
## Homework task for Goyello
[![Build Status](https://travis-ci.com/sakovski/goyello-library-system.svg?token=ZoNpgtoCyELsp2h1fsEL&branch=master)](https://travis-ci.com/sakovski/goyello-library-system)
[![BCH compliance](https://bettercodehub.com/edge/badge/sakovski/library-system?branch=master)](https://bettercodehub.com/)
[![Maintainability](https://api.codeclimate.com/v1/badges/b63f8fc0d8a547c78dee/maintainability)](https://codeclimate.com/github/sakovski/library-system/maintainability)
### Initializing app
Application takes JSON absolute file path as argument to create books catalogue.

To compile maven with file path passed as argument:
```mvn
mvn install "-DlibraryFilePath=<absolute_path_of_your_file>"
```
Change <absolute_path_of_your_file> to your path file, e.g 
```
C:\\Desktop\\books.json
```
While working in IntelliJ:
```
Shift+Alt+F10 -> Edit Configurations... -> Program arguments -> <absolute_path_of_your_file>
```
### App features
This application is simple simulator of e-library. It allows:
* Adding new books
* Deleting books
* Searching books by title, name and ISBN number
* Searching books unrented for x weeks
* Renting books
* Returning books
* Displaying list of people who have rented books 
* Saving book catalogue to JSON file after every operation on catalogue
### TODO
* Unit tests
