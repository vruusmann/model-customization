package org.jpmml.model;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;

import org.dmg.pmml.DataType;
import org.dmg.pmml.PMML;
import org.dmg.pmml.PMMLObject;
import org.dmg.pmml.Visitor;
import org.dmg.pmml.VisitorAction;
import org.jpmml.model.visitors.AbstractSimpleVisitor;
import org.xml.sax.InputSource;

public class Main {

	static
	public void main(String... args) throws Exception {
		PMML pmml;

		// Utility class org.jpmml.model.JAXBUtil is hard-wired to use the default object factory org.dmg.pmml.ObjectFactory
		// Since we want to replace it with our own object factory, we need to create the Unmarshaller instance ourselves
		JAXBContext context = JAXBContext.newInstance(CachingObjectFactory.class);

		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty("com.sun.xml.bind.ObjectFactory", new CachingObjectFactory());

		InputStream is = new FileInputStream(args[0]);

		try {
			Source source = ImportFilter.apply(new InputSource(is));

			pmml = (PMML)unmarshaller.unmarshal(source);
		} finally {
			is.close();
		}

		// A visitor that searches for class model objects that implement the target marker interface
		Visitor visitor = new AbstractSimpleVisitor(){

			@Override
			public VisitorAction visit(PMMLObject object){

				if(object instanceof HasValue){
					HasValue hasValue = (HasValue)object;

					System.out.println("Found a cache-enabled PMML class model object: " + object);
					System.out.println("\t" + hasValue.getValue(DataType.DOUBLE));
				}

				return VisitorAction.CONTINUE;
			}
		};

		visitor.applyTo(pmml);
	}
}