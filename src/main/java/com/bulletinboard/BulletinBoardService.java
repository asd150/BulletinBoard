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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
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
       //given a title ... return the body
        String titleGiven  = request.getConfirmation();
        int indexFound = 0;
        for(int i=0;i<lists.size();i++){
            if(lists.get(i).getTitle().equals(titleGiven)){
                indexFound = i;
                break;
            }
        }
        responseObserver.onNext(msg.newBuilder().setTitle(lists.get(indexFound).getTitle()).setBody(lists.get(indexFound).getBody()).build());
        responseObserver.onCompleted();

    }

    @Override
    public void list(confirm request, StreamObserver<msg> responseObserver) {
        System.out.println(lists.size() + " list");
        if(lists.size()==0){
            responseObserver.onNext(msg.newBuilder().setTitle("No Posts").setTitle("Please post on the board").build());
            responseObserver.onCompleted();
        }
        else{
            System.out.println("LOOP1 ");
            for(int i=0;i<lists.size();i++){
                System.out.println("LOOP2 ");
                responseObserver.onNext(msg.newBuilder().setTitle(lists.get(i).getTitle()).setBody(lists.get(i).getBody()).build());
            }
            responseObserver.onCompleted();
        }
    }

    @Override
    public void delete(confirm request, StreamObserver<confirm> responseObserver) {
        String toDelete = request.getConfirmation();
        for(int i=0;i<lists.size();i++){
            if(lists.get(i).getTitle().equals(toDelete)){
                lists.remove(i);
            }
        }
        responseObserver.onNext(confirm.newBuilder().setConfirmation("Deleted " + toDelete).build());
        responseObserver.onCompleted();
    }
}
