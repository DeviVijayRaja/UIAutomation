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
 |devi.vijayhappy2015@gmail.com|Devi|Vijay|Orange@123|Unit-11,George Street|New Jersey|New Jersey|02754|United States|12345678912|George Street|

