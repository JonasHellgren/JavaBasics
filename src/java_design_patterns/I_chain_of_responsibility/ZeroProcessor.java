package java_design_patterns.I_chain_of_responsibility;

public class ZeroProcessor extends ProcessorAbstract {

    public ZeroProcessor(ProcessorAbstract nextProcessor){
        super(nextProcessor);
    }

    public void process(NumberWrapper request)
    {
        if (request.getNumber() == 0)
        {
            System.out.println("ZeroProcessor : " + request.getNumber());
        }
        else
        {
            super.process(request);
        }
    }
}
