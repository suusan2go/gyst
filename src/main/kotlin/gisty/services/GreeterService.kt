package gisty.services

import gisty.grpc.GreeterOuterClass
import io.grpc.stub.StreamObserver
import gisty.grpc.GreeterGrpc
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class GreeterService : GreeterGrpc.GreeterImplBase() {
    override fun sayHello(request: GreeterOuterClass.HelloRequest, responseObserver: StreamObserver<GreeterOuterClass.HelloReply>) {
        val replyBuilder = GreeterOuterClass.HelloReply.newBuilder().setMessage("Hello " + request.name)
        responseObserver.onNext(replyBuilder.build())
        responseObserver.onCompleted()
    }
}