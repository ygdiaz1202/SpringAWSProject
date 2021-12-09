package com.awsexample.awsimageupload.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    @Bean
    public AmazonS3 s3(){
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "AKIAQPCXA5NOVP7BHPY3",
                "Z2ZrT1ut9NEoMBKuuZWmmQXa7MbFF8JRQfiPf/fk"
        );
        return AmazonS3ClientBuilder
                .standard()
                .withRegion("us-east-2")  //This is the code i added to fix
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}