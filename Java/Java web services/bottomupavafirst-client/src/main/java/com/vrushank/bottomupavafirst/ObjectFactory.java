
package com.vrushank.bottomupavafirst;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.vrushank.bottomupavafirst package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProcessPayment_QNAME = new QName("http://bottomupavafirst.vrushank.com/", "processPayment");
    private final static QName _ProcessPaymentResponse_QNAME = new QName("http://bottomupavafirst.vrushank.com/", "processPaymentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.vrushank.bottomupavafirst
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProcessPaymentResponse }
     * 
     */
    public ProcessPaymentResponse createProcessPaymentResponse() {
        return new ProcessPaymentResponse();
    }

    /**
     * Create an instance of {@link PaymentProcessorResponse }
     * 
     */
    public PaymentProcessorResponse createPaymentProcessorResponse() {
        return new PaymentProcessorResponse();
    }

    /**
     * Create an instance of {@link CreditCardInfo }
     * 
     */
    public CreditCardInfo createCreditCardInfo() {
        return new CreditCardInfo();
    }

    /**
     * Create an instance of {@link ProcessPayment }
     * 
     */
    public ProcessPayment createProcessPayment() {
        return new ProcessPayment();
    }

    /**
     * Create an instance of {@link PaymentProcessorRequest }
     * 
     */
    public PaymentProcessorRequest createPaymentProcessorRequest() {
        return new PaymentProcessorRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bottomupavafirst.vrushank.com/", name = "processPayment")
    public JAXBElement<ProcessPayment> createProcessPayment(ProcessPayment value) {
        return new JAXBElement<ProcessPayment>(_ProcessPayment_QNAME, ProcessPayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessPaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bottomupavafirst.vrushank.com/", name = "processPaymentResponse")
    public JAXBElement<ProcessPaymentResponse> createProcessPaymentResponse(ProcessPaymentResponse value) {
        return new JAXBElement<ProcessPaymentResponse>(_ProcessPaymentResponse_QNAME, ProcessPaymentResponse.class, null, value);
    }

}
