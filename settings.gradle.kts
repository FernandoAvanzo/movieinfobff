rootProject.name = "movieinfobff"

val cachePath = ".gradle/cache"

buildCache {
    local {
        directory = File(rootDir, cachePath)
        removeUnusedEntriesAfterDays = 30
    }
}

include("application:ports")
include("application:adapters")
include("application:shared")
include("application:configuration")
include("application:core")