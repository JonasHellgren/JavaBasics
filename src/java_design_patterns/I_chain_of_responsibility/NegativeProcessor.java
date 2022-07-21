package java_design_patterns.I_chain_of_responsibility;

public class NegativeProcessor extends ProcessorAbstract {

    public NegativeProcessor(ProcessorAbstract nextProcessor){
        super(nextProcessor);
    }

    public void process(NumberWrapper request)
    {
        if (request.getNumber() < 0)
        {
            System.out.println("NegativeProcessor : " + request.getNumber());
        }
        else
        {
            super.process(request);
        }
    }
}
