package java_design_patterns.G_mediator.wash;

public interface MachineMediator {
   void start();
   void wash();
   void openWaterValve();
   void closeWaterValve();
   void on();
   void off();
   boolean checkTemperature(int temp);
}
