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
package io.github.connorhartley.guardian;

import io.github.connorhartley.guardian.context.ContextController;
import io.github.connorhartley.guardian.context.ContextTypes;
import io.github.connorhartley.guardian.internal.contexts.environment.block.BlockSpeedContext;
import io.github.connorhartley.guardian.internal.contexts.user.control.PlayerControlContext;
import io.github.connorhartley.guardian.internal.contexts.user.control.PlayerControlSpeedContext;

public class GuardianContexts {

    private final ContextController contextController;

    GuardianContexts(ContextController contextController) {
        this.contextController = contextController;
    }

    void registerInternalContexts() {
        this.contextController.registerContext(ContextTypes.BLOCK_SPEED, BlockSpeedContext.class);
        this.contextController.registerContext(ContextTypes.PLAYER_CONTROL, PlayerControlContext.class);
        this.contextController.registerContext(ContextTypes.PLAYER_CONTROL_SPEED, PlayerControlSpeedContext.class);
    }

}