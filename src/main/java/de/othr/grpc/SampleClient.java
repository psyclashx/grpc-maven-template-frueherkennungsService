package de.othr.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SampleClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(SampleServer.SAMPLE_GRPC_HOST,
                        SampleServer.SAMPLE_GRPC_PORT)
                .usePlaintext()
                .build();

        //SampleServiceGrpc.SampleServiceBlockingStub stub = SampleServiceGrpc.newBlockingStub(channel);

        //Generate messages, use stub

    }
}
