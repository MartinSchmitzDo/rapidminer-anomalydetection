package com.rapidminer.extension.anomaly_detection.operator;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorCapability;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.clustering.ClusterModel;
import com.rapidminer.operator.learner.CapabilityProvider;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.tools.OperatorService;

public abstract class AbstractAnomalyOperator extends Operator implements CapabilityProvider {
    protected InputPort exaInput = getInputPorts().createPort("exa", ExampleSet.class);

    protected OutputPort exaOutput = getOutputPorts().createPort("exa");
    protected OutputPort modOutput = getOutputPorts().createPort("mod");

    public AbstractAnomalyOperator(OperatorDescription description) {
        super(description);
    }

    @Override
    public boolean supportsCapability(OperatorCapability capability) {
        switch (capability) {
            case NUMERICAL_LABEL:
            case NUMERICAL_ATTRIBUTES:
            case ONE_CLASS_LABEL:
            case NO_LABEL:
            case POLYNOMINAL_LABEL:
            case BINOMINAL_LABEL:
                return true;
            default:
                return false;
        }
    }
}
