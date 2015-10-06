A toy project that demonstrates the use of custom JAXB object factories

# Prerequisites #

* Java 1.7 or newer

# Installation #

Enter the project root directory and build using [Apache Maven] (http://maven.apache.org/):

```
mvn clean package
```

The build produces an executable uber-JAR file `target/example-1.0-SNAPSHOT.jar`, which contains an executable application class `org.jpmml.model.Main`.

# Usage #

Execute the application by specifing the name of the PMML document as the first argument:

```
java -cp target/example-1.0-SNAPSHOT.jar org.jpmml.model.Main DecisionTreeIris.pmml
```

The application outputs the list of custom class model objects to console.