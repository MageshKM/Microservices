package com.mk.shopping.model;
 
public class PrototypeServiceBean {

    private static int instancesCreated = 0;

    //This constructor will be called everytime a new bean instance is created
    public PrototypeServiceBean(){
        instancesCreated++;
    }

    public static int getInstancesCreated(){
        return PrototypeServiceBean.instancesCreated;
    }


}
