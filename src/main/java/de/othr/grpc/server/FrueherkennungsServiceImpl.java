package de.othr.grpc.server;

import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import your.pkg.*;
import your.pkg.Void;

import java.util.stream.Stream;

public class FrueherkennungsServiceImpl extends FrueherkennungsServiceGrpc.FrueherkennungsServiceImplBase {

    @Override
    public StreamObserver<Roentgenbild> analysieren(StreamObserver<Bericht> responseObserver) {

        return new RoentgenbildHandler(responseObserver);
    }
    class RoentgenbildHandler implements StreamObserver<Roentgenbild> {

        private StreamObserver<Bericht> callbackBericht;

        RoentgenbildHandler(StreamObserver<Bericht> callbackBericht) {
            this.callbackBericht = callbackBericht;
        }

        @Override
        public void onNext(Roentgenbild roentgenbild) {
            System.out.println("Successfull operation of X-Ray: " + roentgenbild);
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("Error: " + throwable);
        }

        @Override
        public void onCompleted() {
            System.out.println("Finished!");
        }
    }
}
