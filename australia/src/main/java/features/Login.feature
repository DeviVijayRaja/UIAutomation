Feature: Register Email address 

Background: 
	Given Open The Browser
	
Scenario Outline: Register Email address 
	And Click on Sign in link
	And Enter Email address as <Emailid>
	And Click on Create an Account button
	And Verify Green or Red tick
	And Enter Firstname as <Firstname>
	And Enter Lastname as <Lastname>
	And Enter Password as <Password>	
	And Verify Firstname,Lastname,Email pre-populated
	And Enter Address as <Address>
	And Enter City as <City>
	And Select State as <State>
	And Enter Zipcode as <Zipcode>
	And Select Country as <Country>
	And Enter MobilePhone as <Mobilephone>
	And Enter alias Address as <AliasAddr>
	And Verify whether Registration is successful 
	
Examples: 
|Emailid|Firstname|Lastname|Password|Address|City|State|Zipcode|Country|Mobilephone|AliasAddr|	
|devivijayak@gmail.com|Devi|Vijay|Orange@123|Unit-11,George Street|New Jersey|New Jersey|02754|United States|12345678912|George Street|

Scenario Outline: Check Megamenu works
And Click on Sign in link
And Enter SignIn Email as <Emailid>
And Enter Password as <Password>
And Click on Sign in button
And Click on Megamenu
When Click on DressType <Type>
Then Verify Dresses should be displayed

Examples: 
|Emailid|Password|Type|
|pranitharaja2010@gmail.com|Kuttima@123|Summer Dresses|

Scenario Outline: Sort and Validate the product grid
And Click on Sign in link
And Enter SignIn Email as <Emailid>
And Enter Password as <Password>
And Click on Sign in button
And Click on Megamenu
When Click on DressType <Type>
Then Verify Dresses should be displayed
When Select Sort by as <Price>
Then Verify Dresses sorted by

Examples: 
|Emailid|Password|Type|Price|
|pranitharaja2010@gmail.com|Kuttima@123|Summer Dresses|Price: Highest first|

