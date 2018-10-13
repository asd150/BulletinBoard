package com.bulletinboard;

import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;
class object{
    private String title;
    private String body;
    object(String title,String body){
        this.title = title;
        this.body = body;
    }
}
public class BulletinBoardService extends BulletinBoardSGrpc.BulletinBoardSImplBase {
    //@Override
//    public void post(msg request, StreamObserver<confirm> responseObserver) {
//        responseObserver.onNext(confirm.newBuilder().setConfirmation("hello").build());
//        responseObserver.onNext(confirm.newBuilder().setConfirmation("222222").build());
//        responseObserver.onCompleted();
//    }

    //Global arraylist for storing all messages
    List<object> lists = new ArrayList<object>();

    @Override
    public void post(msg request, StreamObserver<confirm> responseObserver) {
        object newMsg  = new object(request.getTitle(),request.getBody());
        lists.add(newMsg);
        responseObserver.onNext(confirm.newBuilder().setConfirmation("Notice Posted").build());
        responseObserver.onCompleted();
    }

    @Override
    public void get(confirm request, StreamObserver<msg> responseObserver) {
        super.get(request, responseObserver);
    }

    @Override
    public void list(confirm request, StreamObserver<msg> responseObserver) {
        super.list(request, responseObserver);
    }

    @Override
    public void delete(confirm request, StreamObserver<confirm> responseObserver) {
        super.delete(request, responseObserver);
    }
}
