package java_design_patterns.I_chain_of_responsibility;

abstract class ProcessorAbstract {
    private ProcessorAbstract nextProcessor;

    public ProcessorAbstract(ProcessorAbstract nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void process(NumberWrapper request) {
        if (nextProcessor != null)
            nextProcessor.process(request);
    }

}
