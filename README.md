# stampo-gradle-plugin
gradle plugin for [Stampo](https://github.com/digitalfondue/stampo), static website generator

## Tasks

### gradle stampoBuild
build the website and publish it to the output directory

### gradle stampoCheck
check that there are no errors in the source files

### gradle stampoServe
build the website and make it available on a given local address

### gradle stampoNew [-Parchetype=basic|site|blog|doc]
generate a basic template of the chosen archetype in srcDir

## Configuration parameters

###### srcDir (default=${project.rootDir}/src/main/stampo)

location of the source stampo project

###### outputDir (default=${project.buildDir}/stampo)

location where to publish the generated stampo project

###### archetype (default=basic)

define which template to use when generating a basic stampo project.

Allowed values:
* basic: a simple index page
* site: a multilanguage site with paginated news
* blog: a multilanguage blog with pagination and tags support
* doc: a documentation website with table of contents and a choice of both multipage and single page layout.

###### hostname (default=localhost)

hostname for the serve goal

###### port (default=8080)

port for the serve goal

###### disableAutoReload (default=false)

disable auto reload of the source project

###### disableRebuildOnChange (default=false)

disable rebuild the source project when there are changes

###### hideDraft (default=false)

hide or show content marked with "draft: true" metadata

## Example configuration

```Groovy
stampoServe {
    port = 8843
}
```