package com.csu.library.mvc.helpers;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.InvalidPropertyException;

public class Helper {

	public static void copyBeanProperties(final Object beanA, final Object beanB){

	    final BeanWrapper wrapperA = new BeanWrapperImpl(beanA);
	    final BeanWrapper wrapperB = new BeanWrapperImpl(beanB);

	    try{
	        for(final PropertyDescriptor descriptor : wrapperB
	            .getPropertyDescriptors()){

	            final String propertyName = descriptor.getName();
	            if(!wrapperA.isReadableProperty(propertyName) || !wrapperB.isReadableProperty(propertyName))
	            	continue;
	            if(wrapperB.getPropertyValue(propertyName) == null){
	                wrapperB.setPropertyValue(propertyName,
	                    wrapperA.getPropertyValue(propertyName));
	            }
	        }
	    } catch(final InvalidPropertyException e){
	        throw new IllegalArgumentException("Incompatible types: " + beanA
	            + ", " + beanB, e);
	    }
	}
}
