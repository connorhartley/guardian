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
package io.github.connorhartley.guardian.detection.check;

import io.github.connorhartley.guardian.detection.Detection;
import io.github.connorhartley.guardian.sequence.Sequence;
import io.github.connorhartley.guardian.sequence.SequenceBlueprint;
import org.spongepowered.api.entity.living.player.User;

/**
 * Check Type
 *
 * Represents a service that checks a player
 * for a specific cheat in a certain way.
 */
public interface CheckType {

    /**
     * Get Detection
     *
     * <p>Returns the {@link Detection} this check type is for.</p>
     *
     * @return The detection
     */
    Detection getDetection();

    /**
     * Get Sequence
     *
     * <p>Returns the {@link SequenceBlueprint} that contains a
     * {@link Sequence} to check the player for a cheat in a
     * certain way.</p>
     *
     * @return The sequence blueprint
     */
    SequenceBlueprint getSequence();

    /**
     * Create Instance
     *
     * <p>Creates a check instance if the sequence is successful.</p>
     *
     * @param user The user
     * @return The check
     */
    Check createInstance(User user);

}
