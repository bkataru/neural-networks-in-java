package com.company;
import org.neuroph.core.*;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    NeuralNetwork neuralNetwork = new Perceptron(2, 1);

        DataSet trainingSet = new DataSet(2, 1);
        trainingSet.addRow(new DataSetRow(new double[]{0, 0}, new double[]{0}));
        trainingSet.addRow(new DataSetRow(new double[]{0, 1}, new double[]{1}));
        trainingSet.addRow(new DataSetRow(new double[]{1, 0}, new double[]{1}));
        trainingSet.addRow(new DataSetRow(new double[]{1, 1}, new double[]{1}));

        neuralNetwork.learn(trainingSet);
        neuralNetwork.save("or_perceptron.nnet");

        neuralNetwork.setInput(0, 0);
        neuralNetwork.calculate();

        double [] networkOutput = neuralNetwork.getOutput();
        System.out.println(Arrays.toString(networkOutput));
    }
}
