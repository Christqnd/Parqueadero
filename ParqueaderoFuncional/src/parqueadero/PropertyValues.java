/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author pc_hp
 */
public class PropertyValues {

    private InputStream inputStream;
    private static PropertyValues instance;
    public Property property;

    private PropertyValues() {
        property = new Property();
    }

    public static PropertyValues getInstance() throws IOException {
        if (instance == null) {
            instance = new PropertyValues();
            instance.getPropValues();
        }
        return instance;
    }

    private void getPropValues() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "resources\\config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            property.setUrlApiParkingGo(prop.getProperty("apiparkinggo"));

            System.out.println("Read Property finish!");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return;
    }

}
