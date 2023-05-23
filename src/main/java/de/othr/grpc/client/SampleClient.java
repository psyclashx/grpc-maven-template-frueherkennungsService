package de.othr.grpc.client;

import com.google.protobuf.Timestamp;
import de.othr.grpc.server.SampleServer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import your.pkg.Bericht;
import your.pkg.FrueherkennungsServiceGrpc;
import your.pkg.Roentgenbild;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class SampleClient {

    public static void main(String[] args) throws InterruptedException {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(SampleServer.SAMPLE_GRPC_HOST,
                        SampleServer.SAMPLE_GRPC_PORT)
                .usePlaintext()
                .build();

        //SampleServiceGrpc.SampleServiceBlockingStub stub = SampleServiceGrpc.newBlockingStub(channel);

        FrueherkennungsServiceGrpc.FrueherkennungsServiceStub stub = FrueherkennungsServiceGrpc.newStub(channel);

        Roentgenbild roentgenbild = Roentgenbild.newBuilder()
                .setTimestamp(Timestamp.newBuilder().setSeconds(System.currentTimeMillis()).build())
                .setPatientenName("Max Muster")
                .build();


        UeberwachungBericht ueberwachungBericht = new UeberwachungBericht();

        StreamObserver<Roentgenbild> roentgenbildStreamObserver = stub.analysieren(ueberwachungBericht);


        roentgenbildStreamObserver.onNext(roentgenbild);
        roentgenbildStreamObserver.onNext(roentgenbild);
        roentgenbildStreamObserver.onNext(roentgenbild);
        roentgenbildStreamObserver.onNext(roentgenbild);
        roentgenbildStreamObserver.onNext(roentgenbild);
        roentgenbildStreamObserver.onNext(roentgenbild);
        roentgenbildStreamObserver.onNext(roentgenbild);
        roentgenbildStreamObserver.onNext(roentgenbild);
        roentgenbildStreamObserver.onCompleted();
        //Generate messages, use stub



        channel.awaitTermination(5L, TimeUnit.SECONDS);

    }
    static class UeberwachungBericht implements StreamObserver<Bericht> {

        @Override
        public void onNext(Bericht bericht) {
            System.out.println("Successfull operation of Report: " + bericht);
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("Error of operation Report: " + throwable);
        }

        @Override
        public void onCompleted() {
            System.out.println("Finish");
        }
    }
}
