package com.rapidminer.extension.anomaly_detection.model;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.Attributes;
import com.rapidminer.example.Example;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.example.table.AttributeFactory;
import com.rapidminer.operator.AbstractModel;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.tools.Ontology;


public abstract class AnomalyDetectionModel extends AbstractModel {

	protected AnomalyDetectionModel(ExampleSet exampleSet) {
		super(exampleSet);
	}



	@Override
	public ExampleSet apply(ExampleSet testSet) throws OperatorException {
		Attribute scoreAttribute = addAnomalyAttribute(testSet);
		double[] scores = evaluate(testSet);
		int i = 0;
		for(Example e : testSet){
			e.setValue(scoreAttribute,scores[i]);
			i++;
		}
		return testSet;
	}

	public abstract void train(ExampleSet trainSet) throws OperatorException;

	public abstract double[] evaluate(ExampleSet testSet) throws OperatorException;

	public Attribute addAnomalyAttribute(ExampleSet exampleSet) {
		Attribute anomalyScore = AttributeFactory.createAttribute(
				Attributes.OUTLIER_NAME, Ontology.REAL);
		exampleSet.getExampleTable().addAttribute(anomalyScore);
		exampleSet.getAttributes().setOutlier(anomalyScore);
		return anomalyScore;
	}
}
