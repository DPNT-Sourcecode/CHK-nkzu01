package befaster.solutions.HLO;

import befaster.runner.SolutionNotImplementedException;

public class HelloSolution {
    public String hello(String friendName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder).append("Hello, ").append(friendName).append("!");
        return stringBuilder.toString();
    }
}
