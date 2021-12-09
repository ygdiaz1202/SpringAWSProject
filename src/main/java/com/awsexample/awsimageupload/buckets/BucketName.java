package com.awsexample.awsimageupload.buckets;

public enum BucketName {
    PROFILE_IMAGE("awsexample-image-upload-v1");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
