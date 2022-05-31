# Concurrency

A thread executes a task. A task implements the Runnable interface. Ony one method run, thus a functional interface.


Main thread states are:  1) NEW 2) RUNNABLE 3) TERMINATED
It can be switched between RUNNABLE and WAITING

Calling wait() releases the key held by a thread. It is transferred to WAIT state.
Calling notify() releases a Thread in WAITING state. It is transferred to RUNNABLE state.

Visibility means a read should give the value set by the last write

Happen before link between two operations means value is known by last operation

Synchronized and volatile gives happen before link 

Synchronization gives exclusive execution of code block. Visibility gives consistency/sae reading of variables.

False sharing is a term which applies when threads unwittingly impact the performance of each other while modifying independent variables sharing the same cache line. 

Volatile keyword is used to modify the value of a variable by different threads. The volatile keyword can be used either with primitive type or objects.
The volatile keyword does not cache the value of the variable and always read the variable from the main memory. It prevents the compiler from the reordering of code.

Writing concurrent code:
* Check for race conditoins. More than one thread is reading a field.
* Check for happens-before link
* Synchronized or volatile? 