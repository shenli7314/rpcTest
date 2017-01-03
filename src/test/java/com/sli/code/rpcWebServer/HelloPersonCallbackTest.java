package com.sli.code.rpcWebServer;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.sli.code.rpc.Components.customer.AsyncRPCCallback;
import com.sli.code.rpc.Components.customer.RPCFuture;
import com.sli.code.rpc.Components.customer.RpcClient;
import com.sli.code.rpc.Components.customer.proxy.IAsyncObjectProxy;
import com.sli.code.rpcWebServer.service.Intef.HelloPersonService;
import com.sli.code.rpcWebServer.service.Intef.Person;

public class HelloPersonCallbackTest {
    public static void main(String[] args) {
        final RpcClient rpcClient = RpcClient.getInstance();
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {
            IAsyncObjectProxy client = rpcClient.createAsync(HelloPersonService.class);
            int num = 5;
            RPCFuture helloPersonFuture = client.call("GetTestPerson", "xiaoming", num);
            helloPersonFuture.addCallback(new AsyncRPCCallback() {
                @Override
                public void success(Object result) {
                    List<Person> persons = (List<Person>) result;
                    for (int i = 0; i < persons.size(); ++i) {
                        System.out.println(persons.get(i));
                    }
                    countDownLatch.countDown();
                }

                @Override
                public void fail(Exception e) {
                    System.out.println(e);
                    countDownLatch.countDown();
                }
            });

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        rpcClient.stop();

        System.out.println("End");
    }
}
