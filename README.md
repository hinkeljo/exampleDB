# exampleDB
Für die Programmieren Vorlesung.

Das Programm zeigt wie man eine Verbdinung zu einer SQLite Datenbank herstellt und die Einträge daraus auslesen oder löschen und neue Einträge anlegen kann.

## Anleitung für eine SQLite Datenbank in Java
* [jdbc Treiber](https://bitbucket.org/xerial/sqlite-jdbc/downloads/) herunterladen

<img src="https://github.com/asder0815/exampleDB/blob/master/ExampleDB/images/jdbc_download.PNG" >

* Den Treiner in euer Projekt legen (z.B in einen neuen Unterorder)

<img src="https://github.com/asder0815/exampleDB/blob/master/ExampleDB/images/add_library.png">

*  Netbeans in euren Project-Properties (Rechtsklick auf das Project -> Properties), unter "Libraries" den Treiber zum Classpath hinzufügen

<p float = "center">
  <img src="https://github.com/asder0815/exampleDB/blob/master/ExampleDB/images/project_properties.png" > 
  <img src="https://github.com/asder0815/exampleDB/blob/master/ExampleDB/images/add_library.png" >
</p>

* Zur Einfachheit einen [Programm zum verwalten von SQLite Datenbanken](https://sqlitebrowser.org/dl/) herunterladen
* Darüber eine neue SQLite Datenbank anlegen (auch in eurem Projektordner) mit Tabellen wie ihr sie eben braucht
* Dann könnt ihr die Datenbank auch schon in Java einbinden, hierzu sollte das code Beispiel helfen 

## Datenbank Beispiel von Mustafa Rasheed
* https://lms.hs-pforzheim.de/mod/forum/discuss.php?d=19522
* https://lms.hs-pforzheim.de/mod/forum/discuss.php?d=19561

## Zusätzliche Resourcen: 
* https://www.sqlitetutorial.net/sqlite-java/select/
* https://www.sqlitetutorial.net/sqlite-java/insert/
* https://www.sqlitetutorial.net/sqlite-java/delete/
* https://www.sqlitetutorial.net/sqlite-java/update/
