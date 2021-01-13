package Sms;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;

public class Sms {
    private ProfileCredentialsProvider profileCredentialsProvider;
    private BasicAWSCredentials awsCredentials;
    private AmazonSNS snsClient;

    public Sms() {
        this.profileCredentialsProvider = new ProfileCredentialsProvider();
        this.awsCredentials = new BasicAWSCredentials(profileCredentialsProvider.getCredentials().getAWSAccessKeyId(),
                profileCredentialsProvider.getCredentials().getAWSSecretKey());
        this.snsClient = AmazonSNSClient.builder().withRegion(Regions.EU_WEST_2).withCredentials(
                new AWSStaticCredentialsProvider(this.awsCredentials)).build();


    }
}
