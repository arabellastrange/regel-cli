import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "rgcli", mixinStandardHelpOptions = true, version = "rgcli 0.1",
        description = "Runs Regel in interactive customized mode")
public class RegelCLI implements Callable<String> {
    @Option(names = {"--run_mode"}, description = "run_mode = 1 if run benchmarks, 0 otherwise")
    private String runMode = "0";
    @Option(names = {"--synth_mode"}, description = "run_mode = 1 if uses sketch, run_mode = 5 if not use sketch")
    private String synthMode = "1";
    @Option(names = {"--process_num"}, description = "")
    private int processNum = 5;
    @Option(names = {"--mem_max"}, description = "")
    private int memMax = 20;
    @Option(names = {"--top"}, description = "")
    private int top = 5;
    @Option(names = {"--timeout"}, description = "")
    private int timeout = 60;
    @Option(names = {"--max_iter"}, description = "")
    private int maxIter = 5;
    @Option(names = {"--skecth_num"}, description = "")
    private int skecthNum = 25;
    @Option(names = {"--save_history"}, description = "")
    private Boolean saveHistory = false;

    @Parameters(index = "0", description = "A file name for your benchmark", interactive = true)
    private String benchmarkPath;
    @Parameters(index = "1", description = "A natural language description of your problem", interactive = true)
    private String natLang;
    @Parameters(index = "2", description = "Positive and negative examples of your pattern", interactive = true)
    private String examples;


    @Override
    public String call() throws Exception {
        return "done";
    }
}
