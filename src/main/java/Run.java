import picocli.CommandLine;

public class Run {
    public static void main(String... args) {
        int exitCode = new CommandLine(new RegelCLI()).execute(args);
        System.exit(exitCode);
    }
}
