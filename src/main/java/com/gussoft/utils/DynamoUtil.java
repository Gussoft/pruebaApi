package com.gussoft.utils;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import java.util.UUID;

public final class DynamoUtil {

    public String tableName = "signprocess";
    private static final Regions REGION = Regions.US_WEST_1;

    //static BasicAWSCredentials awsCreds = new BasicAWSCredentials(ACCESS_KEY, ACCESS_SECRET);
    //static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
    //        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
    //        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2")).build();

    //static AmazonDynamoDB client = new AmazonDynamoDBClient(new BasicAWSCredentials(ACCESS_KEY, ACCESS_SECRET)).withRegion(REGION);
    static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(AwsServicesDyno.connectAws()))
            .withRegion(REGION).build();
    static DynamoDB dynamo = new DynamoDB(client);

    public Table getDynamo(String hash1, String hash2){
        try {
            String hash = UUID.randomUUID().toString();
            Table signProcess = dynamo.getTable(tableName);
            Item item = new Item()
                    .withPrimaryKey("Id", hash)
                    .withString("createAt", Fecha.DateandHour())
                    .withString("hash", hash1)
                    .withString("hashUnsigned", hash2);

            PutItemOutcome outcome = signProcess.putItem(item);
            System.out.println(outcome.toString());
            return signProcess;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public long getCount(){
        return dynamo.getTable(tableName).describe().getItemCount();
    }

    public long getCountNow(){
        long totalItemCount = 0L;
        ScanResult result;
        ScanRequest req = new ScanRequest();
        req.setTableName(tableName);
        result = client.scan(req);
        totalItemCount += result.getItems().size();

        return totalItemCount;
    }
}
