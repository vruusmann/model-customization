package org.jpmml.model;

import org.dmg.pmml.DataType;

public interface HasValue {

	/**
	 * @param dataType The data type into which the underlying string representation of the value should be parsed into.
	 */
	Object getValue(DataType dataType);
}