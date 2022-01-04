package com.exemplo.jeff.sqs.poc.springbootsns.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SqsReceiver {
    public static final String SQS_QUEUE = "https://sqs.us-east-1.amazonaws.com/559111842637/sqs-demo-queue";

    @SqsListener(value = SQS_QUEUE,deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receive(String message){
        log.info("Message received {}", message);
    }
}
