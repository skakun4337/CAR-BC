package config;


import Exceptions.FileUtilityException;
//import com.sun.javafx.runtime.SystemProperties;
import constants.Constants;
import org.json.JSONObject;
import utils.FileUtils;

/**
 *
 */
public final class CommonConfigHolder {
    private static final CommonConfigHolder INSTANCE = new CommonConfigHolder();
    private JSONObject configJson;

    private CommonConfigHolder() {}
    public static CommonConfigHolder getInstance() {
        return INSTANCE;
    }

    public JSONObject getConfigJson() {
        return configJson;
    }

    public void setConfigUsingResource(String peerName) throws FileUtilityException {
        String resourcePath = System.getProperty(Constants.CARBC_HOME)
                +"/src/main/resources/" + peerName +".json";
        this.configJson = new JSONObject(FileUtils.readFileContentAsText(resourcePath));
    }
}
