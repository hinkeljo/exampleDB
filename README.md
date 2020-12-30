# exampleDB
For the Programming Lecture 

This programm shows how to establish a connection to an SQLite database and how the read it's data and insert new or delete existing data.
All of this is done without the JPA as this doesn't fit the scope of this lecture and will maybe be discussed in a lecture in the following semester. 

## Tutorial for an SQLite Database
* [jdbc driver](https://github.com/xerial/sqlite-jdbc/releases/) download (https://github.com/xerial/sqlite-jdbc/releases/)

<p float = "center">
  <img src="ExampleDB/images/jdbc_download.PNG" >
</p>

* Place the .jar file in your project (e.g. in a new folder)

<p float = "center">
  <img src="ExampleDB/images/folder_hierarchy.PNG">
</p>

* In Netbeans, right-click on your project and select "Properties"
* In the menu "Libraries", add the downloaded driver to your classpath like shown in the picture

<p float = "center">
  <img src="ExampleDB/images/add_library.png" >
</p>

* For simplicity, download [a programm to manage SQLite databases](https://sqlitebrowser.org/dl/) (https://sqlitebrowser.org/dl/)
* In this programm, create a new SQLite databse in your project (can be a new sub-folder again) with tables according to your needs
* Have a look at the code example in this repository to learn how to use the databse in Java

## Alternatively:
* Copy this project (In Netbeans, right-click -> Copy)
* delete all classes except the DBManager class and replace them with your classes
* Adjust the database (with the SQLite Browser) and the DBManager to your classes and data

## Zusätzliche Resourcen:
* https://www.sqlitetutorial.net/sqlite-java/select/
* https://www.sqlitetutorial.net/sqlite-java/insert/
* https://www.sqlitetutorial.net/sqlite-java/delete/
* https://www.sqlitetutorial.net/sqlite-java/update/
