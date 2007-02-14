package extensions.jpf;

import gov.nasa.jpf.jvm.JVM;
import gov.nasa.jpf.jvm.VMListener;

public class MyVMListener implements VMListener {

	private int threadsStarted;
	private int objectsCreated;
	private int insns;
	private int gcRuns;
	private int classesLoaded;
	private int exceptionsThrown;
	private int activeThreads;

	public void exceptionThrown(JVM arg0) {
		++exceptionsThrown;
	}

	public void gcBegin(JVM arg0) {
		++gcRuns;
	}

	public void gcEnd(JVM arg0) {
		// nothing to do
	}

	public void instructionExecuted(JVM arg0) {
		++insns;
	}

	public void objectCreated(JVM arg0) {
		++objectsCreated;
	}
	public void objectLocked(JVM arg0) {
		// TODO Auto-generated method stub
	}

	public void objectNotify(JVM arg0) {
		// TODO Auto-generated method stub
	}

	public void objectNotifyAll(JVM arg0) {
		// TODO Auto-generated method stub
	}

	public void objectUnlocked(JVM arg0) {
		// TODO Auto-generated method stub
	}

	public void objectWait(JVM arg0) {
		// TODO Auto-generated method stub
	}

	public void objectReleased(JVM arg0) {
		// nothing to do
	}

	public void threadStarted(JVM arg0) {
		++threadsStarted; ++activeThreads;
	}

	public void threadTerminated(JVM arg0) {
		if (--activeThreads == 0) {
			dumpState();
		}
	}


	public void choiceGeneratorAdvanced(JVM arg0) {
		// TODO Auto-generated method stub
	}

	public void choiceGeneratorProcessed(JVM arg0) {
		// TODO Auto-generated method stub
	}

	public void choiceGeneratorSet(JVM arg0) {
		// TODO Auto-generated method stub
	}

	public void classLoaded(JVM arg0) {
		++classesLoaded;
	}


	public void executeInstruction(JVM arg0) {
		// TODO Auto-generated method stub
	}


	public void threadBlocked(JVM arg0) {
		// TODO Auto-generated method stub
	}

	public void threadInterrupted(JVM arg0) {
		// TODO Auto-generated method stub
	}

	public void threadNotified(JVM arg0) {
		// TODO Auto-generated method stub
	}

	public void threadScheduled(JVM arg0) {
		// TODO Auto-generated method stub
	}

	public void threadWaiting(JVM arg0) {
		// TODO Auto-generated method stub
	}

	private void dumpState() {
		System.out.printf("%d threads created, %d objects created, %d total insns, gc ran %d times%n",
				threadsStarted,
				objectsCreated,
				insns,
				gcRuns);
	}

}
