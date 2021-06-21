package com.mel.galaxy.util;

import java.util.HashMap;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;

public class DynamoUtil {

    private DynamoDbClient ddb = null;
    private static DynamoUtil dynamoUtil;

    public DynamoUtil() {
        ddb = DynamoDbClient.builder().region(Region.US_EAST_1).build();
    }

    public static DynamoUtil getIntance() {
        if (dynamoUtil == null) {
            dynamoUtil = new DynamoUtil();
        }
        return dynamoUtil;
    }

    public boolean putItem(String tableName,
            HashMap<String, AttributeValue> itemValues) {

        try {
            PutItemRequest request = PutItemRequest.builder()
                    .tableName(tableName).item(itemValues).build();

            ddb.putItem(request);
            return true;

        } catch (ResourceNotFoundException e) {
            System.err.format(
                    "Error: The Amazon DynamoDB table \"%s\" can't be found.\n",
                    tableName);
            System.err.println(
                    "Be sure that it exists and that you've typed its name correctly!");
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
        }

        return false;

    }

    public static HashMap<String, AttributeValue> buildItem(int key,
            String value) {

        HashMap<String, AttributeValue> itemValues = new HashMap<String, AttributeValue>();
        // Add all content to the table
        itemValues.put("day",
                AttributeValue.builder().s(String.valueOf(key)).build());
        itemValues.put("weather", AttributeValue.builder().s(value).build());

        return itemValues;

    }

}
