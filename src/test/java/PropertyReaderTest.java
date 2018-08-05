import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PropertyReaderTest {

    @Test
    public void testReadProperties() throws Exception {

        // Just make sure we can read at least one property.
        String graylogHost = PropertyReader.readProperty( "graylogHost" );
        assertEquals( "http://graylog.example.org:12202/gelf", graylogHost );
    }
}