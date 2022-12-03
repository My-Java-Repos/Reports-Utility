# Reports Utility
This utility is used to genarate weeekly Datametrics excel sheet to be shared with product team. 


How to use this application in local system? 

Configuration Setup  

1. Import as Maven project in to your IDE
2. Build Maven project 
	
Running the project  

1. Add below environment variables in run configuration while running application as java application
    set MYSQL_DB: <database name>
    set MYSQL_DB_SCHEMA: <schema name>
    set MYSQL_DB_USERNAME: <database user name>
    set MYSQL_DB_PASSWORD: <database password>
	set FILE_LOCATION: <location where the log and report needs to be stored> 
	
Note: If your connecting to Azure MySQL then do the below steps 
    a.  Login into Azure using terminal 
	b.  Do the port forwarding 
	c.  Configure Environment Variables
	
2. Run the application as java application after successful environment setup 
3. Open browser and connect to local host 8080 port 
4. Give start and end dates and click on submit, it will generate report in excel 
5. It will show the excel file path in UI
