import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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

//    @Parameters(index = "0", description = "A file name for your benchmark", interactive = true)
//    private String benchmarkName;
//    @Parameters(index = "1", description = "A natural language description of your problem", interactive = true)
//    private String natLang;
//    @Parameters(index = "2", description = "Positive and negative examples of your pattern", interactive = true)
//    private String examples;


    @Override
    public String call() throws Exception {
        System.out.println("Enter filename below. Press 'Enter' to quit and save the results.");
        Scanner s = new Scanner(System.in);
        String benchmarkName = s.nextLine().trim();

        String benchmarkPath = "exp/customize/benchmark/" + benchmarkName;
        String sketchPath = "exp/customize/sketch/" + benchmarkName;

        Map<String, String> examples = new HashMap<>();

        System.out.println("Enter examples below. Press 'Enter' if finish.");
        String example = s.nextLine().trim();
        System.out.println("+ or - (enter '+' for positive example, '-' for negative one) ?");
        String sign = s.nextLine().trim();

        examples.put(example, sign);


        System.out.println("generating sketches...");
        // todo call python code

        // todo save examples to benchmark in path
        // todo reformat example
        // todo test benchmark

        String output = "";
        writeOutput(output.getBytes(StandardCharsets.UTF_8));

        return "done";
    }

    private void writeOutput(byte[] bytes) throws IOException {
        String outputPath = "interactive/customize/logs/" + synthMode + "/raw_output.csv";
        FileOutputStream outputStream = new FileOutputStream(outputPath);
        outputStream.write(bytes);
        outputStream.close();
    }
}
