package org.jcommune.utils;

import com.github.javafaker.Faker;

public class TestDataGeneration {
    Faker faker;

    public final String TOPIC_NAME;

    public final String POST_BODY;

    public final String USER_SIGNATURE;

    public TestDataGeneration() {
        this.faker = new Faker();

        TOPIC_NAME = faker.random().hex();

        POST_BODY = faker.random().hex();

        USER_SIGNATURE = faker.random().hex();
    }
}
