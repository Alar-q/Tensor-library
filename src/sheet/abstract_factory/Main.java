package sheet.abstract_factory;


import com.ml.lib.Core;
import com.ml.lib.autograd.AutoGrad;
import com.ml.lib.interfaces.Operation;
import com.ml.lib.tensor.Tensor;
import sheet.operation_simple_factory.OperationTypes;

import static com.ml.lib.Core.tensor;

public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new GradFactory();

        Operation matmul = factory.createOperation(OperationTypes.matmul);

        Tensor a = Core.tensor(new float[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        Tensor b = Core.tensor(new float[][]{
                {2, 3},
                {4, 5},
                {6, 7}
        });

        Tensor c = matmul.apply(a, b);
        System.out.println(c);

        c._backward_();

        System.out.println("c_der:"  + c.getGrad());
        System.out.println("a_der:"  + a.getGrad());
        System.out.println("b_der:"  + b.getGrad());
    }
}