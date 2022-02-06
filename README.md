##Description of Project
N11 Campaign Urls have imported to an Excel File.
this project created with POM page object model design pattern.

##How to run test case? 
- Go to configuration.properties and then chose the browser type.
- You can see environment urls type in configuration.properties
- If you want parallel test please run test suite

##How to run test case in Docker selenium grid container?
- Open the terminal and write 'docker-compose up' 
- Go to configuration.properties and then chose the remote-browser type.
- Run test suite with terminal or CukesRunner
- go to the localhost:4444 

##How to see report of test? 
- Write to terminal 
- 'cd target'
- 'allure serve' to seeing report.
- You can downlaod allure in this website 'https://docs.qameta.io/allure/'