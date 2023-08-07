package steps;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

// removing the CommonMethodss temporarily

//extends CommonMethods

public class Hooks  {

   /* @Before
    public void start(){

        //openBrowserAndNavigateToURL();
    }*/

   /* @After
    public void end(Scenario scenario){

        byte [] pic;
        if(scenario.isFailed()){

            pic= takeScreenshot("failed/"+scenario.getName());
        }else{

            pic = takeScreenshot("passes/"+scenario.getName());
        }

        pic=takeScreenshot(scenario.getName());

        scenario.attach(pic, "image/png", scenario.getName());

        //closeBrowser();
    }*/
}