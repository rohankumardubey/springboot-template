//package com.clairvoyant.springboottemplate.util;
//
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.utility.DockerImageName;
//
//
//public class PostgreSQLContainerUtil extends PostgreSQLContainer<PostgreSQLContainerUtil> {
//
//    private static final DockerImageName POSTGRES_IMAGE_NAME = DockerImageName.parse("postgres");
//    private static PostgreSQLContainerUtil container;
//
//    private PostgreSQLContainerUtil() {
//        super(POSTGRES_IMAGE_NAME);
//    }
//
//    public static PostgreSQLContainerUtil getInstance() {
//        if (container == null) {
//            container = new PostgreSQLContainerUtil();
//        }
//        return container;
//    }
//
//    @Override
//    public void start() {
//        super.start();
//        System.setProperty("DB_URL", container.getJdbcUrl());
//        System.setProperty("DB_USERNAME", container.getUsername());
//        System.setProperty("DB_PASSWORD", container.getPassword());
//    }
//
//    @Override
//    public void stop() {
//        //do nothing, JVM handles shut down
//    }
//}
