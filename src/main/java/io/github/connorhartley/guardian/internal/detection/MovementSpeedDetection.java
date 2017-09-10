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
package io.github.connorhartley.guardian.internal.detection;

import com.ichorpowered.guardian.api.detection.DetectionChain;
import com.ichorpowered.guardian.api.detection.DetectionConfiguration;
import com.me4502.modularframework.module.Module;
import com.me4502.modularframework.module.guice.ModuleContainer;
import io.github.connorhartley.guardian.GuardianPlugin;
import io.github.connorhartley.guardian.detection.AbstractDetection;
import io.github.connorhartley.guardian.detection.GuardianDetectionChain;
import io.github.connorhartley.guardian.internal.check.MovementSpeedCheck;
import io.github.connorhartley.guardian.util.HoconLoaderPatch;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import org.spongepowered.api.plugin.PluginContainer;
import tech.ferus.util.config.ConfigFile;
import tech.ferus.util.config.HoconConfigFile;

import java.io.IOException;
import java.nio.file.Path;

import javax.annotation.Nonnull;

@Module(id = "speed",
        name = "Speed Detection",
        authors = { "Connor Hartley (vectrix)" },
        version = "0.1.0",
        onEnable = "onConstruction",
        onDisable = "onDeconstruction"
)
public class MovementSpeedDetection extends AbstractDetection {

    private State state = State.UNDEFINED;
    private DetectionChain detectionChain;
    private VerticalSpeedConfiguration detectionConfiguration;

    public MovementSpeedDetection(@ModuleContainer PluginContainer moduleContainer) {
        super((GuardianPlugin) moduleContainer.getInstance().get(), "movementspeed", "Movement Speed Detection");
    }

    @Override
    public void onConstruction() {
        this.detectionConfiguration = new VerticalSpeedConfiguration(this, this.getOwner().getConfigDirectory());
        this.detectionConfiguration.load();

        this.detectionChain = new GuardianDetectionChain();
        this.detectionChain.add(this.getOwner(), DetectionChain.ProcessType.CHECK, MovementSpeedCheck.Blueprint.class);

        this.initializeDetection();
    }

    @Override
    public void onDeconstruction() {

    }

    @Nonnull
    @Override
    public String getPermission(@Nonnull String permissionTarget) {
        return null;
    }

    @Nonnull
    @Override
    public DetectionConfiguration getConfiguration() {
        return this.detectionConfiguration;
    }

    @Nonnull
    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public DetectionChain getChain() {
        return this.detectionChain;
    }

    public static class VerticalSpeedConfiguration implements DetectionConfiguration {

        private static final String FILE_PATH = "/detection/movementspeed.conf";

        private final MovementSpeedDetection detection;
        private final Path configDir;

        private HoconConfigFile configFile;

        public VerticalSpeedConfiguration(@Nonnull MovementSpeedDetection detection,
                                          @Nonnull Path configDir) {
            this.detection = detection;
            this.configDir = configDir;
        }

        @Override
        public void load() {
            try {
                this.configFile = HoconLoaderPatch.load(this.configDir.resolve(FILE_PATH), FILE_PATH, !this.exists());
            } catch (IOException e) {
                this.detection.getOwner().getLogger().error("A problem occurred attempting to load the " +
                        "guardian vertical speed detection configuration!");
            }
        }

        @Nonnull
        @Override
        public ConfigFile<CommentedConfigurationNode> getStorage() {
            return this.configFile;
        }

        @Nonnull
        @Override
        public Path getLocation() {
            return this.configDir;
        }

        public boolean exists() {
            return this.configDir.resolve(FILE_PATH).toFile().exists();
        }

    }

}