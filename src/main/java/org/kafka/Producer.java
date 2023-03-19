package org.kafka;
import com.github.javafaker.Faker;
import org.Utilities.Utilities;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONObject;


public class Producer {
    public static void main(String[] args) {
        Utilities utilities = new Utilities();
        Faker faker = new Faker();

        JSONObject person = Utilities.createPerson(faker.name().fullName(),
                                                   Utilities.generateRandomNumber(8, 90),
                                                   faker.address().streetAddress(),
                                                   faker.address().city(),
                                                   faker.phoneNumber().phoneNumber());
        String topic = "test";
        KafkaProducer<String, String> producer = new KafkaProducer<>(utilities.setKafkaProducerProperties());

        producer.send(new ProducerRecord<>(topic, person.toString()));
        producer.close();

    }

}