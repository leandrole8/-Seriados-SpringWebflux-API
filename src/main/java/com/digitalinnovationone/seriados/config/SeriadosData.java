package com.digitalinnovationone.seriados.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.springframework.context.annotation.Configuration;

import static com.digitalinnovationone.seriados.constants.SeriadosConstant.ENDPOINT_DYNAMO;
import static com.digitalinnovationone.seriados.constants.SeriadosConstant.REGION_DYNAMO;

public class SeriadosData {

    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Seriados_Table");

        Item seriado = new Item();
                seriado = (Item) seriado.withPrimaryKey("id", "2")
                .withString("name", "Game Of Thrones")
                .withString("type", "drama")
                .withNumber("seasons", 8);

        Item seriado2 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "The Mentalist")
                .withString("type", "policial")
                .withNumber("films", 7);

        Item seriado3 = new Item()
                .withPrimaryKey("id", "4")
                .withString("name", "Loki")
                .withString("type", "aventura")
                .withNumber("seasons", 2);

        PutItemOutcome outcome1 = table.putItem(seriado);
        PutItemOutcome outcome2 = table.putItem(seriado2);
        PutItemOutcome outcome3 = table.putItem(seriado3);
    }

}
