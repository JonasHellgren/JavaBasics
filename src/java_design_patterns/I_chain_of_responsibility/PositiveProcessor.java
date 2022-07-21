package java_design_patterns.I_chain_of_responsibility;

public class PositiveProcessor extends ProcessorAbstract {
    public PositiveProcessor(ProcessorAbstract nextProcessor){
        super(nextProcessor);
    }

    public void process(NumberWrapper request)
    {
        if (request.getNumber() > 0)
        {
            System.out.println("PositiveProcessor : " + request.getNumber());
        }
        else
        {
            super.process(request);
        }
    }
}
