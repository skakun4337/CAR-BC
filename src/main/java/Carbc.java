import Interfaces.Cli;
import constants.Constants;

public class Carbc {
    public static void main(String[] args) {
        //Set the main directory as home
        System.setProperty(Constants.CARBC_HOME, System.getProperty("user.dir"));

        //Start the cli
        Cli.start(args);
    }


}
