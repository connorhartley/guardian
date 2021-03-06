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
package com.ichorpowered.guardian.sponge.sequence.action.observe;

import com.google.common.collect.Lists;
import com.ichorpowered.guardian.api.sequence.action.observe.ObserverAction;
import com.ichorpowered.guardian.api.sequence.process.Process;
import com.ichorpowered.guardian.api.sequence.process.ProcessResult;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.event.Event;

import java.util.List;
import java.util.function.Function;

public class ObserverActionImpl<T extends Event> implements ObserverAction<T> {

    private final Class<T> eventType;
    private final List<Function<Process, ProcessResult>> conditions = Lists.newArrayList();
    private int delay = 0;
    private int expire = 0;

    public ObserverActionImpl(final Class<T> eventType) {
        this.eventType = eventType;
    }

    @Override
    public @NonNull Class<T> getEventType() {
        return this.eventType;
    }

    @Override
    public void addCondition(final @NonNull Function<Process, ProcessResult> function) {
        this.conditions.add(function);
    }

    @Override
    public void setDelay(final int period) {
        this.delay = period;
    }

    @Override
    public int getDelay() {
        return this.delay;
    }

    @Override
    public void setExpire(final int period) {
        this.expire = period;
    }

    @Override
    public int getExpire() {
        return this.expire;
    }

    @Override
    public boolean apply(final @NonNull Process process) {
        return this.conditions.stream()
                .map(condition -> condition.apply(process))
                .allMatch(ProcessResult::toNext);
    }

}
