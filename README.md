# phoneservice
```
The mobile software testing team has 10 mobile phones that it needs to share for testing purposes:
  - Samsung Galaxy S9
  - 2x Samsung Galaxy S8
  - Motorola Nexus 6
  - Oneplus 9
  - Apple iPhone 13
  - Apple iPhone 12
  - Apple iPhone 11
  - iPhone X
  - Nokia 3310
• Application must allows a phone to be booked / returned
• Application must allow to show information about availability for each phone
  - Availability (Yes / No)
  - When it was booked
  - Who booked the phone
```
```
How to run:
You must have MVN and JAVA 17 installed. (MacOS tip: export JAVA_HOME=$(/usr/libexec/java_home -v 17))
cd <project dir>
mvn clean compile install
java -jar phoneservice-0.0.1-SNAPSHOT.jar

By default application uses in-memory H2 db. If you want for persistence on FS, then you need to override spring property: 'spring.datasource.url'.
You can do this in applicatio.properties file or inject it in start commandline(example: java -jar phoneservice-0.0.1-SNAPSHOT.jar -spring.datasource.url=jdbc:h2:<path>:testdb)
```
