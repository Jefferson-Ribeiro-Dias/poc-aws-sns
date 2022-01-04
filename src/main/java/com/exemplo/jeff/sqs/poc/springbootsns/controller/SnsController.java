package com.exemplo.jeff.sqs.poc.springbootsns.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnsController {

    public static final String ARN_SNS_TOPIC = "sns-demo-topic";
    public static final String ARN_SQS_QUEUE = "sqs-demo-queue";

    @Autowired
    private AmazonSNSClient amazonSNSClient;


    //send messages from SNS to SQS Queue;
    @GetMapping("/subscribe/sqs")
    public String subscribeToSQS(){
        SubscribeRequest subscribeRequest =
                new SubscribeRequest(ARN_SNS_TOPIC,
                        "sqs",ARN_SQS_QUEUE);
        amazonSNSClient.subscribe(subscribeRequest);
        return "SQS subscription successful";
    }

    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable(value = "message") String message){
        PublishRequest publishRequest = new PublishRequest(ARN_SNS_TOPIC, message, "Email Demo");
        amazonSNSClient.publish(publishRequest);
        return "Message published successfully";
    }

   //send messages to email;
   @GetMapping("/subscribe/{email}")
   public String subscribeToEmail(@PathVariable(value="email") String email){
       SubscribeRequest subscribeRequest =
               new SubscribeRequest(ARN_SNS_TOPIC,
                       "email",email);
       amazonSNSClient.subscribe(subscribeRequest);
       return "Email subscription successful";
   }
}
