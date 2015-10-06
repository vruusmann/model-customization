package org.jpmml.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.dmg.pmml.DataType;
import org.dmg.pmml.SimplePredicate;
import org.jpmml.evaluator.TypeUtil;

@XmlRootElement (
	name = "SimplePredicate"
)
public class CachingSimplePredicate extends SimplePredicate implements HasValue {

	private Object parsedValue = null;


	@Override
	public Object getValue(DataType dataType){

		if(this.parsedValue == null){
			this.parsedValue = TypeUtil.parseOrCast(dataType, getValue());
		}

		return this.parsedValue;
	}
}