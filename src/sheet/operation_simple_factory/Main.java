package sheet.operation_simple_factory;

import com.ml.lib.interfaces.Operation;
import com.ml.lib.tensor.Tensor;

import static com.ml.lib.tensor.Tensor.tensor;

public class Main {
    public static void main(String[] args) {
        OperationFactory factory = new OperationFactory();

        Operation mul = factory.createOperation(OperationTypes.mul);

        Tensor t1 = tensor(new double[]{1, 2, 3});
        Tensor t2 = tensor(new double[]{1, 2, 3});

        Tensor result = mul.apply(t1, t2);

        System.out.println(result);
    }
}
