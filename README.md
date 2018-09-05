<h1 align="center">
  <img src="https://forums-cdn.spongepowered.org/uploads/default/original/3X/f/9/f97c66af122e9aed4ef7387b59460778234bd690.png" width="620">
</h1>
<p align="center"><b>Sponge Implementation</b></p>
<p align="center">An extensible AntiCheat plugin for Sponge.</p>

<p align="center">
  <a href="https://travis-ci.org/ichorpowered/guardiansponge"><img alt="Build Status" src="https://travis-ci.org/ichorpowered/guardiansponge.svg?branch=bleeding"></a>
  <a href="https://github.com/SpongePowered/SpongeAPI"><img alt="Sponge Version" src="https://img.shields.io/badge/sponge--api-7.1.0-red.svg"></a>
  <a href="https://ore.spongepowered.org/me4502/Precogs"><img alt="Precogs Version" src="https://img.shields.io/badge/precogs-1.3-red.svg"></a>
  <a href="https://discord.gg/V2PFPkn"><img alt="Join Discord" src="https://img.shields.io/badge/Join-Discord-blue.svg?style=flat-round"></a>
</p>

Guardian is an extensible AntiCheat for Sponge that gives you the flexibility to customize the checks to fit your servers needs.
Guardian also provides a service for [Precogs](https://ore.spongepowered.org/me4502/Precogs) to reduce plugin conflicts with those
who integrate with the lightweight service.

The plugin is a work in progress and there are plans for more detections to be added. Make sure to come chat with us on the
[IchorPowered Discord](https://discord.gg/V2PFPkn).

##### Cheats Detected:

###### Movement:

- [x] Speed    (Movement Speed)
- [x] Flight             (Flight, Movement Speed)
- [x] JetPack            (Flight)
- [ ] Jesus
- [x] Blink              (Movement Speed)
- [ ] Spider / WallClimb
- [x] Timer              (Movement Speed)
- [ ] AutoSneak
- [ ] AutoSprint
- [ ] FastLadder         (Movement Speed)
- [ ] Phase/NoClip
- [ ] MiniJump
- [ ] Glide
- [ ] HighJump / LongJump

And more coming soon.

## Contributing

There many ways to contribute to the project. Some being...

- Creating issues for reporting bugs.
- Creating issues for reporting new cheats that are not detected or new features.
- Contributing to the plugin by making a pull request, which fixes bugs or adds new features.

Developers:

To compile the project. Simply type `gradlew`, this will licenseFormat and build the project
for you.

For code style we prefer to stick with the [Sponge Code Style](https://docs.spongepowered.org/master/en/contributing/implementation/codestyle.html).

If you're unsure about something, don't be afraid to make an issue or join the discord to chat.

## Versioning

The versioning follows:

`guardian-[sponge-major | sponge-minor | sponge-patch]-[guardian-major | guardian-minor | guardian-patch]-[guardian-sub-patch]`

e.g `guardian-7.0.0-0.1.0-01`

Ensure that the SpongeAPI version is the same for the one you are using on your server.

## Credits

 - [me4502](https://github.com/me4502) for making Precogs and spending some of his time and knowledge to improving this AntiCheat, your help is hugely appreciated.

 - [ModularFramework](https://github.com/me4502/ModularFramework) providing a modular class loading system.
 - [Precogs](https://github.com/me4502/Precogs) providing a service for plugins to integrate with the AntiCheat. 

 - Thanks to [SequenceAPI](https://github.com/AbilityAPI/SequenceAPI) for providing the sequence system that powers all of the checks.


