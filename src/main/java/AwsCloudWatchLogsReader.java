import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.logs.AWSLogsClient;
import com.amazonaws.services.logs.model.GetLogEventsRequest;
import com.amazonaws.services.logs.model.GetLogEventsResult;
import com.amazonaws.services.logs.model.OutputLogEvent;

public class AwsCloudWatchLogsReader {

    private static String AWS_ACCESS_KEY = "awsAccessKey";
    private static String AWS_SECRET_KEY = "awsSecretKey";

    // TODO: Consider adding logic to discover log stream and group names.
    private void readCloudWatchLogs( String logStreamName, String logGroupName ) {

        String accessKey = PropertyReader.readProperty( AWS_ACCESS_KEY );
        String secretKey = PropertyReader.readProperty( AWS_SECRET_KEY );
        if ( accessKey == null || secretKey == null ) {
            System.out.println( "Please provide an accessKey and secretKey in aws.properties." );
            return;
        }
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials( accessKey, secretKey );
        AWSLogsClient awsLogsClient = new AWSLogsClient( awsCredentials );

        GetLogEventsResult logEventsResult = awsLogsClient.getLogEvents( new GetLogEventsRequest()
                                                                                 .withLogGroupName( logGroupName )
                                                                                 .withLogStreamName( logStreamName ) );

        for ( OutputLogEvent logEvent : logEventsResult.getEvents() ) {
            // TODO: Process and return log entries.
        }
    }
}