# Nightly Modding
Updated all necessary infrastructure to ``Nightly 2025-09-03``

**Example Mod**
- <https://github.com/bigsir24/bta-example-mod/tree/nightly>

## Updating 7.3 project to nightly 2025-09-03

### build.gradle.kts
Replace in ``loom{}``
```kts
customMinecraftMetadata.set("https://downloads.betterthanadventure.net/bta-client/$bta_channel/$bta_version/manifest.json")
```
___
Add to ``repositories{}``
```kotlin
ivy {
    url = uri("https://github.com/bigsir24")
    patternLayout {
        artifact("[module]/releases/download/[revision]/[module]-[revision].jar")
    }
    metadataSources { artifact() }
}
ivy {
    url = uri("https://github.com/bigsir24")
    patternLayout {
        artifact("ModMenu/releases/download/[revision]/[module]-bta-[revision].jar")
    }
    metadataSources { artifact() }
}
ivy {
    url = uri("https://github.com/bigsir24")
    patternLayout {
        artifact("bta-[module]/releases/download/[revision]/[module]-[revision].jar")
    }
    metadataSources { artifact() }
}
```
___
Add to ``dependencies{}`` (don't forget to remove their non-nightly counterparts)
```kts
modImplementation("com.github.bigsir24:fabric-loader:$loader_version")
modImplementation("com.github.bigsir24:halplibe:$halplibe_version")
modImplementation("com.github.bigsir24:modmenu:$mod_menu_version")
```
___
Replace in ``java{}``
```kts
sourceCompatibility = JavaVersion.VERSION_17
targetCompatibility = JavaVersion.VERSION_17
```
___
Replace in ``tasks.compileJava{}``
```kts
options.release.set(17)
```
___
Add to ``configurations.configureEach{}``
```kts
exclude(group = "net.fabricmc", module = "fabric-loader")
```
___
### gradle.properties
```properties
bta_version=2025-09-03
bta_channel=nightly

# Loader
loader_version=0.15.6-bta.8

# Other Mods
mod_menu_version=3.0.0+nightly.2025-09-03
halplibe_version=6.0.0+nightly.2025-09-03
```
___
### mod.mixins.json
Change ``compatibilityLevel`` to ``"JAVA_17"``
