package ch.digitalfondue.stampo.tasks

import ch.digitalfondue.stampo.command.Build
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

class StampoBuild extends DefaultTask {
    @InputDirectory
    File srcDir = project.file("${project.rootDir}/src/main/stampo")

    @Input
    boolean hideDraft = false

    @OutputDirectory
    File outputDir = project.file("${project.buildDir}/stampo")

    @TaskAction
    def build() {
        Build build = new Build()
        build.setHideDraft(hideDraft)
        build.setSrcPath(srcDir.toString())
        build.setDistPath(outputDir.toString())
        build.run()
    }
}
