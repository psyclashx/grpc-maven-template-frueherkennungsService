package de.othr.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class SampleServer {

    public static final String SAMPLE_GRPC_HOST = "localhost";
    public static final int SAMPLE_GRPC_PORT    = 1234;

    public static void main(String[] args) {
        /*
        Server server = ServerBuilder.forPort(SAMPLE_GRPC_PORT)
                .addService(new MyServiceImpl())
                .build();

        server.start();

        System.out.println("Server running...");

        server.awaitTermination();
        */
    }
}
