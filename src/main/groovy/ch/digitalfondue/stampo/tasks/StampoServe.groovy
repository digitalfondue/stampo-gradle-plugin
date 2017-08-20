package ch.digitalfondue.stampo.tasks

import ch.digitalfondue.stampo.command.Serve
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

class StampoServe extends DefaultTask {
    @InputDirectory
    File srcDir = project.file("${project.rootDir}/src/main/stampo")

    @Input
    String hostname = "localhost"

    @Input
    int port = 8080

    @Input
    boolean disableRebuildOnChange = false

    @Input
    boolean disableAutoReload = false

    @Input
    boolean hideDraft = false

    @OutputDirectory
    File outputDir = project.file("${project.buildDir}/stampo")

    @TaskAction
    def serve() {
        Serve serve = new Serve()
        serve.setHideDraft(hideDraft)
        serve.setSrcPath(srcDir.toString())
        serve.setDistPath(outputDir.toString())
        serve.setPort(port)
        serve.setHostname(hostname)
        serve.setDisableAutoReload(disableAutoReload)
        serve.setDisableRebuildOnChange(disableRebuildOnChange)
        serve.setBlockingOnStart(true)

        serve.run()
    }
}
