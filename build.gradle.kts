import net.minecrell.pluginyml.bukkit.BukkitPluginDescription
import net.minecrell.pluginyml.paper.PaperPluginDescription

plugins {
    java
    alias(libs.plugins.pluginYmlPaper)
}

group = "me.twoleggedcat"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
	mavenLocal()
	mavenCentral()
	maven {
		url = uri("https://repo.papermc.io/repository/maven-public/")
	}
}

dependencies {
	compileOnly(libs.paperApi)
}

paper {
    main = "me.twoleggedcat.bettercats.Main"
    apiVersion = libs.versions.paperApi.get().replace(Regex("\\-R\\d.\\d-SNAPSHOT"), "")
    authors = listOf("Jim (AnEnragedPigeon)", "TwoLeggedCat")
    description = "Cat behaviour enhancements"
}

tasks {
    compileJava {
        options.compilerArgs.addAll(listOf("-Xlint:all", "-Xlint:-processing"))
        options.encoding = "UTF-8"
    }
}
