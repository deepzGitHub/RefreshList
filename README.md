Overview
    
    1. Right click and Run demo.RefreshListApplication class
    2. config.RefreshListConfig.java is @ConfigurationProperties(prefix="test.refreshlist") and @RefreshScope
    3. application.yml has the list defined which is mapped to List colors in RefreshListConfig
    
Testing

Scenario-1

    1.Start the application with no change in the application.yml
    2. The size of List colors in RefreshListConfig will be 6
    3. This could be tested by using the below url, 
        http://localhost:9002/test/refreshed
        Response in browser :- [orange, green, blue, pink2, red, yellow]
        
Scenario-2

    1. Update application.yml as below
        1.1 remove entry red, yellow from the colors list
        1.2 change pink to pink2
    2. Do a http POST on this url http://localhost:9002/refresh to refresh RefreshListConfig
    3. Access http://localhost:9002/test/refreshed
    Expected Result :- [orange, green, blue, pink2]
    Actual Result :- [orange, green, blue, pink2, red, yellow]
    
Scenario-3

    1. After executing Scenario-2, update application.yml as below
        1.2 Add a new entry white
    2. Do a http POST on this url http://localhost:9002/refresh to refresh RefreshListConfig
    3. Access http://localhost:9002/test/refreshed
    Expected Result :- [orange, green, blue, pink2, white]
    Actual Result :- [orange, green, blue, pink2, white, yellow]
