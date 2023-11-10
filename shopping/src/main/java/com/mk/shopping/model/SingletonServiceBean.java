package com.mk.shopping.model; 
 
public class SingletonServiceBean {

    private static int instancesCreated = 0;

    //This constructor will be called everytime a new bean instance is created
    public SingletonServiceBean(){
        instancesCreated++;
    }

    public static int getInstancesCreated(){
        return SingletonServiceBean.instancesCreated;
    }


}