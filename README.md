# WeatherReporter

This application performs basic CRUD operations on Weather Data for a travel company.

Language: Java 8  
Framework: Spring Boot  
Database: MongoDB 


REST API implemented

> GET  at/weather - retrieve all the weather data in the system   
>> SORTED in ascending order of Id  
>> ResposeCode : 200     

>GET  at/weather/date={date} ; date format = yyyy-MM-dd - retrieve all weather data for a particular date,   
>> SORTED in ascending order of Id  
>> ResponseCode : 200  

> POST at/weather - post a new weather record into the system  
>> ResponseCode : 201 - Created ; 400 - If record with the Id exists in the system  

> DELETE at/erase - erases all weather data in the system  
>> ResposeCode : 200   
      

                      
