package com.ml.lib.autograd;

import com.ml.lib.tensor.Tensor;

public interface OperationGrad {
    /**
     * Не должны изменять аргументы метода
     * Должны вернуть какой-то новый тензор.
     * @param other may be null.
     * */
    Tensor _forward_(Tensor tensor, Tensor other);

    /**
     * Должны передать в состовляющие Тензоры какой-то градиент.
     * @depends_on 1 <= depends_on.length <= 2.
     * */
    void _backward_(Tensor grad, Tensor[] depends_on);
}
