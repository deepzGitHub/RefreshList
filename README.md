Overview

Application Overview:-

    1. Right click and Run com.RefreshListApplication class
    2. com.config.RefreshListConfig.java is @ConfigurationProperties(prefix="test.refreshlist")
    3. application.yml has the list defined which is mapped to List colors, source in RefreshListConfig
    
Issue Overview :-

	4. List refresh (addition and deletion) works perfect when ComponentScaned ONLY from the java configuration where the Bean is defined
    5. Few Scenarios where the list is getting messed up when some entries are removed 
    Case 1 -
       Component Scan is on a java configuration class present in a package other than the package where RefreshScope bean is defined. (Since the configuration class is in root folder technically it scans all the folders below it) 
    Case 2 -
        The java configuration which defines the refresh scoped bean is scanned twice (One from the Configuration class present in the root of the source package and second scan is from the java configuration where refreshscope bean is defined.)

In both Case 1,2 issue is only when and item is removed from list, additions, updates to string works perfect. This makes me think there is an issue with List

The latest source code here explains Case 2 where,

    - RefreshListApplication.java has @ComponentScan and its on the root package. It is Importing InnerConfig.java
    - InnerConfig.java defined RefreshListConfig bean which is @RefreshScope and also do @ComponentScan(basePackages={"com.config"})
    
To switch to Case 1 above, follow below steps

    - Comment out @ComponentScan in InnerConfig.java

- Scenario in which this works as expected is when,
    - No @ComponentScan is defined in RefreshListApplication.java
    - Define all the component scan in InnerConfig.java (@ComponentScan(basePackages={"com.config", "com.controller"}))
          
Please follow below steps for testing for Case 1,2:-       
    
Testing

Step-1

    1.Start the application with no change in the application.yml
	
    2. The size of List colors in RefreshListConfig will be 6 and source = background
	
    3. This could be tested by using the below url, 
	
        http://localhost:9003/test/refreshed
		
        Response in browser :- source = background, colors = [orange, green, blue, pink, red, yellow]
        
        
Step-2

    1. Update application.yml as below
	
        1.1 remove entry red, yellow from the colors list
		
        1.2 change source from background to border
		
    2. Do a http POST on this url http://localhost:9003/refresh to refresh RefreshListConfig
	
    3. Access http://localhost:9003/test/refreshed
	
		Expected Result :- source = border, colors = [orange, green, blue, pink]
		
		Actual Result :- source = border, colors = [orange, green, blue, pink, red, yellow]
		
		ISSUE :- STRING source is GETTING updated correctly but not list - red, yellow not yet removed
    
Step-3

    1. After executing Step-2, update application.yml as below
	
        1.1 Add a new entry white to the list 
		
        1.2 change source from border to font
		
    2. Do a http POST on this url http://localhost:9003/refresh to refresh RefreshListConfig
	
    3. Access http://localhost:9003/test/refreshed
	
		Expected Result :- source = font, colors = [orange, green, blue, pink, white]
		
		Actual Result :- source = font, colors = [orange, green, blue, pink, white, yellow]
		
		ISSUE :- STRING source is GETTING updated correctly but not list - red is replaced with white, yellow not yet removed
			

