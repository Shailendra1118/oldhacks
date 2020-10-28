### This is SpringBoot based web application that serves REST base APIs for clients.
Business case taken - On demand taxi booking 

### Technology used -
 - Build -> Gradle
 - Java/Spring
 

### How to run jar
 - Go to the project location and run command : gradle build
 - Copy the generated jar taxibooking-0.1.0.jar from project location \taxibooking\build\libs
 - Run command java -jar taxibooking-0.1.0.jar

```sh
$ cd %PROJECT_DIR%\taxibooking\build\libs\
$ java -jar taxibooking-0.1.0.jar
```


### How to run from IDE
 - Just go to App.java and run as Java application 


### Unit test cases are run when you build the app using command : gradle build

### API calls from client
 - reset : http://localhost:8080/api/reset
 		   Method : POST
 
 - ticker: http://localhost:8080/api/tick
 		   Method : POST
 
 - book  : http://localhost:8080/api/book
           Method : POST
           Header : [{"key":"Content-Type","value":"application/json","description":""}]
           	        [{"key":"Accept","value":"application/json;charset=UTF-8","description":""}]
 		   


```sh 
Request		   
 		   {
				"source": {
					"x": "2",
					"y": "1"
				},
				"destination": {
					"x": "3",
					"y": "4"
				}
			}
```	

	
```sh
Response
			 
			{
			    "carId": 2,
			    "totalTime": "7"
			}
```

### Includes 
 - Request flow document (/taxibooking/RequestFlow.pdf)
 - Unit test cases of services
 - Rest controller test cases


### Todos
 - Make the care available (isBooked = true) after tota_time unit (Spring AsyncTask can be used)
 - Write more Test cases
 - Improve tick request handling




