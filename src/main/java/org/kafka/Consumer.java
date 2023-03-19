package org.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.Utilities.Utilities;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {
    public static void main(String[] args) {
        Utilities utilities = new Utilities();

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(utilities.setKafkaConsumerProperties());
        consumer.subscribe(Arrays.asList("test"));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("%s", record.value());
                System.out.println("\n");

            }

        }

    }

}
