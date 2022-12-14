package sheet.lesson_observer.operations;

import com.ml.lib.tensor.Tensor;
import sheet.lesson_observer.intefaces.Operation;

import static com.ml.lib.tensor.Tensor.tensor;

public class Plus implements Operation {
    private float v;

    public Plus(float v){
        this.v = v;
    }

    @Override
    public Tensor operation(Tensor t) {
        double value = t.getScalar() + v;
//        return new Tensor().setScalar(value);
        return tensor(value);
    }
}
