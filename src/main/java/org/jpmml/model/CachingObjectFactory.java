package org.jpmml.model;

import javax.xml.bind.annotation.XmlRegistry;

import org.dmg.pmml.ObjectFactory;

@XmlRegistry
public class CachingObjectFactory extends ObjectFactory {

	@Override
	public CachingSimplePredicate createSimplePredicate(){
		return new CachingSimplePredicate();
	}
}