package ch.digitalfondue.stampo

import ch.digitalfondue.stampo.tasks.StampoBuild
import ch.digitalfondue.stampo.tasks.StampoCheck
import ch.digitalfondue.stampo.tasks.StampoNew
import ch.digitalfondue.stampo.tasks.StampoServe
import org.gradle.api.Plugin
import org.gradle.api.Project

class StampoPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.task("stampoServe", type: StampoServe) {
            group = "StampoPlugin"
            description = "Build and serve the stampo project on a local server"
        }

        project.task("stampoBuild", type: StampoBuild) {
            group = "StampoPlugin"
            description = "Build the local sources and publish on the output directory"
        }

        project.task("stampoCheck", type: StampoCheck) {
            group = "StampoPlugin"
            description = "Check that there are no errors in the source files"
        }

        project.task("stampoNew", type: StampoNew) {
            group = "StampoPlugin"
            description = "Create a new stampo project based on the configured archetype. Available archetypes: basic (default), site, doc, blog"
        }
    }
}