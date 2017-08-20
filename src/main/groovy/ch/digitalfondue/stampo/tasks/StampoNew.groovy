package ch.digitalfondue.stampo.tasks

import ch.digitalfondue.stampo.command.New
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.TaskAction

class StampoNew extends DefaultTask {
    @InputDirectory
    File srcDir = project.file("${project.rootDir}/src/main/stampo")

    @Input
    String archetype = "basic"

    @TaskAction
    def create() {
        New n = new New()
        n.setArchetype(archetype)
        n.setSrcPath(srcDir.toString())
        n.run()
    }
}
