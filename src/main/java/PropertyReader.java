import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static String[] PROPERTIES_FILES = { "aws.properties", "graylog.properties" };

    public static String readProperty( String propertyKey ) {

        try {
            for ( String fileName : PROPERTIES_FILES ) {

                Properties propertiesFile = new Properties();
                propertiesFile.load( PropertyReader.class.getClassLoader().getResourceAsStream( fileName ) );

                String propertyValue = propertiesFile.getProperty( propertyKey );
                if ( propertyValue != null ) {
                    return propertyValue;
                }
            }
        }
        catch ( IOException ex ) {
            // Absorb the exception for now.
            ex.printStackTrace();
        }

        return null;
    }
}