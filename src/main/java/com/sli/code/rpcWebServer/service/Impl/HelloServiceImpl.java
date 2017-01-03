package com.sli.code.rpcWebServer.service.Impl;

import com.sli.code.rpc.Components.provider.RpcService;
import com.sli.code.rpcWebServer.service.Intef.HelloService;
import com.sli.code.rpcWebServer.service.Intef.Person;

@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello! " + name;
    }

    @Override
    public String hello(Person person) {
        return "Hello! " + person.getFirstName() + " " + person.getLastName();
    }
}
