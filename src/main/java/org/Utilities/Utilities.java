package org.Utilities;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;
import java.util.Random;

import org.json.JSONObject;

public class Utilities {
    public Properties setKafkaProducerProperties(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return props;

    }
    public Properties setKafkaConsumerProperties(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test-group");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());

        return props;

    }
    public static JSONObject createPerson(String name, int age, String address, String city, String phoneNumber) {
        JSONObject person = new JSONObject();
        person.put("name", name);
        person.put("age", age);
        person.put("address", address);
        person.put("city", city);
        person.put("phone number", phoneNumber);

        return person;

    }
    public static int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;

    }
}
