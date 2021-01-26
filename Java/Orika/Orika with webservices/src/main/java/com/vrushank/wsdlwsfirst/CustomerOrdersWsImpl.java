package com.vrushank.wsdlwsfirst;

import com.vrushank.ws.trainings.*;
import org.apache.cxf.feature.Features;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// here, we need logging, so we'll enable the logging feature by below line
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersWsImpl implements CustomerOrdersPortType {

    /**
     * We're not using any database here, so, we'll hardcode the value
     * for that, we'll create the HashMap, the key will be customerId and value will be list of Order's objects of that customer.
     * you can check the generated interface, the custId is biginteger, so we'll use BigInteger for that.
     */
    Map<BigInteger, List<Order>> customerOrders = new HashMap<>();
    int counter;
    public CustomerOrdersWsImpl() {
        init(); // call of init method to create and initiate the hashmap
    }

    // in the below method, we'll create the List of Order objects to insert it in the above hashmap.
    // So, one customer id will be key, and list of the order will be it's value
    public void init(){
        List<Order> orders = new ArrayList<>();
        // we'll add only one order in this list for example purpose.
        Order order = new Order();
        order.setId(BigInteger.valueOf(1));

        // now we'll create this product object to insert it in the above order object
        Product product = new Product();
        product.setId("1");
        product.setDescription("Iphone");
        product.setQuantity(BigInteger.valueOf(9));

        order.getProduct().add(product); // we added the iphone product in the order

        orders.add(order); // added the order in orders list

        // now we'll add orders in customerOrders hashmap which is our memory instance database.
        customerOrders.put(BigInteger.valueOf(++counter),orders);
    }

    // below overridden method is the method where the order will be requested, so we'll return all the order of requested customerId
    // this request will come with customer id, by customer id, we'll retrive it's orders list and send that list as a response.
    @Override
    public GetOrdersResponse getOrders(GetOrdersRequest request) {
        BigInteger customerId = request.getCustomerId(); // extract the customer ID from request
        List<Order> orders = customerOrders.get(customerId);  //  getting the orders list for requested customerId from hashMap
        GetOrdersResponse response = new GetOrdersResponse();  // created the response object
        response.getOrder().addAll(orders);   // load the response object with the orders list we just got.
        return response;
    }

    // below overridden method is the method where adding the order will be requested.
    // this request will come with customer id and order, so we'll add the order in hash map for provided customerId
    // we'll extract customerId and order from request object, and then we'll add the order to hashmap by key which is customerId.
    @Override
    public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
        BigInteger customerId = request.getCustomerId(); // extract the customerId from request
        Order order = request.getOrder();   // extract the order from request
        List<Order> orders = customerOrders.get(customerId);  // get list of orders for that customer Id
        orders.add(order);   // add the new order

        CreateOrdersResponse response = new CreateOrdersResponse(); // create response object
        response.setResult(true);  //set it to true because transaction is succeed.

        return response;
    }

    // below overridden method is the method where the order will be requested, so we'll delete all the order of requested customerId
    @Override
    public DeleteOrdersResponse deleteOrders(DeleteOrdersRequest request) {
        BigInteger customerId = request.getCustomerId(); // extract the customer ID from request
        List<Order> orders = customerOrders.get(customerId);  //  getting the orders list for requested customerId from hashMap
        orders.clear();
        customerOrders.put(customerId, orders);
        DeleteOrdersResponse response = new DeleteOrdersResponse();  // created the response object
        response.setResult(true);
        return response;
    }
}
