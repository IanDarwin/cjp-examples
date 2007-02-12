package extensions.jpf;

import gov.nasa.jpf.VM;
import gov.nasa.jpf.VMListener;

public class MyVMListener implements VMListener {

	private int threadsStarted;
	private int objectsCreated;
	private int insns;
	private int gcRuns;
	private int classesLoaded;
	private int exceptionsThrown;
	private int activeThreads;

	public void classLoaded(VM arg0) {
		++classesLoaded;
	}

	public void exceptionThrown(VM arg0) {
		++exceptionsThrown;
	}

	public void gcBegin(VM arg0) {
		++gcRuns;
	}

	public void gcEnd(VM arg0) {
		// nothing to do
	}

	public void instructionExecuted(VM arg0) {
		++insns;
	}

	public void objectCreated(VM arg0) {
		++objectsCreated;
	}

	public void objectReleased(VM arg0) {
		// nothing to do
	}

	public void threadStarted(VM arg0) {
		++threadsStarted; ++activeThreads;
	}

	public void threadTerminated(VM arg0) {
		if (--activeThreads == 0) {
			dumpState();
		}
	}

	private void dumpState() {
		System.out.printf("%d threads created, %d objects created, %d total insns, gc ran %d times%n",
				threadsStarted,
				objectsCreated,
				insns,
				gcRuns);
	}


}
