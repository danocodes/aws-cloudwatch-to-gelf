import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GraylogGelfClient {

    public static final String APPLICATION_JSON_CONTENT_TYPE = "application/json";
    private static String GRAYLOG_HOST = "graylogHost";

    /**
     * Sends message to Graylog host in Gelf HTTP format.
     * @param objectPayload Arbitrary object defined by the caller. Will be serialized to JSON.
     * @return true if successful, false if failure */
    public static boolean sendMessage( Object objectPayload ) {

        try {
            Client client = Client.create();

            WebResource webResource = client
                    .resource( PropertyReader.readProperty( GRAYLOG_HOST ) );

            Gson gson = new Gson();
            String input = gson.toJson( objectPayload );

            ClientResponse response = webResource
                    .type( APPLICATION_JSON_CONTENT_TYPE )
                    .post( ClientResponse.class, input );

            if ( response.getStatus() != 200 ) {
                return false;
            }
        }
        catch ( Exception e ) {
            return false;
        }

        return true;
    }
}