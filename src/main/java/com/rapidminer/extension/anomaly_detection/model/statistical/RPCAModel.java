package com.rapidminer.extension.anomaly_detection.model.statistical;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.extension.anomaly_detection.model.AnomalyDetectionModel;
import com.rapidminer.operator.OperatorException;


public class RPCAModel extends AnomalyDetectionModel {
	protected RPCAModel(ExampleSet exampleSet) {
		super(exampleSet);
	}

	@Override
	public void train(ExampleSet trainSet) {

	}

	@Override
	public double[] evaluate(ExampleSet testSet) throws OperatorException {
		return new double[0];
	}
}
