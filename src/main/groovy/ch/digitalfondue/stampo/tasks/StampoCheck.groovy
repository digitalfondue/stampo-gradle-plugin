package ch.digitalfondue.stampo.tasks

import ch.digitalfondue.stampo.command.Check
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

class StampoCheck extends DefaultTask {
    @InputDirectory
    File srcDir = project.file("${project.rootDir}/src/main/stampo")

    @Input
    boolean hideDraft = false

    @OutputDirectory
    File outputDir = project.file("${project.buildDir}/stampo")

    @TaskAction
    def check() {
        Check check = new Check()
        check.setHideDraft(hideDraft)
        check.setSrcPath(srcDir.toString())
        check.setDistPath(outputDir.toString())
        check.run()
    }
}
