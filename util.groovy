/**
 * 执行指定命令并在给定目录中运行
 *
 * @param command 要执行的 shell 命令
 * @param dirPath 工作目录的路径
 */
def execInDir(String command, String dirPath) {
    println "📂 Working directory: ${dirPath}"
    println "▶️ Executing: ${command}"

    def proc = ["bash", "-c", command].execute(null, new File(dirPath))
    def stdout = new StringBuilder()
    def stderr = new StringBuilder()

    proc.waitForProcessOutput(stdout, stderr)
    
    println "✅ Exit code: ${proc.exitValue()}"
    if (stdout) {
        println "📤 Output:\n${stdout.toString().trim()}"
    }
    if (stderr) {
        println "❗ Error:\n${stderr.toString().trim()}"
    }
}