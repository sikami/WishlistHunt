package Sms;

import Password.Password;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;

/**
 * Sms class to connect with AWS SNS.
 * @author listya
 */

public class Sms {
    private ProfileCredentialsProvider profileCredentialsProvider;
    private BasicAWSCredentials awsCredentials;
    private AmazonSNS snsClient;
    private String smsMessage;
    private String number;
    private Password mobile;

    /**
     * Initialisation of Sms class with instantiate ProfileCredentialsProvider,
     * BasicAWSCredentials, and AmazonSNSClient.
     * This class also calls for getPhoneNumber() and initialise an empty string in sms.
     */
    public Sms() {
        this.profileCredentialsProvider = new ProfileCredentialsProvider();
        this.awsCredentials = new BasicAWSCredentials(profileCredentialsProvider.getCredentials().getAWSAccessKeyId(),
                profileCredentialsProvider.getCredentials().getAWSSecretKey());
        this.snsClient = AmazonSNSClient.builder().withRegion(Regions.EU_WEST_2).withCredentials(
                new AWSStaticCredentialsProvider(this.awsCredentials)).build();
        this.number = mobile.getPhoneNumber();
        this.smsMessage = "";
    }

    /**
     * setSms method overwrites the initialisation of String smsMessage in the constructor.
     * @param message the String message that will be sent as sms
     */
    public void setSms(String message) {
        this.smsMessage = message;
    }

    /**
     * send() method calls in publish method and instantiating new PublishRequest with smsMessage and number.
     * This method sends the SMS message to mobile phone.
     */
    public void send() {
        this.snsClient.publish(new PublishRequest().withMessage(this.smsMessage).withPhoneNumber(this.number));
    }
}
