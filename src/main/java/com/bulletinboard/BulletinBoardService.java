package com.bulletinboard;

import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class BulletinBoardService extends BulletinBoardvGrpc.BulletinBoardvImplBase {

    @Override
    public void sendNotice(object request, StreamObserver<confirmation> responseObserver) {
        super.sendNotice(request, responseObserver);
    }

    @Override
    public void getAllNotice(value request, StreamObserver<object> responseObserver) {
        super.getAllNotice(request, responseObserver);
    }

    @Override
    public void getNotice(topic request, StreamObserver<value> responseObserver) {
        super.getNotice(request, responseObserver);
    }

    @Override
    public void deleteTopic(topic request, StreamObserver<value> responseObserver) {
        super.deleteTopic(request, responseObserver);
    }
}
