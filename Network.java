public class Network {
    public Level[] levels;

    public Network(int[] n) {
        levels = new Level[n.length - 1];
        for (int i = 1; i < n.length; i++) {
            levels[i - 1] = new Level(n[i - 1], n[i]);
        }
    }
}

class Level {
    Neuron[] inputs;
    Neuron[] outputs;

    Level(int ni, int no) {
        inputs = new Neuron[ni];
        outputs = new Neuron[no];

        for (int i = 0; i < ni; i++) {
            for (int j = 0; j < no; j++) {
                inputs[i].weights[no] = Math.random();
            }
        }
    }
}

class Neuron {
    double bias;
    double value;
    double[] weights;
}