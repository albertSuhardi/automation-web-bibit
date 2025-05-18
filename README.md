Visual Code : 
- Choose View then Command Pallete in Visual Studio or type Command Pallete in Search bar VS Code
- Choose Java:Create Java Project...
- Choose Maven 
- Choose Maven Quickstart

in Pom xml, copy past or import this library that can you get from here "https://github.com/albertSuhardi/automation-web-bibit/blob/main/pom.xml"
in test/java/com/bibitweb make 3 directory 
pages    : class that used for access the element that we choose 
runners  : Action or your test code that will run Given When Then
stepdefs : proxy or connect features with stepdefs

type mvn test , code will running

Notes : 
- Cause i don't get test data, you need to change pin for login in resources/features/login.features
- I'm using firefox, if you want to use another browser need to add it manually in stepdefs/SearchStepDef.java
- You need to change path in stepdefs/SearchStepDef.java, make sure you used your own path browser