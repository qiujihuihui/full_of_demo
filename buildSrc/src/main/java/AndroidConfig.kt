/**
 * default config of project
 * @author  Shenhui
 * @version 1.0
 * @since   2021/4/9  15:03
 */

object AndroidConfig {
    val compileSdkVersion = 29
    val buildToolsVersion = "29.0.3"
    val defaultConfig = DefaultConfig()

    class DefaultConfig {
        val applicationId = "com.full.demo"
        val minSdkVersion = 19
        val targetSdkVersion = 29
        val versionCode = 1
        val versionName = "1.0"
    }
}