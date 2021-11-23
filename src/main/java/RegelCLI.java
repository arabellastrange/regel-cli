import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "rgcli", mixinStandardHelpOptions = true, version = "rgcli 0.1",
        description = "Runs Regel in interactive customized mode")
public class RegelCLI implements Callable<Integer> {
    @Parameters(index = "0", description = "")
    private String runMode;
    @Parameters(index = "1", description = "")
    private String synthMode;
    @Parameters(index = "2", description = "")
    private int processNum;
    @Parameters(index = "3", description = "")
    private int memMax;
    @Parameters(index = "4", description = "")
    private int top;
    @Parameters(index = "5", description = "")
    private int timeout;
    @Parameters(index = "6", description = "")
    private int maxIter;
    @Parameters(index = "7", description = "")
    private int skecthNum;
    @Parameters(index = "8", description = "")
    private Boolean saveHistory;

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
