import java.util.Random;

public class Network {
    public int inputSize; // Tamaño de la capa de entrada
    public int hiddenSize; // Tamaño de la capa oculta
    public int outputSize; // Tamaño de la capa de salida

    private double[][] inputHiddenWeights; // Pesos entre la capa de entrada y la capa oculta
    private double[][] hiddenOutputWeights; // Pesos entre la capa oculta y la capa de salida

    public Network(int inputSize, int hiddenSize, int outputSize) {
        this.inputSize = inputSize;
        this.hiddenSize = hiddenSize;
        this.outputSize = outputSize;

        // Inicialización de pesos con valores aleatorios
        inputHiddenWeights = new double[inputSize][hiddenSize];
        hiddenOutputWeights = new double[hiddenSize][outputSize];
        Random rand = new Random();

        for (int i = 0; i < inputSize; i++) {
            for (int j = 0; j < hiddenSize; j++) {
                inputHiddenWeights[i][j] = rand.nextDouble();
            }
        }

        for (int i = 0; i < hiddenSize; i++) {
            for (int j = 0; j < outputSize; j++) {
                hiddenOutputWeights[i][j] = rand.nextDouble();
            }
        }
    }

    // Función de activación (puede ser una función sigmoide u otra)
    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x)) - 1 / 2;
    }

    public double[] predict(double[] inputs) {
        if (inputs.length != inputSize) {
            throw new IllegalArgumentException("Tamaño de entrada incorrecto");
        }

        // Calcular salidas de la capa oculta
        double[] hiddenLayerOutputs = new double[hiddenSize];
        for (int i = 0; i < hiddenSize; i++) {
            double sum = 0;
            for (int j = 0; j < inputSize; j++) {
                sum += inputs[j] * inputHiddenWeights[j][i];
            }
            hiddenLayerOutputs[i] = sigmoid(sum);
        }

        // Calcular salidas de la capa de salida
        double[] outputLayerOutputs = new double[outputSize];
        for (int i = 0; i < outputSize; i++) {
            double sum = 0;
            for (int j = 0; j < hiddenSize; j++) {
                sum += hiddenLayerOutputs[j] * hiddenOutputWeights[j][i];
            }
            outputLayerOutputs[i] = sigmoid(sum);
        }

        return outputLayerOutputs;
    }
}