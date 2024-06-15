package befaster.solutions.HLO;

import befaster.runner.SolutionNotImplementedException;

public class HelloSolution {
    public String hello(String friendName) {
//        throw new SolutionNotImplementedException();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder).append("Hello, World!");
        return stringBuilder.toString();
    }
}


