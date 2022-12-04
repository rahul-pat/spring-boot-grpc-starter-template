package com.github.rahulpat.grpcserverproject.service;

import com.github.rahulpat.grpcserverproject.GreetingRequest;
import com.github.rahulpat.grpcserverproject.GreetingResponse;
import com.github.rahulpat.grpcserverproject.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceGrpcImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {

        String result = "Hello from the server. Here is your message: " + request.getMessage();

        GreetingResponse response = GreetingResponse.newBuilder()
                                                    .setMessage(result)
                                                    .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();

    }
}
