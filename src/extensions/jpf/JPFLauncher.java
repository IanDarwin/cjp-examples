package extensions.jpf;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.VM;
import gov.nasa.jpf.VMListener;

public class JPFLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		VMListener listener = new VMListener() {

			public void classLoaded(VM arg0) {
				System.out.println(".classLoaded()");
			}

			public void exceptionThrown(VM arg0) {
				System.out.println(".exceptionThrown()");
			}

			public void gcBegin(VM arg0) {
				System.out.println(".gcBegin()");
			}

			public void gcEnd(VM arg0) {
				System.out.println(".gcEnd()");
			}

			public void instructionExecuted(VM arg0) {
				System.out.println(".instructionExecuted()");
			}

			public void objectCreated(VM arg0) {
				System.out.println(".objectCreated()");
			}

			public void objectReleased(VM arg0) {
				System.out.println(".objectReleased()");
			}

			public void threadStarted(VM arg0) {
				System.out.println(".threadStarted()");
			}

			public void threadTerminated(VM arg0) {
				System.out.println(".threadTerminated()");
			}

		};

		Config config = JPF.createConfig(args);
		config.put("vm.class", "badcode.ThrowUncaughtException");

		JPF jpf = new JPF(config);
		jpf.addVMListener(listener);
		jpf.run();
	}
}
