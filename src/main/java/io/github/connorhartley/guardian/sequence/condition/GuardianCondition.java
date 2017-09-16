/*
 * MIT License
 *
 * Copyright (c) 2017 Connor Hartley
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.connorhartley.guardian.sequence.condition;

import com.ichorpowered.guardian.api.detection.DetectionConfiguration;
import com.ichorpowered.guardian.api.sequence.condition.Condition;
import com.ichorpowered.guardian.api.sequence.condition.ConditionSupplier;

import javax.annotation.Nonnull;

public class GuardianCondition<K, L extends DetectionConfiguration, M> implements Condition<M> {

    private final ConditionSupplier condition;
    private final Type type;

    @Nonnull
    public static <A, B extends DetectionConfiguration, C> GuardianCondition<A, B, C> of(
            @Nonnull ConditionSupplier<A, B, C> condition, @Nonnull Type type) {
        return new GuardianCondition<>(condition, type);
    }

    private GuardianCondition(@Nonnull ConditionSupplier<K, L, M> condition, @Nonnull Type type) {
        this.condition = condition;
        this.type = type;
    }

    @Nonnull
    @Override
    @SuppressWarnings("unchecked")
    public <E, F extends DetectionConfiguration> ConditionSupplier<E, F, M> get() {
        return (ConditionSupplier<E, F, M>) this.condition;
    }

    @Nonnull
    @Override
    public Type getType() {
        return this.type;
    }

}
