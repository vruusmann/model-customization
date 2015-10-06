package org.jpmml.model;

import org.dmg.pmml.DataType;
import org.dmg.pmml.OpType;
import org.dmg.pmml.SimplePredicate;
import org.jpmml.evaluator.FieldValue;
import org.jpmml.evaluator.FieldValueUtil;

public class CachingSimplePredicate extends SimplePredicate implements HasValue {

	private FieldValue parsedValue = null;


	/**
	 * @see SimplePredicate#getValue()
	 */
	@Override
	public FieldValue getValue(DataType dataType, OpType opType){

		if(this.parsedValue == null){
			this.parsedValue = FieldValueUtil.create(dataType, opType, getValue());
		}

		return this.parsedValue;
	}
}