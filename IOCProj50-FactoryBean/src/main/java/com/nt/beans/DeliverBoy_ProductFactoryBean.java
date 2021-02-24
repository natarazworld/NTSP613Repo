package com.nt.beans;


import org.springframework.beans.factory.FactoryBean;

public class DeliverBoy_ProductFactoryBean implements FactoryBean<Product> {
	private String prodType;
	
	public DeliverBoy_ProductFactoryBean(String prodType) {
		System.out.println("DeliverBoy_ProductFactoryBean:: 1-param constructor");
		this.prodType=prodType;
	}

	@Override
	public Product getObject() throws Exception {
		System.out.println("DeliverBoy_ProductFactoryBean.getObject()");
	   if(prodType.equalsIgnoreCase("eletronic")) {
            	EletronicProduct  eprod=new EletronicProduct("110v","5*");
            	eprod.setPid(1001); eprod.setPname("TV");
            	return eprod;
	   }
	   else if(prodType.equalsIgnoreCase("automobile")) {
		    AutomobileProduct  aprod=new AutomobileProduct("Bus", 1500);
		    aprod.setPid(1002); aprod.setPname("Bus");
		    return aprod;
	   }
	   else {
		   return null;
	   }
	}//method

	@Override
	public Class getObjectType() {
		System.out.println("DeliverBoy_ProductFactoryBean.getObjectType()");
		return Product.class;
	}
	
	@Override
	public boolean isSingleton() {
		System.out.println("DeliverBoy_ProductFactoryBean.isSingleton()");
		return true;
	}

}
