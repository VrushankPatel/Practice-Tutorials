package com.vrushank.wsdlwsfirstsoapclient;

import com.vrushank.ws.trainings.*;
import com.vrushank.wsdlwsfirst.CustomerOrdersWsImplService;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CustomerOrderWsClient {
    public static void main(String[] args) throws Exception {
        CustomerOrderWsClient client = new CustomerOrderWsClient();
        client.numberOfOrders(BigInteger.valueOf(1));
        Order order = new Order();
        order.setId(BigInteger.valueOf(2));
        Product element = new Product();
        element.setId("2");
        element.setQuantity(BigInteger.valueOf(230));
        element.setDescription("mac pro desil");
        order.getProduct().add(element);
        client.createOrder(BigInteger.valueOf(1), order);
        client.numberOfOrders(BigInteger.valueOf(1));
        client.deleteOrders(BigInteger.valueOf(1));
        client.numberOfOrders(BigInteger.valueOf(1));
    }
    public void numberOfOrders(BigInteger customerId){
        try {
            CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(
                    new URL("http://localhost:8080/wsdlfirstws/customerorderwservice?wsdl"));
            CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();
            GetOrdersRequest request = new GetOrdersRequest();
            request.setCustomerId(customerId);
            GetOrdersResponse response = customerOrdersWsImplPort.getOrders(request);
            List<Order> orders = response.getOrder();
            System.out.println("number of orders is " + orders.size());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void createOrder(BigInteger customerId, Order order) throws Exception{
        CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(
                new URL("http://localhost:8080/wsdlfirstws/customerorderwservice?wsdl"));
        CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();
        CreateOrdersRequest request = new CreateOrdersRequest();
        request.setCustomerId(customerId);
        request.setOrder(order);
        CreateOrdersResponse response = customerOrdersWsImplPort.createOrders(request);
    }

    public void deleteOrders(BigInteger customerId) throws Exception{
        CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(
                new URL("http://localhost:8080/wsdlfirstws/customerorderwservice?wsdl"));
        CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();
        DeleteOrdersRequest request = new DeleteOrdersRequest();
        request.setCustomerId(customerId);
        DeleteOrdersResponse response = customerOrdersWsImplPort.deleteOrders(request);
    }
}
