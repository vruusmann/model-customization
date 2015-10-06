package org.jpmml.model;

import org.dmg.pmml.DataType;
import org.dmg.pmml.OpType;
import org.jpmml.evaluator.FieldValue;

public interface HasValue {

	/**
	 * @param dataType
	 * @param opType
	 *
	 * @return A {@link FieldValue} instance that represents the underlying string value.
	 */
	FieldValue getValue(DataType dataType, OpType opType);
}