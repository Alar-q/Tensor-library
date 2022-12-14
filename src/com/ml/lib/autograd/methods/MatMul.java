package com.ml.lib.autograd.methods;

import com.ml.lib.tensor.Tensor;
import com.ml.lib.autograd.OperationGrad;

import java.util.Arrays;

import static com.ml.lib.core.Core.dot;
import static com.ml.lib.core.Core.tr;

public class MatMul implements OperationGrad {
    @Override
    public Tensor _forward_(Tensor tensor, Tensor other) {
        return dot(tensor, other);
    }

    @Override
    public void _backward_(Tensor grad, Tensor[] depends_on) {
        depends_on[0].getAutoGrad()._backward_(dot(grad, tr(depends_on[1])));
        depends_on[1].getAutoGrad()._backward_(tr(dot(tr(grad), depends_on[0])));
    }
}
